package id.latihan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import id.latihan.entity.Stock;
import id.latihan.entity.StockType;

@Repository()
public class StockDao {

	private EntityManager em;

	public StockDao(EntityManager em) {
		this.em = em;
	}

	public List<Stock> findAll() {
		return em.createQuery("SELECT s FROM Stock s").getResultList();
	}

	public List<Stock> findByName(String name) {
		return em.createQuery("Select s FROM Stock s WHERE s.name LIKE :name").setParameter("name", "%"+name+"%").getResultList();
	}

	public int deleteStock(int id) {
		return em.createQuery("DELETE FROM Stock s WHERE s.id=:id").setParameter("id", id).executeUpdate();
	}

	public int updateStock(int id, String name, int sellingPrice, int buyingPrice, double weight, StockType stockType,
			boolean active) {
		Query query = em.createQuery(
				"UPDATE Stock s SET s.name=:name, s.sellingPrice=:sellingPrice, s.buyingPrice=:buyingPrice, s.weight=:weight, s.stockType=:stockType, s.active=:active WHERE s.id=:id");
		query.setParameter("id", id);
		query.setParameter("name", name);
		query.setParameter("sellingPrice", sellingPrice);
		query.setParameter("buyingPrice", buyingPrice);
		query.setParameter("weight", weight);
		query.setParameter("stockType", stockType);
		query.setParameter("active", active);

		return query.executeUpdate();
	}

	public Stock findById(int id) {
		Stock stock = null;
		stock = em.find(Stock.class, id);
		return stock;
	}

	public void addStock(String name, int sellingPrice, int buyingPrice, double weight, StockType stockType,
			boolean active) {
		Stock stock = new Stock();
		stock.setName(name);
		stock.setSellingPrice(sellingPrice);
		stock.setBuyingPrice(buyingPrice);
		stock.setWeight(weight);
		stock.setStockType(stockType);
		stock.setActive(active);
		em.persist(stock);
	}
}
