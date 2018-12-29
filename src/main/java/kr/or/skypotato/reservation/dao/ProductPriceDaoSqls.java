package kr.or.skypotato.reservation.dao;

public class ProductPriceDaoSqls {
	public static final String SELECT_PRODUCT_PRICES_BY_DISPLAY_INFO_ID = ""
			+ "SELECT"
			+ "\npri.id, " 
			+ "\npri.product_id AS productId, " 
			+ "\npri.price_type_name AS priceTypeName, " 
			+ "\npri.price, " 
			+ "\npri.discount_rate AS discountRate, " 
			+ "\npri.create_date AS createDate, " 
			+ "\npri.modify_date AS modifyDate " 
			+ "\nFROM product_price pri " 
			+ "\nLEFT JOIN display_info disInfo ON("
			+ "\ndisInfo.product_id = pri.product_id "
			+ "\n)"
			+ "\nWHERE disInfo.id = :disInfoId";
}
