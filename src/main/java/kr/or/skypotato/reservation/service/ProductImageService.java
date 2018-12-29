package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.ProductImage;

public interface ProductImageService {
	public List<ProductImage> getAllProductImagesByDisInfoId(int displayInfoId);
}
