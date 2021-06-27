package id.latihan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.latihan.api.service.StockTypeService;
import id.latihan.bean.StockTypeBean;
import id.latihan.exception.ApplicationException;

@Controller()
public class StockTypePostController {
	@Autowired(required = true)
	private StockTypeService stockTypeService;

	@PostMapping(value = { "/addstocktype" })
	public ModelAndView addStockType(RedirectAttributes attributes, @Valid StockTypeBean stockTypeBean) {
		ModelAndView mv = new ModelAndView();
		try {
			stockTypeService.addStockType(stockTypeBean.getName(), stockTypeBean.getToken());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			attributes.addFlashAttribute("message", e.getMessage());
		}
		mv.setViewName("redirect:/getallstocktype");
		return mv;
	}

	@PostMapping(value = { "/updatestocktype" })
	public ModelAndView updateStockType(RedirectAttributes attributes, @Valid StockTypeBean stockTypeBean,
			@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		try {
			stockTypeService.updateStockType(id, stockTypeBean.getName(), stockTypeBean.getToken());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			attributes.addFlashAttribute("message", e.getMessage());
		}
		mv.setViewName("redirect:/getstocktype?id=" + id);
		return mv;
	}

}
