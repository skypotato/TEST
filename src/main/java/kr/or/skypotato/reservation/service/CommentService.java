package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.Comment;

public interface CommentService {
	public List<Comment> getAllComments(int displayInfoId);
	public float getAverageScore(int displayInfoId);
}
