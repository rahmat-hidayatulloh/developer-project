package id.latihan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.latihan.api.service.StockService;
import id.latihan.bean.DeleteStockBean;
import id.latihan.bean.StockBean;
import id.latihan.exception.ApplicationException;

@Controller()
public class StockPostController {
	@Autowired(required = true)
	private StockService stockService;

	@PostMapping(value = { "/addstock" })
	public ModelAndView addStock(RedirectAttributes attributes, @Valid StockBean stockBean) {
		ModelAndView mv = new ModelAndView();
		try {
			stockService.addStock(stockBean.getName(), stockBean.getSellingPrice(), stockBean.getBuyingPrice(),
					stockBean.getWeight(), stockBean.getStockType(), stockBean.isActive(), stockBean.getToken());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			attributes.addFlashAttribute("message", e.getMessage());
		}
		mv.setViewName("redirect:/getallstock");
		return mv;
	}

	@PostMapping(value = { "/updatestock" })
	public ModelAndView updateStock(RedirectAttributes attributes, @Valid StockBean stockBean, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		try {
			stockService.updateStock(id, stockBean.getName(), stockBean.getSellingPrice(), stockBean.getBuyingPrice(),
					stockBean.getWeight(), stockBean.getStockType(), stockBean.isActive(), stockBean.getToken());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			attributes.addFlashAttribute("message", e.getMessage());
		}
		mv.setViewName("redirect:/getstock?id="+id);
		return mv;
	}

	@PostMapping(value = { "/deletestock" })
	public ModelAndView deleteStock(RedirectAttributes attributes, @Valid DeleteStockBean deleteStockBean) {
		ModelAndView mv = new ModelAndView();
		try {
			stockService.deleteStock(deleteStockBean.getId(), deleteStockBean.getToken());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			attributes.addFlashAttribute("message", e.getMessage());
		}
		mv.setViewName("redirect:/getallstock");
		return mv;

	}
}
