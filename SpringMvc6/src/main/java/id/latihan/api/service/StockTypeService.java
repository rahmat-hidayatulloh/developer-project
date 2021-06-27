package id.latihan.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.latihan.dao.StockTypeDao;
import id.latihan.dao.UserDao;
import id.latihan.entity.StockType;
import id.latihan.entity.User;
import id.latihan.exception.ApplicationException;
import id.latihan.interfaces.IErrorCode;
import log.Log;

@Service()
@Transactional()
public class StockTypeService {
	@Autowired(required = true)
	private StockTypeDao stockTypeDao;
	@Autowired(required = true)
	private UserDao userDao;

	public StockType getStockType(int id) throws ApplicationException {
		Log.log(new Object[] { id });

		StockType st = stockTypeDao.findById(id);
		if (st == null) {
			throw new ApplicationException("Stock type dengan id " + id + " tidak ditemukan",
					IErrorCode.ERROR_STOCKTYPE_NOTFOUND);
		}

		Log.log(st);
		return st;
	}

	public List<StockType> getAllStockType() {
		List<StockType> list = stockTypeDao.findAll();
		Log.log(list);
		return list;
	}

	public void addStockType(String name, String token) throws ApplicationException {
		Log.log(new Object[] { name });

		User user = userDao.findByToken(token);
		if (user == null) {
			throw new ApplicationException("Token tidak valid", IErrorCode.ERROR_INVALID_TOKEN);
		}
		stockTypeDao.addStockType(name);
	}

	public void updateStockType(int id, String name, String token) throws ApplicationException {
		Log.log(new Object[] { id, name });

		User user = userDao.findByToken(token);
		if (user == null) {
			throw new ApplicationException("Token tidak valid", IErrorCode.ERROR_INVALID_TOKEN);
		}
		int st = stockTypeDao.updateStockType(id, name);
		if (st == 0) {
			throw new ApplicationException(
					"Update stock type dengan id " + id + " gagal karena stock type dengan id tersebut tidak ditemukan",
					IErrorCode.ERROR_STOCKTYPE_NOTFOUND);
		}

	}
}
