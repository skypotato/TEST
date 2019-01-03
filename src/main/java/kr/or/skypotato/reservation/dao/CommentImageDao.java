package kr.or.skypotato.reservation.dao;

import static kr.or.skypotato.reservation.dao.CommentImageDaoSqls.SELECT_ALL_COMMENT_IMAGES;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.skypotato.reservation.dto.CommentImage;

@Repository
public class CommentImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentImage> rowMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);
	
	public CommentImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<CommentImage> selectAll(int commentId) {
		
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		
		return jdbc.query(SELECT_ALL_COMMENT_IMAGES, params, rowMapper);
	}

}
