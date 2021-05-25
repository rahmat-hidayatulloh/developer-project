package id.latihan.api.response;

import java.util.ArrayList;
import java.util.List;

import id.latihan.entity.StockType;

public class StockTypesResponse extends BaseResponse {
	private List<StockType> stockType = new ArrayList<StockType>();

	public List<StockType> getStockType() {
		return stockType;
	}

	public void setStockType(List<StockType> stockType) {
		this.stockType = stockType;
	}
	
	public void addStockType(StockType stockType) {
		this.stockType.add(stockType);
	}

}
