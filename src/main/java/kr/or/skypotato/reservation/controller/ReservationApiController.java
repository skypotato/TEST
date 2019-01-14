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
import kr.or.skypotato.reservation.dto.ProductPrice;
import kr.or.skypotato.reservation.dto.Promotion;
import kr.or.skypotato.reservation.service.CategoryService;
import kr.or.skypotato.reservation.service.CommentService;
import kr.or.skypotato.reservation.service.DisplayInfoImageService;
import kr.or.skypotato.reservation.service.DisplayInfoService;
import kr.or.skypotato.reservation.service.ProductImageService;
import kr.or.skypotato.reservation.service.ProductPriceService;
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
	@Autowired
	ProductPriceService productPriceService;
	
	private static final int PRODUCT_LIMIT_AMOUNT = 4;
	
	@GetMapping("/categories")
	public Map<String, Object> readAllCategories() {
		List<Category> resultCategories = categoryService.getAllCategories();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("items", resultCategories);
		return map;
	}
	@GetMapping("/products")
	public Map<String, Object> readAllProducts(
			@RequestParam(name="start", required=false, defaultValue="0") int start,
			@RequestParam(name="categoryId", required=false, defaultValue="0") int categoryId
		){
		List<Product> resultProducts = productService.getAllProducts(categoryId, start, PRODUCT_LIMIT_AMOUNT);
		
		int totalCount = productService.getTotalCount(categoryId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", totalCount);
		map.put("items", resultProducts);
		return map;
	}
	@GetMapping("/products/{displayInfoId}")
	public Map<String, Object> readOneDisplayProduct(@PathVariable(name="displayInfoId") int displayInfoId){
		DisplayInfo displayInfo = displayInfoService.getOneDisplayInfo(displayInfoId).get(0);
		DisplayInfoImage displayInfoImage = displayInfoImageService.getOneDisplayInfoImage(displayInfoId).get(0);
		
		List<ProductImage> productImages = productImageService.getAllProductImages(displayInfoId);
		List<Comment> comments = commentService.getAllComments(displayInfoId);
		List<ProductPrice> productPrices = productPriceService.getAllProductPrices(displayInfoId);
		float averageScore = commentService.getAverageScore(displayInfoId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("displayInfo", displayInfo);
		map.put("productImages", productImages);
		map.put("displayInfoImage", displayInfoImage);
		map.put("comments", comments);
		map.put("averageScore", averageScore);
		map.put("productPrices", productPrices);
		return map;
	}
	@GetMapping("/promotions")
	public Map<String, Object> readAllPromotions() {
		List<Promotion> resultPromotions = promotionService.getAllPromotions();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("items", resultPromotions);
		return map;
	}
}
