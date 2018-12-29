package kr.or.skypotato.reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT_PRODUCTS = ""
			+ "SELECT prd.id AS id, prd.category_id AS categoryId, prd.description AS description, "
			+ "\nprd.content AS content, prd.event AS event, prd.create_date AS createDate, prd.modify_date AS modifyDate, "
			+ "\ncat.name AS name, "
			+ "\ndisInfo.id AS displayInfoId, disInfo.opening_hours AS openingHours, disInfo.place_name AS placeName, disInfo.place_lot AS placeLot, "
			+ "\ndisInfo.place_street AS placeStreet, disInfo.tel AS tel, disInfo.homepage AS homepage, disInfo.email AS email "
			+ "\nFROM product prd "
			+ "\nLEFT JOIN category cat "
			+ "\nON cat.id = prd.category_id "
			+ "\nLEFT JOIN display_info disInfo "
			+ "\nON disInfo.product_id = prd.id "
			+ "\n${dynamicQuery}"
			+ "\nLIMIT :start, :limit";
	public static final String SELECT_PRODUCT_BY_DISPLAY_INFO_ID = ""
			+ "SELECT prd.id AS id, prd.category_id AS categoryId, prd.description AS description, "
			+ "\nprd.content AS content, prd.event AS event, prd.create_date AS createDate, prd.modify_date AS modifyDate, "
			+ "\ncat.name AS name, "
			+ "\ndisInfo.id AS displayInfoId, disInfo.opening_hours AS openingHours, disInfo.place_name AS placeName, disInfo.place_lot AS placeLot, "
			+ "\ndisInfo.place_street AS placeStreet, disInfo.tel AS tel, disInfo.homepage AS homepage, disInfo.email AS email "
			+ "\nFROM product prd "
			+ "\nLEFT JOIN category cat "
			+ "\nON cat.id = prd.category_id "
			+ "\nLEFT JOIN display_info disInfo "
			+ "\nON disInfo.product_id = prd.id "
			+ "\nWHERE disInfo.id = :disInfoId";
	public static final String SELECT_COUNT = ""
			+ "SELECT count(*) FROM display_info disInfo "
			+ "LEFT JOIN product prd ON prd.id = disInfo.product_id"
			+ "\n${dynamicQuery}";
}
