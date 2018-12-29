package kr.or.skypotato.reservation.dao;

import static kr.or.skypotato.reservation.dao.DisplayInfoImageDaoSqls.SELECT_DISPLAY_INFO_IMAGES_BY_DISPLAY_INFO_ID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.skypotato.reservation.dto.DisplayInfoImage;

@Repository
public class DisplayInfoImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoImage> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);

	public DisplayInfoImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfoImage> selectAllByDisInfoId(int disInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("disInfoId", disInfoId);
		return jdbc.query(SELECT_DISPLAY_INFO_IMAGES_BY_DISPLAY_INFO_ID, params, rowMapper);
	}
}
