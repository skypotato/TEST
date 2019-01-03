package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.CommentImageDao;
import kr.or.skypotato.reservation.dto.CommentImage;
import kr.or.skypotato.reservation.service.CommentImageService;

@Service
public class CommentImageServiceImpl implements CommentImageService {
	@Autowired
	CommentImageDao commentImageDao;

	@Override
	public List<CommentImage> getAllCommentImages(int commentId) {
		return commentImageDao.selectAll(commentId);
	}
}
