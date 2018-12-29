package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.DisplayInfoImageDao;
import kr.or.skypotato.reservation.dto.DisplayInfoImage;
import kr.or.skypotato.reservation.service.DisplayInfoImageService;

@Service
public class DisplayInfoImageServiceImpl implements DisplayInfoImageService {

	@Autowired
	DisplayInfoImageDao displayInfoImageDao;
	
	@Override
	public List<DisplayInfoImage> getAllDisplayInfoImagesByDisInfoId(int displayInfoId) {
		return displayInfoImageDao.selectAllByDisInfoId(displayInfoId);
	}

}
