package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.Product;

public interface ProductService {
	public List<Product> getAllProducts(int start, int categoryId, int limit);

	public Product getOneProductByDisInfoId(int displayInfoId);

	public int getCount(int categoryId);
}
