package id.latihan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.latihan.api.service.LoginService;
import id.latihan.exception.ApplicationException;

@Controller()
public class IndexController {
	@Autowired(required = true)
	private LoginService loginService;

	@GetMapping(value = { "/" })
	public ModelAndView index(HttpSession session, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") != null) {
			mv.setViewName("redirect:/mainmenu");
		} else {
			mv.setViewName("/login");
			return mv;
		}

		return mv;
	}

	@GetMapping(value = { "/mainmenu" })
	public ModelAndView mainmenu(HttpSession session, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") == null) {
			attributes.addFlashAttribute("message", "Anda harus login untuk melihat halaman ini");
			mv.setViewName("redirect:/login");
			return mv;
		}
		mv.getModel().put("token", session.getAttribute("token"));
		mv.setViewName("/mainmenu");

		return mv;
	}

	@GetMapping(value = { "/logout" })
	public ModelAndView logout(HttpSession session, RedirectAttributes attributes, @RequestParam String token) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") == null) {
			attributes.addFlashAttribute("message", "Anda harus login untuk melihat halaman ini");
			mv.setViewName("redirect:/login");
			return mv;
		}
		try {
			loginService.logout(token);
			session.invalidate();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			attributes.addFlashAttribute("message","");
			mv.setViewName("redirect:/mainmenu");
		}
		attributes.addFlashAttribute("message", "User telah logout");
		mv.setViewName("redirect:/login");

		return mv;
	}

	@GetMapping(value = { "/login" })
	public ModelAndView login(HttpSession session, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("token") != null) {
			mv.setViewName("redirect:/mainmenu");
		} else {
			mv.setViewName("/login");
			return mv;
		}
		return mv;
	}
}
