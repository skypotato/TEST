package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.CategoryDao;
import kr.or.skypotato.reservation.dto.Category;
import kr.or.skypotato.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.selectAll();
	}
}
