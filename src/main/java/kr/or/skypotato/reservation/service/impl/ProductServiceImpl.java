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

	@Override
	public List<Product> getAllProducts(int categoryId) {
		return productDao.selectAll(categoryId);
	}
}
