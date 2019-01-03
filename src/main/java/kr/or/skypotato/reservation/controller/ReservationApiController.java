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
import kr.or.skypotato.reservation.dto.Comment;
import kr.or.skypotato.reservation.dto.DisplayInfo;
import kr.or.skypotato.reservation.dto.DisplayInfoImage;
import kr.or.skypotato.reservation.dto.Product;
import kr.or.skypotato.reservation.dto.ProductImage;
import kr.or.skypotato.reservation.dto.Promotion;
import kr.or.skypotato.reservation.service.CategoryService;
import kr.or.skypotato.reservation.service.CommentService;
import kr.or.skypotato.reservation.service.DisplayInfoImageService;
import kr.or.skypotato.reservation.service.DisplayInfoService;
import kr.or.skypotato.reservation.service.ProductImageService;
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
	@Autowired
	ProductImageService productImageService;
	@Autowired
	DisplayInfoImageService displayInfoImageService;
	@Autowired
	CommentService commentService;
	
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
		List<Product> products = productService.getAllProducts(categoryId);
		
		int totalCount = products.size();
		int end = start + LIMIT_AMT;
		
		if(end>totalCount) end=totalCount;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", totalCount);
		map.put("items", products.subList(start, end));
		return map;
	}
	// 2.2. 상품 전시 정보 구하기
	@GetMapping("/products/{displayInfoId}")
	public Map<String, Object> readOneDisplayProduct(@PathVariable(name="displayInfoId") int displayInfoId){
		DisplayInfo displayInfo = displayInfoService.getOneDisplayInfo(displayInfoId).get(0);
		DisplayInfoImage displayInfoImage = displayInfoImageService.getOneDisplayInfoImage(displayInfoId).get(0);
		
		List<ProductImage> productImages = productImageService.getAllProductImages(displayInfoId);
		List<Comment> comments = commentService.getAllComments(displayInfoId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("displayInfo", displayInfo);
		map.put("productImages", productImages);
		map.put("displayInfoImage", displayInfoImage);
		map.put("comments", comments);
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
