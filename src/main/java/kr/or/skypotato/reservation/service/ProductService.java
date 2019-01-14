package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.Product;

public interface ProductService {
	// 모든 상품 조회
	public List<Product> getAllProducts(int categoryId, int start, int limit);
	// 전체 상품 개수
	public int getTotalCount(int categoryId);
}
