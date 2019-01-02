package kr.or.skypotato.reservation.dao;

public class DisplayInfoDaoSqls {
	public static final String SELECT_ONE_DISPLAY_INFO = ""
			+ "\nSELECT "
			+ "\n	disInfo.product_id AS productId "
			+ "\n	,prd.category_id AS categoryId "
			+ "\n	,disInfo.id AS displayInfoId "
			+ "\n	,ctg.name AS categoryName "
			+ "\n	,prd.description AS productDescription "
		    + "\n	,prd.content AS productContent "
		    + "\n	,prd.event AS productEvent "
		    + "\n	,disInfo.opening_hours AS openingHours " 
		    + "\n	,disInfo.place_name AS placeName "
		    + "\n	,disInfo.place_lot AS placeLot "
		    + "\n	,disInfo.place_street AS placeStreet " 
		    + "\n	,disInfo.tel AS telephone "
		    + "\n	,disInfo.homepage AS homepage " 
		    + "\n	,disInfo.email AS email "
		    + "\n	,disInfo.create_date AS createDate " 
		    + "\n	,disInfo.modify_date AS modifyDate "
			+ "\nFROM display_info disInfo "
			+ "\nLEFT JOIN product prd " 
			+ "\nON disInfo.product_id = prd.id "  
			+ "\nLEFT JOIN category ctg " 
			+ "\nON prd.category_id = ctg.id "
			+ "\nWHERE disInfo.id = :displayInfoId "
			+ "\nGROUP BY displayInfoId";
}
