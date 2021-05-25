package id.latihan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.latihan.api.response.StockTypeResponse;
import id.latihan.api.response.StockTypesResponse;
import id.latihan.api.service.StockTypeService;
import id.latihan.exception.ApplicationException;
import id.latihan.interfaces.IErrorCode;

@RestController()
public class StockTypeGetController {

	@Autowired(required = true)
	private StockTypeService stockTypeService;

	@GetMapping(value = { "/getstocktype" })
	public StockTypeResponse getStockType(@RequestParam int id) {
		StockTypeResponse response = new StockTypeResponse();

		try {
			response.setStockType(stockTypeService.getStockType(id));
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

	@GetMapping(value = {"/getallstocktype"})
	public StockTypesResponse getAllStockType() {
		StockTypesResponse response = new StockTypesResponse();

		try {
			response.setStockType(stockTypeService.getAllStockType());
			response.setMessage("");
		} catch (Exception e) {
			// TODO: handle exception
			response.setErrorCode(IErrorCode.ERROR_GENERAL);
			response.setMessage("Terjadi kesalahan teknis pada server");
		}

		return response;
	}
}
