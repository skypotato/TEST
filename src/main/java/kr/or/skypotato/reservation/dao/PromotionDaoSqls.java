package kr.or.skypotato.reservation.dao;

public class PromotionDaoSqls {
	public static final String SELECT_ALL_PROMOTIONS = ""
			+ "\nSELECT "
			+ "\n	prm.id AS id "
			+ "\n	,prm.product_id AS productId "
			+ "\n	,fileInfo.save_file_name AS productImageUrl "
			+ "\nFROM promotion prm "
			+ "\nLEFT JOIN product_image prdImg "
			+ "\nON prm.product_id = prdImg.product_id "
			+ "\nLEFT JOIN file_info fileInfo "
			+ "\nON prdImg.file_id = fileInfo.id "
			+ "\nGROUP BY prm.id";
}
