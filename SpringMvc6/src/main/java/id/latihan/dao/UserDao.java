package id.latihan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import id.latihan.entity.User;
import log.Log;

@Repository()
public class UserDao {
	private EntityManager em;

	public UserDao(EntityManager em) {
		this.em = em;
	}

	public User findByUserName(String userName) {
		Log.log(new Object[] { userName });

		User user = null;
		List<User> list = em.createQuery("SELECT u FROM User u WHERE u.userName=:userName")
				.setParameter("userName", userName).getResultList();
		if (list.size() != 0) {
			user = list.get(0);
		}

		Log.log(user);
		return user;
	}

	public int updateToken(int id, String token) {
		Log.log(new Object[] { id });

		Query query = em.createQuery("UPDATE User u SET u.token=:token WHERE u.id=:id");
		query.setParameter("id", id);
		query.setParameter("token", token);

		int result = query.executeUpdate();
		Log.log(result);
		return result;
	}

	public User findByToken(String token) {
		User user = null;
		Query query = em.createQuery("SELECT u FROM User u WHERE u.token=:token").setParameter("token", token);

		try {
			user = (User) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		Log.log(user);
		return user;
	}
}
