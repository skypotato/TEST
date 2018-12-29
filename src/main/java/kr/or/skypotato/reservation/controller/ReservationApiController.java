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
import kr.or.skypotato.reservation.dto.DisplayInfoImage;
import kr.or.skypotato.reservation.dto.Product;
import kr.or.skypotato.reservation.dto.ProductImage;
import kr.or.skypotato.reservation.dto.ProductPrice;
import kr.or.skypotato.reservation.dto.Promotion;
import kr.or.skypotato.reservation.dto.ReservationUserComment;
import kr.or.skypotato.reservation.dto.ReservationUserCommentImage;
import kr.or.skypotato.reservation.service.CategoryService;
import kr.or.skypotato.reservation.service.DisplayInfoImageService;
import kr.or.skypotato.reservation.service.ProductImageService;
import kr.or.skypotato.reservation.service.ProductPriceService;
import kr.or.skypotato.reservation.service.ProductService;
import kr.or.skypotato.reservation.service.PromotionService;
import kr.or.skypotato.reservation.service.ReservationUserCommentImageService;
import kr.or.skypotato.reservation.service.ReservationUserCommentService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	@Autowired
	PromotionService promotionService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	ProductImageService  productImageService;
	@Autowired
	DisplayInfoImageService displayInfoImageService;
	@Autowired
	ReservationUserCommentService reservationUserCommentService;
	@Autowired
	ReservationUserCommentImageService reservationUserCommentImageService;
	@Autowired
	ProductPriceService productPriceService;
	
	@GetMapping("/categories")
	public Map<String, Object> readAllCategories() {
		List<Category> resultCategories = categoryService.getAllCategories();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("items", resultCategories);
		map.put("size", resultCategories.size());
		return map;
	}	
	
	@GetMapping("/products")
	public Map<String, Object> readAllProducts(
			@RequestParam(name="start", required=false, defaultValue="0") int start,
			@RequestParam(name="categoryId", required=false, defaultValue="0") int categoryId
		) {
		final int LIMIT = 4;
		List<Product> resultProducts = productService.getAllProducts(start, categoryId, LIMIT);
		int totalCount = productService.getCount(categoryId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", totalCount);
		map.put("productsCount", resultProducts.size());
		map.put("products", resultProducts);
		
		return map;
	}
	@GetMapping("/products/{displayInfoId}")
	public Map<String, Object> readOneProduct(@PathVariable(name="displayInfoId") int displayInfoId) {
		Product resultProduct = productService.getOneProductByDisInfoId(displayInfoId);
		List<ProductImage> resultPrdImgs = productImageService.getAllProductImagesByDisInfoId(displayInfoId);
		List<DisplayInfoImage> resultDisImgs = displayInfoImageService.getAllDisplayInfoImagesByDisInfoId(displayInfoId);
		List<ReservationUserComment> resultUserComments = reservationUserCommentService.getAllReservationUserCommentsByDisInfoId(displayInfoId);
		List<ProductPrice> resultPrdPrices = productPriceService.getAllProductPricesByDisInfoId(displayInfoId);
		
		double totlScore = 0.0;
		for(int i=0;i<resultUserComments.size();i++){
			ReservationUserComment comment = resultUserComments.get(i);
			int commentId = comment.getId();
			double score = comment.getScore();
			totlScore += score;
			List<ReservationUserCommentImage> resultUserCommentImages = reservationUserCommentImageService.getAllReservationUserCommentImages(commentId);
			comment.setReservationUserCommentImages(resultUserCommentImages);
			resultUserComments.set(i, comment);
		}
		double avgScore = Math.round(totlScore / resultUserComments.size() * 10)/10;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("products", resultProduct);
		map.put("productImages", resultPrdImgs);
		map.put("displayInfoImages", resultDisImgs);
		map.put("comments", resultUserComments);
		map.put("avgScore", avgScore);
		map.put("productPrices", resultPrdPrices);
		return map;
	}
	
	@GetMapping("/promotions")
	public Map<String, Object> readAllPromotions() {
		List<Promotion> resultPromotions = promotionService.getAllPromotions();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("items", resultPromotions);
		map.put("size", resultPromotions.size());
		return map;
	}	
}
