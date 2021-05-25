package id.latihan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.latihan.api.response.StockTypeResponse;
import id.latihan.api.service.StockTypeService;
import id.latihan.entity.StockType;
import id.latihan.exception.ApplicationException;
import id.latihan.interfaces.IErrorCode;

@RestController()
public class StockTypePostController {
	@Autowired(required = true)
	private StockTypeService stockTypeService;

	@PostMapping(value = { "/addstocktype" })
	public StockTypeResponse addStock(@RequestBody StockType stockType, @RequestHeader String token) {
		StockTypeResponse response = new StockTypeResponse();
		try {
			stockTypeService.addStockType(stockType.getName(), token);
			response.setStockType(stockType);
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

	@PostMapping(value = { "/updatestocktype" })
	public StockTypeResponse updateStock(@RequestBody StockType stockType, @RequestHeader String token) {
		StockTypeResponse response = new StockTypeResponse();
		try {
			stockTypeService.updateStockType(stockType.getId(), stockType.getName(), token);
			response.setStockType(stockType);
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
