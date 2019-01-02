package kr.or.skypotato.reservation.dao;

import static kr.or.skypotato.reservation.dao.DisplayInfoDaoSqls.SELECT_ONE_DISPLAY_INFO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.skypotato.reservation.dto.DisplayInfo;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<DisplayInfo> selectOne(int displayInfoId) {
		
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		
		return jdbc.query(SELECT_ONE_DISPLAY_INFO, params, rowMapper);
	}

}
