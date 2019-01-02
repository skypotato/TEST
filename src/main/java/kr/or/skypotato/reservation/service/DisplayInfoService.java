package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.DisplayInfo;

public interface DisplayInfoService {
	public List<DisplayInfo> getOneDisplayInfo(int displayInfoId);
}
