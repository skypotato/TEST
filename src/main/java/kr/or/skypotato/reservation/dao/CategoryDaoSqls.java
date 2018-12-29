package kr.or.skypotato.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT_CATEGORIES = ""
			+ "SELECT ctg.id, ctg.name, COUNT(disInfo.id) AS count "
			+ "\nFROM category ctg "
			+ "\nLEFT JOIN product prd ON  ctg.id = prd.category_id "
			+ "\nLEFT JOIN display_info disInfo ON prd.id = disInfo.product_id"
			+ "\nGROUP BY ctg.id, ctg.name;\r\n";
}
