package id.latihan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import id.latihan.entity.Stock;
import id.latihan.entity.StockType;
import log.Log;

@Repository()
public class StockDao {

	private EntityManager em;

	public StockDao(EntityManager em) {
		this.em = em;
	}

	public List<Stock> findAll() {
		List<Stock> list = em.createQuery("SELECT s FROM Stock s").getResultList();

		Log.log(list);
		return list;
	}

	public List<Stock> findByName(String name) {
		Log.log(new Object[] { name });

		List<Stock> list = em.createQuery("SELECT s FROM Stock s WHERE s.name LIKE :name")
				.setParameter("name", "%" + name + "%").getResultList();

		Log.log(list);
		return list;
	}

	public int deleteStock(int id) {
		Log.log(new Object[] { id });
		int result = em.createQuery("DELETE FROM Stock s WHERE s.id=:id").setParameter("id", id).executeUpdate();

		Log.log(result);
		return result;
	}

	public int updateStock(int id, String name, int sellingPrice, int buyingPrice, double weight, StockType stockType,
			boolean active) {
		Log.log(new Object[] { id, name, sellingPrice, buyingPrice, weight, stockType, active });

		Query query = em.createQuery(
				"UPDATE Stock s SET s.name=:name,s.sellingPrice=:sellingPrice,s.buyingPrice=:buyingPrice,s.weight=:weight,s.stockType=:stockType,s.active=:active WHERE s.id=:id");
		query.setParameter("id", id);
		query.setParameter("name", name);
		query.setParameter("sellingPrice", sellingPrice);
		query.setParameter("buyingPrice", buyingPrice);
		query.setParameter("weight", weight);
		query.setParameter("stockType", stockType);
		query.setParameter("active", active);

		int result = query.executeUpdate();
		Log.log(result);
		return result;
	}

	public Stock findById(int id) {
		Log.log(new Object[] { id });

		Stock stock = null;
		stock = em.find(Stock.class, id);

		Log.log(stock);
		return stock;
	}

	public void addStock(String name, int sellingPrice, int buyingPrice, double weight, StockType stockType,
			boolean active) {
		Log.log(new Object[] { name, sellingPrice, buyingPrice, weight, stockType, active });

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
