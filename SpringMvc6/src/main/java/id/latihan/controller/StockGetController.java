package id.latihan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.latihan.api.service.StockService;
import id.latihan.api.service.StockTypeService;
import id.latihan.exception.ApplicationException;

@Controller
public class StockGetController {
	@Autowired(required = true)
	private StockService stockService;
	@Autowired(required = true)
	private StockTypeService stockTypeService;

	@GetMapping(value = { "/getstock" })
	public ModelAndView getStock(HttpSession session, RedirectAttributes attributes, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") == null) {
			attributes.addFlashAttribute("message", "Anda harus login untuk melihat halaman ini");
			mv.setViewName("redirect:/login");
		} else {
			mv.getModel().put("token", session.getAttribute("token"));
			try {
				mv.getModel().put("stock", stockService.getStock(id));
				mv.getModel().put("stocktype", stockTypeService.getAllStockType());
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				mv.getModel().put("message", e.getMessage());
			}
			mv.setViewName("/editstock");
		}

		return mv;
	}

	@GetMapping(value = { "/getallstock" })
	public ModelAndView getAllStock(HttpSession session, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") == null) {
			attributes.addFlashAttribute("message", "Anda harus login untuk melihat halaman ini");
			mv.setViewName("redirect:/login");
			return mv;
		} else {
			mv.getModel().put("token", session.getAttribute("token"));
			mv.getModel().put("stocks", stockService.getAllStock());
			mv.setViewName("/liststock");
		}

		return mv;
	}

	@GetMapping(value = { "/findstock" })
	public ModelAndView findStock(HttpSession session, RedirectAttributes attributes, @RequestParam String name) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") == null) {
			attributes.addFlashAttribute("message", "Anda harus login untuk melihat halaman ini");
			mv.setViewName("redirect:/login");
			return mv;
		} else {
			mv.getModel().put("token", session.getAttribute("token"));
			mv.getModel().put("stocks", stockService.findStock(name));
			mv.getModel().put("search", name);
			mv.setViewName("/liststock");
		}

		return mv;
	}

	@GetMapping(value = { "/addstock" })
	public ModelAndView addStock(HttpSession session, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("token") == null) {
			attributes.addFlashAttribute("message", "Anda harus login untuk melihat halaman ini");
			mv.setViewName("redirect:/login");
			return mv;
		} else {
			mv.getModel().put("token", session.getAttribute("token"));
			mv.getModel().put("stocktype", stockTypeService.getAllStockType());
			mv.setViewName("/addstock");
		}
		return mv;
	}
}
