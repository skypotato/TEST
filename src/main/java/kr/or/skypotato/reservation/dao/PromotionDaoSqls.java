package kr.or.skypotato.reservation.dao;

public class PromotionDaoSqls {
	public static final String SELECT_PROMOTIONS = ""
	+ "SELECT "
	+ "\nprm.id AS id, prm.product_id AS productId, "
	+ "\nprd.category_id AS categoryId, prd.description AS description, "
	+ "\ncat.name AS categoryName, "
	+ "\nprdImg.id AS productImageId "
	+ "\nFROM promotion prm "
	+ "\nLEFT JOIN product prd "
	+ "\nON prm.product_id = prd.id "
	+ "\nLEFT join category cat "
	+ "\nON prd.category_id = cat.id "
	+ "\nLEFT JOIN product_image prdImg "
	+ "\nON prm.product_id = prdImg.product_id AND type = 'ma' ";
}
