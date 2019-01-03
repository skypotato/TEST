package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.ProductPriceDao;
import kr.or.skypotato.reservation.dto.ProductPrice;
import kr.or.skypotato.reservation.service.ProductPriceService;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {
	@Autowired
	ProductPriceDao productPriceDao;
	
	@Override
	public List<ProductPrice> getAllProductPrices(int displayInfoId) {
		return productPriceDao.selectAll(displayInfoId);
	}

}
