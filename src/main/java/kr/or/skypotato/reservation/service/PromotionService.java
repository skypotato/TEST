package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.Category;
import kr.or.skypotato.reservation.dto.Product;
import kr.or.skypotato.reservation.dto.Promotion;

public interface PromotionService {
	public List<Promotion> getAllPromotions();
}
