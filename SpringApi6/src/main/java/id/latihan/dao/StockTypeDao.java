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

		StockType st = em.find(StockType.class, id);
		if (st == null) {
			return null;
		}
		return st;
	}

	public List<StockType> findAll() {
		Query query = em.createQuery("SELECT st FROM StockType st");
		List<StockType> list = query.getResultList();
		return list;
	}

	public void addStockType(String name) {
		StockType st = new StockType();
		st.setName(name);
		em.persist(st);
	}

	public int updateStockType(int id, String name) {
		return em.createQuery("UPDATE StockType st SET st.name=:name WHERE st.id=:id").setParameter("id", id).setParameter("name", name).executeUpdate();
	}

}
