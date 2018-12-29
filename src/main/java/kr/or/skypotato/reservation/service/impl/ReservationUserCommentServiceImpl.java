package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.ReservationUserCommentDao;
import kr.or.skypotato.reservation.dto.ReservationUserComment;
import kr.or.skypotato.reservation.service.ReservationUserCommentService;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService  {

	@Autowired
	ReservationUserCommentDao reservationUserCommentDao;
	
	@Override
	public List<ReservationUserComment> getAllReservationUserCommentsByDisInfoId(int disInfoId) {
		return reservationUserCommentDao.selectAllByDisInfoId(disInfoId);
	}

}
