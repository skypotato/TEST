package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.DisplayInfo;
import kr.or.skypotato.reservation.dto.ProductImage;

public interface ProductImageService {
	public List<ProductImage> getAllProductImages(int displayInfoId);
}
