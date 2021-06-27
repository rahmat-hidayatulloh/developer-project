package id.latihan.bean;

public class StockBean {
	private int id;
	private String name;
	private int sellingPrice;
	private int buyingPrice;
	private double weight;
	private int stockType;
	private boolean active;
	private String token;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockBean [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", sellingPrice=");
		builder.append(sellingPrice);
		builder.append(", buyingPrice=");
		builder.append(buyingPrice);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", stockType=");
		builder.append(stockType);
		builder.append(", active=");
		builder.append(active);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}

}
