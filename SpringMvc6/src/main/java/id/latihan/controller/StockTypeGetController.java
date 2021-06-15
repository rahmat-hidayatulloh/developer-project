package id.latihan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.latihan.api.service.StockTypeService;
import id.latihan.entity.StockType;
import id.latihan.exception.ApplicationException;

@Controller()
public class StockTypeGetController {

	@Autowired(required = true)
	private StockTypeService stockTypeService;

	@GetMapping(value = { "/getstocktype" })
	public ModelAndView getStockType(HttpSession session, RedirectAttributes attributes, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();

		if (session.getAttribute("token") == null) {
			attributes.addFlashAttribute("message", "Anda harus login untuk melihat halaman ini");
			mv.setViewName("redirect:/login");
		}

		mv.getModel().put("token", session.getAttribute("token"));
		try {
			mv.getModel().put("stocktype", stockTypeService.getStockType(id));
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			attributes.addFlashAttribute("message", e.getMessage());
		}
		mv.setViewName("/editstocktype");

		return mv;
	}

	@GetMapping(value = { "/getallstocktype" })
	public ModelAndView getAllStockType(HttpSession session, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") == null) {
			attributes.addFlashAttribute("message", "Anda harus login untuk melihat halaman ini");
			mv.setViewName("redirect:/login");
		}
		mv.getModel().put("stocktypes", stockTypeService.getAllStockType());
		mv.setViewName("/liststocktype");

		return mv;
	}

	@GetMapping(value = { "/addstocktype" })
	public ModelAndView addStockType(HttpSession session, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") == null) {
			attributes.addFlashAttribute("message", "Anda harus login untuk melihat halaman ini");
			mv.setViewName("redirect:/login");
		}
		mv.getModel().put("token", session.getAttribute("token"));
		mv.setViewName("/addstocktype");
		return mv;
	}
}
