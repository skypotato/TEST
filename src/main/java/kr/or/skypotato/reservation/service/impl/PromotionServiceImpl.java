package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.PromotionDao;
import kr.or.skypotato.reservation.dto.Promotion;
import kr.or.skypotato.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	@Autowired
	PromotionDao promotionDao;

	@Override
	public List<Promotion> getAllPromotions() {
		return promotionDao.selectAll();
	}
}
