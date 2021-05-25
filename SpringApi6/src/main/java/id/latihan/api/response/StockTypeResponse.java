package id.latihan.api.response;

import id.latihan.entity.StockType;

public class StockTypeResponse extends BaseResponse {
	private StockType stockType;

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

}
