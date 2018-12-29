package kr.or.skypotato.reservation.dao;

import static kr.or.skypotato.reservation.dao.ProductDaoSqls.SELECT_COUNT;
import static kr.or.skypotato.reservation.dao.ProductDaoSqls.SELECT_PRODUCTS;
import static kr.or.skypotato.reservation.dao.ProductDaoSqls.SELECT_PRODUCT_BY_DISPLAY_INFO_ID;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.skypotato.reservation.dto.Product;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Product> selectAll(int start, int categoryId, int limit) {
		String strQuery = "";
		String strDynamicQuery = "";
		
		Map<String, Integer> params = new HashMap<>();
		if(categoryId != 0) {
			strDynamicQuery = "WHERE prd.category_id = :categoryId";
			params.put("categoryId", categoryId);
		}
		params.put("start", start);
		params.put("limit", limit);
		
		strQuery = SELECT_PRODUCTS.replace("${dynamicQuery}", strDynamicQuery);
		
		return jdbc.query(strQuery, params, rowMapper);
	}

	public Product selectOneByDisInfoId(int disInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("disInfoId", disInfoId);
		return jdbc.queryForObject(SELECT_PRODUCT_BY_DISPLAY_INFO_ID, params, BeanPropertyRowMapper.newInstance(Product.class));
	}

	public int selectCount(int categoryId) {
		String strQuery = "";
		String strDynamicQuery = "";
		
		Map<String, Integer> params = new HashMap<>();
		if(categoryId != 0) {
			strDynamicQuery = "WHERE prd.category_id = :categoryId";
			params.put("categoryId", categoryId);
		}
		
		strQuery = SELECT_COUNT.replace("${dynamicQuery}", strDynamicQuery);
		
		return jdbc.queryForObject(strQuery, params, Integer.class);
	}
}