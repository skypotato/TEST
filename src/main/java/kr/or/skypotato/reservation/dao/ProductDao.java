package kr.or.skypotato.reservation.dao;

import static kr.or.skypotato.reservation.dao.ProductDaoSqls.SELECT_ALL_PRODUCTS;

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

	public List<Product> selectAll(int categoryId) {
		String strQuery = "";
		String strDynamicQuery = "";
		
		// 카테고리 아이디 여부에 따른 조건절 추가
		Map<String, Integer> params = new HashMap<>();
		if(categoryId != 0) {
			strDynamicQuery = "WHERE prd.category_id = :categoryId";
			params.put("categoryId", categoryId);
		}
		
		strQuery = SELECT_ALL_PRODUCTS.replace("${dynamicQuery}", strDynamicQuery);
		
		return jdbc.query(strQuery, params, rowMapper);
	}

}
