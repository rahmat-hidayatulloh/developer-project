package id.latihan.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.latihan.api.service.LoginService;
import id.latihan.bean.LoginBean;
import id.latihan.exception.ApplicationException;

@Controller()
public class LoginPostController {
	@Autowired(required = true)
	private LoginService loginService;

	@PostMapping(value = { "/login" })
	public ModelAndView login(HttpSession session, RedirectAttributes attributes, @Valid LoginBean loginBean) {
		ModelAndView mv = new ModelAndView();
		String token = null;
		try {
			token = loginService.login(loginBean.getUsername(), loginBean.getPassword());
			session.setAttribute("token", token);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			attributes.addFlashAttribute("message", e.getMessage());
			mv.setViewName("redirect:/login");
			return mv;
		}
		if (token != null) {
			attributes.addFlashAttribute("message", "Pengguna " + loginBean.getUsername() + " berhasil login");
			mv.setViewName("redirect:/mainmenu");
		}
		return mv;
	}
}
