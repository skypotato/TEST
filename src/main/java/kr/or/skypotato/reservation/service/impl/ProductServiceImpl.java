package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.ProductDao;
import kr.or.skypotato.reservation.dto.Product;
import kr.or.skypotato.reservation.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	public List<Product> getAllProducts(int start, int categoryId, int limit) {
		return productDao.selectAll(start, categoryId, limit);
	}

	public Product getOneProductByDisInfoId(int displayInfoId) {
		return productDao.selectOneByDisInfoId(displayInfoId);
	}

	public int getCount(int categoryId) {
		return productDao.selectCount(categoryId);
	}
}
