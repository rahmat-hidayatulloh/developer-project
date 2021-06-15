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

@Service()
@Transactional()
public class StockTypeService {
	@Autowired(required = true)
	private StockTypeDao stockTypeDao;
	@Autowired(required = true)
	private UserDao userDao;

	public StockType getStockType(int id) throws ApplicationException {
		StockType st = stockTypeDao.findById(id);
		if (st == null) {
			throw new ApplicationException("Stock type dengan id " + id + " tidak ditemukan",
					IErrorCode.ERROR_STOCKTYPE_NOTFOUND);
		}
		return st;
	}

	public List<StockType> getAllStockType() {
		return stockTypeDao.findAll();
	}

	public void addStockType(String name, String token) throws ApplicationException {
		User user = userDao.findByToken(token);
		if (user == null) {
			throw new ApplicationException("Token tidak valid", IErrorCode.ERROR_INVALID_TOKEN);
		}
		stockTypeDao.addStockType(name);
	}

	public void updateStockType(int id, String name, String token) throws ApplicationException {
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
