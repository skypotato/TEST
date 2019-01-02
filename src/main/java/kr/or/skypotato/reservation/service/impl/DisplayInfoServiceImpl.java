package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.DisplayInfoDao;
import kr.or.skypotato.reservation.dto.DisplayInfo;
import kr.or.skypotato.reservation.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {
	@Autowired
	DisplayInfoDao displayInfoDao;

	public List<DisplayInfo> getOneDisplayInfo(int displayInfoId) {
		return displayInfoDao.selectOne(displayInfoId);
	}
}
