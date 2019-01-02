package kr.or.skypotato.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.skypotato.reservation.dto.Category;
import kr.or.skypotato.reservation.dto.DisplayInfo;
import kr.or.skypotato.reservation.dto.Product;
import kr.or.skypotato.reservation.dto.Promotion;
import kr.or.skypotato.reservation.service.CategoryService;
import kr.or.skypotato.reservation.service.DisplayInfoService;
import kr.or.skypotato.reservation.service.ProductService;
import kr.or.skypotato.reservation.service.PromotionService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	PromotionService promotionService;
	@Autowired
	DisplayInfoService displayInfoService;
	
	// 1.1. 카테고리 목록 구하기
	@GetMapping("/categories")
	public Map<String, Object> readAllCategories() {
		List<Category> resultCategories = categoryService.getAllCategories();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("items", resultCategories);
		return map;
	}
	// 2.1. 상품 목록 구하기
	@GetMapping("/products")
	public Map<String, Object> readAllDisplayProducts(
			@RequestParam(name="start", required=false, defaultValue="0") int start,
			@RequestParam(name="categoryId", required=false, defaultValue="0") int categoryId
		){
		final int LIMIT_AMT = 4;
		List<Product> resultProducts = productService.getAllProducts(categoryId);
		
		int totalCount = resultProducts.size();
		int end = start + LIMIT_AMT;
		
		if(end>totalCount) end=totalCount;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", totalCount);
		map.put("items", resultProducts.subList(start, end));
		return map;
	}
	// 2.2. 상품 전시 정보 구하기
	@GetMapping("/products/{displayInfoId}")
	public Map<String, Object> readOneDisplayProduct(@PathVariable(name="displayInfoId") int displayInfoId){
		DisplayInfo displayInfo = displayInfoService.getOneDisplayInfo(displayInfoId).get(0);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("displayInfo", displayInfo);
		return map;
	}
	// 3.3. 프로모션 정보 구하기
	@GetMapping("/promotions")
	public Map<String, Object> readAllPromotions() {
		List<Promotion> resultPromotions = promotionService.getAllPromotions();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("items", resultPromotions);
		return map;
	}
}
