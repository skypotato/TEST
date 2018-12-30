package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.Product;
import kr.or.skypotato.reservation.dto.Promotion;

public interface PromotionService {
	// 모든 프로모션 조회
	public List<Promotion> getAllPromotions();
}
