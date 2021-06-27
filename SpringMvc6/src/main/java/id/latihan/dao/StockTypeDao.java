package id.latihan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import id.latihan.entity.StockType;
import log.Log;

@Repository()
public class StockTypeDao {
	private EntityManager em;

	public StockTypeDao(EntityManager em) {
		this.em = em;
	}

	public StockType findById(int id) {
		Log.log(new Object[] { id });

		StockType st = null;
		st = em.find(StockType.class, id);

		Log.log(st);
		return st;
	}

	public List<StockType> findAll() {
		List<StockType> list = em.createQuery("SELECT st FROM StockType st").getResultList();

		Log.log(list);
		return list;
	}

	public void addStockType(String name) {
		Log.log(new Object[] { name });

		StockType st = new StockType();
		st.setName(name);
		em.persist(st);
	}

	public int updateStockType(int id, String name) {
		Log.log(new Object[] { id, name });

		Query query = em.createQuery("UPDATE StockType st SET st.name=:name WHERE st.id=:id");
		query.setParameter("id", id);
		query.setParameter("name", name);
		int result = query.executeUpdate();

		Log.log(result);
		return result;
	}
}
