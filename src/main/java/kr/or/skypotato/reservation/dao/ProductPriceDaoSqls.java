package kr.or.skypotato.reservation.dao;

public class ProductPriceDaoSqls {
	public static final String SELECT_ALL_PRICES = ""
			+ "\nSELECT "
			+ "\n	prdPrice.id AS productPriceId " 
			+ "\n	,prdPrice.product_id AS productId " 
			+ "\n	,prdPrice.price_type_name AS priceTypeName " 
			+ "\n	,prdPrice.price AS price " 
			+ "\n	,prdPrice.discount_rate AS discountRate " 
			+ "\n	,prdPrice.create_date AS createDate " 
			+ "\n	,prdPrice.create_date AS modifyDate "
			+ "\nFROM product_price prdPrice "
			+ "\nLEFT JOIN display_info disInfo "
			+ "\nON prdPrice.product_id = disInfo.product_id "
			+ "\nWHERE disInfo.id = :displayInfoId"
			+ "\nGROUP BY productPriceId";
}
