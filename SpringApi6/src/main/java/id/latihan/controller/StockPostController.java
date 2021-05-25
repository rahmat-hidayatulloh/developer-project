package id.latihan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.latihan.api.response.BaseResponse;
import id.latihan.api.response.StockResponse;
import id.latihan.api.service.StockService;
import id.latihan.entity.Stock;
import id.latihan.exception.ApplicationException;
import id.latihan.interfaces.IErrorCode;

@RestController()
public class StockPostController {

	@Autowired(required = true)
	private StockService stockService;

	@PostMapping(value = { "/addstock" })
	public StockResponse addStock(@RequestBody Stock stock, @RequestHeader String token) {
		StockResponse response = new StockResponse();
		try {
			stockService.addStock(stock.getName(), stock.getSellingPrice(), stock.getBuyingPrice(), stock.getWeight(),
					stock.getStockType().getId(), stock.isActive(), token);
			response.setStock(stock);
			response.setMessage("");
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			response.setErrorCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} 
		return response;
	}

	@PostMapping(value = { "/updatestock" })
	public StockResponse updateStock(@RequestBody Stock stock, @RequestHeader String token) {
		StockResponse response = new StockResponse();

		try {
			stockService.updateStock(stock.getId(), stock.getName(), stock.getSellingPrice(), stock.getBuyingPrice(),
					stock.getWeight(), stock.getStockType().getId(), stock.isActive(), token);
			response.setStock(stock);
			response.setMessage("");
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			response.setErrorCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			response.setErrorCode(IErrorCode.ERROR_GENERAL);
			response.setMessage("Terjadi kesalahan teknis pada server");
		}

		return response;
	}

	@PostMapping(value = { "/deletestock" })
	public BaseResponse deleteStock(@RequestParam int id, @RequestHeader String token) {
		BaseResponse response = new BaseResponse();

		try {
			stockService.deleteStock(id, token);
			response.setMessage("");
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			response.setErrorCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			response.setErrorCode(IErrorCode.ERROR_GENERAL);
			response.setMessage("Terjadi kesalahan teknis pada server");
		}

		return response;
	}
}
