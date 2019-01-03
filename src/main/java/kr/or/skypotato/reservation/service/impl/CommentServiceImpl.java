package kr.or.skypotato.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.skypotato.reservation.dao.CommentDao;
import kr.or.skypotato.reservation.dao.CommentImageDao;
import kr.or.skypotato.reservation.dto.Comment;
import kr.or.skypotato.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;
	@Autowired
	CommentImageDao commentImageDao;

	@Override
	public List<Comment> getAllComments(int displayInfoId) {
		List<Comment> comments = commentDao.selectAll(displayInfoId);
		for(int i=0;i<comments.size();i++){
			Comment comment = comments.get(i);
			int commentId = comment.getCommentId();
			// commentImage를 조회하여 넣는다.
			comment.setCommentImages(commentImageDao.selectAll(commentId));
			comments.set(i, comment);
		}
		return comments;
	}

	@Override
	public float getAverageScore(int displayInfoId) {
		List<Comment> comments = commentDao.selectAll(displayInfoId);
		float totalScore = 0;
		for(int i=0;i<comments.size();i++){
			Comment comment = comments.get(i);
			totalScore += comment.getScore();
		}
		return totalScore/comments.size();
	}
}
