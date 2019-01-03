package kr.or.skypotato.reservation.dao;

import static kr.or.skypotato.reservation.dao.CommentDaoSqls.SELECT_ALL_COMMENTS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.skypotato.reservation.dto.Comment;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
	
	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Comment> selectAll(int displayInfoId) {
		
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		
		return jdbc.query(SELECT_ALL_COMMENTS, params, rowMapper);
	}

}
