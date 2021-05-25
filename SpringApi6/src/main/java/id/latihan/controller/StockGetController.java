package id.latihan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.latihan.api.response.StockResponse;
import id.latihan.api.response.StocksResponse;
import id.latihan.api.service.StockService;
import id.latihan.exception.ApplicationException;
import id.latihan.interfaces.IErrorCode;

@RestController()
public class StockGetController {
	@Autowired(required = true)
	private StockService stockService;

	@GetMapping({ "/getstock" })
	public StockResponse getStock(@RequestParam int id) {
		StockResponse response = new StockResponse();
		try {
			response.setStock(stockService.getStock(id));
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

	@GetMapping(value = { "/getallstock" })
	public StocksResponse getAllStock() {

		StocksResponse response = new StocksResponse();
		try {
			response.setStock(stockService.getAllStock());
			response.setMessage("");
		} catch (Exception e) {
			// TODO: handle exception
			response.setErrorCode(IErrorCode.ERROR_GENERAL);
			response.setMessage("Terjadi kesalahan teknis pada server");
		}

		return response;
	}

	@GetMapping(value = { "/findstock" })
	public StocksResponse findStock(@RequestParam String name) {
		StocksResponse response = new StocksResponse();
		try {
			response.setStock(stockService.findStock(name));
			response.setMessage("");
		} catch (Exception e) {
			// TODO: handle exception
			response.setErrorCode(IErrorCode.ERROR_GENERAL);
			response.setMessage("Terjadi kesalahan teknis pada server");
		}

		return response;
	}

}
