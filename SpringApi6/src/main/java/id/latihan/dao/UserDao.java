package id.latihan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import id.latihan.entity.User;

@Repository()
public class UserDao {
	private EntityManager em;

	public UserDao(EntityManager em) {
		this.em = em;
	}

	public User findByUserName(String userName) {
		User user = null;
		List<User> list = em.createQuery("SELECT u FROM User u WHERE u.userName=:userName")
				.setParameter("userName", userName).getResultList();
		for (User obj : list) {
			user = obj;
		}
		return user;
	}

	public int updateToken(int id, String token) {
		int result;
		Query query = em.createQuery("UPDATE User u SET u.token=:token WHERE u.id=:id");
		query.setParameter("id", id);
		query.setParameter("token", token);
		result = query.executeUpdate();
		return result;
	}

	public User findByToken(String token) {
		User user = null;
		List<User> list = em.createQuery("SELECT u FROM User u WHERE u.token=:token").setParameter("token", token)
				.getResultList();
		for (User obj : list) {
			user = obj;
		}

		return user;
	}

}
