package kr.or.skypotato.reservation.service;

import java.util.List;

import kr.or.skypotato.reservation.dto.CommentImage;

public interface CommentImageService {
	public List<CommentImage> getAllCommentImages(int commentId);
}
