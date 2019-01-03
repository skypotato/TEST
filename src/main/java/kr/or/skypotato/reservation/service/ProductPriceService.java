package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.ProductPrice;

public interface ProductPriceService {
	public List<ProductPrice> getAllProductPrices(int displayInfoId);		
}
