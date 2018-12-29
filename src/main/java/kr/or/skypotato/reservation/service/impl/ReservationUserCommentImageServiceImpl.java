package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.ReservationUserCommentImageDao;
import kr.or.skypotato.reservation.dto.ReservationUserCommentImage;
import kr.or.skypotato.reservation.service.ReservationUserCommentImageService;

@Service
public class ReservationUserCommentImageServiceImpl implements ReservationUserCommentImageService {

	@Autowired
	ReservationUserCommentImageDao reservationUserCommentImageDao;
	
	@Override
	public List<ReservationUserCommentImage> getAllReservationUserCommentImages(int id) {
		return reservationUserCommentImageDao.selectAll(id);
	}

}
