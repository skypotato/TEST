package kr.or.skypotato.reservation.dao;

import static kr.or.skypotato.reservation.dao.ProductImageDaoSqls.SELECT_ALL_PRODUCT_IMAGES;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.skypotato.reservation.dto.ProductImage;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	
	public ProductImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<ProductImage> selectAll(int displayInfoId) {
		
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		
		return jdbc.query(SELECT_ALL_PRODUCT_IMAGES, params, rowMapper);
	}

}
