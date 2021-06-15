package id.latihan.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.latihan.dao.StockDao;
import id.latihan.dao.StockTypeDao;
import id.latihan.dao.UserDao;
import id.latihan.entity.Stock;
import id.latihan.entity.StockType;
import id.latihan.entity.User;
import id.latihan.exception.ApplicationException;
import id.latihan.interfaces.IErrorCode;

@Service()
@Transactional()
public class StockService {
	@Autowired(required = true)
	private StockDao stockDao;
	@Autowired(required = true)
	private StockTypeDao stockTypeDao;
	@Autowired(required = true)
	private UserDao userDao;

	public void deleteStock(int id, String token) throws ApplicationException {
		User user = userDao.findByToken(token);
		if (user == null) {
			throw new ApplicationException("Token tidak valid", IErrorCode.ERROR_INVALID_TOKEN);
		}
		int result = stockDao.deleteStock(id);
		if (result == 0) {
			throw new ApplicationException(
					"Delete stock dengan id " + id + " gagal karena stock dengan id tersebut tidak ditemukan",
					IErrorCode.ERROR_STOCK_NOTFOUND);
		}
	}

	public void updateStock(int id, String name, int sellingPrice, int buyingPrice, double weight, int stockType,
			boolean active, String token) throws ApplicationException {
		User user = userDao.findByToken(token);
		if (user == null) {
			throw new ApplicationException("Token tidak valid", IErrorCode.ERROR_INVALID_TOKEN);
		}
		StockType st = stockTypeDao.findById(stockType);
		if (st == null) {
			throw new ApplicationException("Stock type dengan id " + stockType + " tidak ditemukan",
					IErrorCode.ERROR_STOCKTYPE_NOTFOUND);
		}
		int result = stockDao.updateStock(id, name, sellingPrice, buyingPrice, weight, st, active);
		if (result == 0) {
			throw new ApplicationException(
					"Update stock dengan id " + id + " gagal karena stock dengan id tersebut tidak ditemukan",
					IErrorCode.ERROR_STOCK_NOTFOUND);
		}
	}

	public Stock getStock(int id) throws ApplicationException {
		Stock stock = stockDao.findById(id);
		if (stock == null) {
			throw new ApplicationException("Stock dengan id " + id + " tidak ditemukan",
					IErrorCode.ERROR_STOCK_NOTFOUND);
		}

		return stock;
	}

	public List<Stock> getAllStock() {
		return stockDao.findAll();
	}

	public List findStock(String name) {
		return stockDao.findByName(name);
	}

	public void addStock(String name, int sellingPrice, int buyingPrice, double weight, int stockType, boolean active,
			String token) throws ApplicationException {
		User user = userDao.findByToken(token);
		if (user == null) {
			throw new ApplicationException("Token tidak valid", IErrorCode.ERROR_INVALID_TOKEN);
		}
		StockType st = stockTypeDao.findById(stockType);
		if (st == null) {
			throw new ApplicationException("Stock type dengan id " + stockType + " tidak ditemukan",
					IErrorCode.ERROR_STOCKTYPE_NOTFOUND);
		}

		stockDao.addStock(name, sellingPrice, buyingPrice, weight, st, active);

	}
}
