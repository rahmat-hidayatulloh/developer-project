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
		return em.createQuery("SELECT s FROM Stock s WHERE s.name LIKE :name").setParameter("name", "%" + name + "%")
				.getResultList();
	}

	public int deleteStock(int id) {
		return em.createQuery("DELETE FROM Stock s WHERE s.id=:id").setParameter("id", id).executeUpdate();
	}

	public int updateStock(int id, String name, int sellingPrice, int buyingPrice, double weight, StockType stockType,
			boolean active) {
		Query query = em.createQuery(
				"UPDATE Stock s SET s.name=:name,s.sellingPrice=:sellingPrice,s.buyingPrice=:buyingPrice,s.weight=:weight,s.stockType=:stockType,s.active=:active WHERE s.id=:id");
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
		Stock s = null;
		s = em.find(Stock.class, id);
		return s;
	}

	public void addStock(String name, int sellingPrice, int buyingPrice, double weight, StockType stockType,
			boolean active) {
		Stock s = new Stock();
		s.setName(name);
		s.setSellingPrice(sellingPrice);
		s.setBuyingPrice(buyingPrice);
		s.setWeight(weight);
		s.setStockType(stockType);
		s.setActive(active);
		em.persist(s);
	}

}
