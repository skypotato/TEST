package kr.or.skypotato.reservation.dao;

import static kr.or.skypotato.reservation.dao.ReservationUserCommentImageDaoSqls.SELECT_RESERVATION_USER_COMMENT_IMAGES;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.skypotato.reservation.dto.ReservationUserCommentImage;

@Repository
public class ReservationUserCommentImageDao {
	private NamedParameterJdbcTemplate jdbc;	
	private RowMapper<ReservationUserCommentImage> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentImage.class);
	
	public ReservationUserCommentImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<ReservationUserCommentImage> selectAll(int id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(SELECT_RESERVATION_USER_COMMENT_IMAGES, params, rowMapper);
	}
}
