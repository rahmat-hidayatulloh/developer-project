package id.latihan.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "stock")
public class Stock {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int sellingPrice;
	private int buyingPrice;
	private double weight;
	@ManyToOne(optional = true, targetEntity = void.class, fetch = FetchType.EAGER)
	private StockType stockType;
	private boolean active;

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

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", sellingPrice=" + sellingPrice + ", buyingPrice=" + buyingPrice
				+ ", weight=" + weight + ", active=" + active + "]";
	}

}
