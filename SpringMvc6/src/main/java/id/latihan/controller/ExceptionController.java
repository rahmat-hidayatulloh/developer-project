package id.latihan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class ExceptionController {
	@ExceptionHandler(value = { java.lang.Exception.class })
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/error");
		return mv;
	}
}
