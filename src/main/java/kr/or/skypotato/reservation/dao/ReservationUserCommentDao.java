package kr.or.skypotato.reservation.dao;

import static kr.or.skypotato.reservation.dao.ReservationUserCommentDaoSqls.SELECT_RESERVATION_USER_COMMENTS_BY_DISPLAY_INFO_ID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.skypotato.reservation.dto.ReservationUserComment;

@Repository
public class ReservationUserCommentDao {
	private NamedParameterJdbcTemplate jdbc;	
	private RowMapper<ReservationUserComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);
	
	public ReservationUserCommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<ReservationUserComment> selectAllByDisInfoId(int disInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("disInfoId", disInfoId);
		return jdbc.query(SELECT_RESERVATION_USER_COMMENTS_BY_DISPLAY_INFO_ID, params, rowMapper);
	}
}
