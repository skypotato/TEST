package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.ReservationUserComment;

public interface ReservationUserCommentService {
	public List<ReservationUserComment> getAllReservationUserCommentsByDisInfoId(int disInfoId);
}
