package id.latihan.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.latihan.dao.UserDao;
import id.latihan.entity.User;
import id.latihan.exception.ApplicationException;
import id.latihan.interfaces.IErrorCode;
import log.Log;

@Service()
@Transactional()
public class LoginService {
	@Autowired(required = true)
	private UserDao userDao;

	public String login(String userName, String password) throws ApplicationException {
		Log.log(new Object[] { userName, password });

		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new ApplicationException("Pengguna tidak ditemukan", IErrorCode.ERROR_USER_NOTFOUND);
		}
		if (!password.equals(user.getPassword())) {
			throw new ApplicationException("Password tidak valid", IErrorCode.ERROR_INVALID_PASSWORD);
		}
		String token = Long.toString(System.currentTimeMillis());
		userDao.updateToken(user.getId(), token);

		return token;
	}

	public void logout(String token) throws ApplicationException {
		Log.log("");
		User user = userDao.findByToken(token);
		if (user == null) {
			throw new ApplicationException("Token tidak valid", IErrorCode.ERROR_INVALID_TOKEN);
		}

		token = Long.toString(System.currentTimeMillis());
		userDao.updateToken(user.getId(), token);
	}
}
