package id.latihan.api.response;

import id.latihan.entity.Stock;

public class StockResponse extends BaseResponse {

	private Stock stock;

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
