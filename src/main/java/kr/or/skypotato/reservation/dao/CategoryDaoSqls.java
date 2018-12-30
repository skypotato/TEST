package kr.or.skypotato.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT_ALL_CATEGORIES = ""
			+ "\nSELECT "
			+ "\n	ctg.id AS id "
			+ "\n	,ctg.name AS name "
			+ "\n	,COUNT(disInfo.id) AS count "
			+ "\nFROM category ctg "
			+ "\nLEFT JOIN product prd "
			+ "\nON ctg.id = prd.category_id "
			+ "\nLEFT JOIN display_info disInfo "
			+ "\nON prd.id = disInfo.product_id "
			+ "\nGROUP BY ctg.id, ctg.name ";
}
