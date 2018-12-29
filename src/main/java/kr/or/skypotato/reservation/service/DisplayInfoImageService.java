package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.DisplayInfoImage;

public interface DisplayInfoImageService {
	public List<DisplayInfoImage> getAllDisplayInfoImagesByDisInfoId(int displayInfoId);
}
