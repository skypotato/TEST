package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.Category;

public interface CategoryService {
	// 모든 카테고리 조회
	public List<Category> getAllCategories();
}
