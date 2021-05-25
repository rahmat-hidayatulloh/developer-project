package id.latihan.api.response;

import java.util.ArrayList;
import java.util.List;

import id.latihan.entity.Stock;

public class StocksResponse extends BaseResponse{
	private List<Stock> stock = new ArrayList<Stock>();

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	public void addStock(Stock stock) {
		this.stock.add(stock);
	}

}
