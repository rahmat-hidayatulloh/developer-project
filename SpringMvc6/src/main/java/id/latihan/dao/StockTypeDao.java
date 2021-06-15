package id.latihan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import id.latihan.entity.StockType;

@Repository()
public class StockTypeDao {
	private EntityManager em;

	public StockTypeDao(EntityManager em) {
		this.em = em;
	}

	public StockType findById(int id) {
		StockType st = null;
		st = em.find(StockType.class, id);
		return st;
	}

	public List<StockType> findAll() {
		return em.createQuery("SELECT st FROM StockType st").getResultList();
	}

	public void addStockType(String name) {
		StockType st = new StockType();
		st.setName(name);
		em.persist(st);
	}

	public int updateStockType(int id, String name) {
		Query query = em.createQuery("UPDATE StockType st SET st.name=:name WHERE st.id=:id");
		query.setParameter("id", id);
		query.setParameter("name", name);
		return query.executeUpdate();
	}
}
