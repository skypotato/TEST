package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.ProductImageDao;
import kr.or.skypotato.reservation.dto.ProductImage;
import kr.or.skypotato.reservation.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
	ProductImageDao productImageDao;

	public List<ProductImage> getAllProductImage(int displayInfoId) {
		return productImageDao.selectAll(displayInfoId);
	}
}
