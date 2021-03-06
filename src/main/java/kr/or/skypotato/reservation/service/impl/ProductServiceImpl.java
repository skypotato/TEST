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

	public List<Product> getAllProducts(int categoryId, int start, int limit) {
		return productDao.selectAll(categoryId, start, limit);
	}

	@Override
	public int getTotalCount(int categoryId) {
		return productDao.countAll(categoryId);
	}
}
