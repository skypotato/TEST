package kr.or.skypotato.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.skypotato.reservation.dto.Category;
import kr.or.skypotato.reservation.service.CategoryService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public Map<String, Object> readAllCategories() {
		List<Category> resultCategories = categoryService.getAllCategories();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("items", resultCategories);
		map.put("size", resultCategories.size());
		return map;
	}
}
