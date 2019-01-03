package kr.or.skypotato.reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT_ALL_PRODUCTS = ""
			+ "\nSELECT "
			+ "\n	disInfo.id AS displayInfoId "
			+ "\n	,disInfo.place_name AS placeName "
			+ "\n	,prd.content AS productContent "
			+ "\n	,prd.description AS productDescription "
			+ "\n	,prd.id AS productId "
			+ "\n	,fileInfo.save_file_name AS productImageUrl "
			+ "\nFROM product prd "
			+ "\nLEFT JOIN display_info disInfo "
			+ "\nON prd.id = disInfo.product_id "
			+ "\nLEFT JOIN product_image prdImg "
			+ "\nON prd.id = prdImg.product_id "
			+ "\nLEFT JOIN file_info fileInfo "
			+ "\nON prdImg.file_id = fileInfo.id "
			+ "\n${dynamicQuery} "
			+ "\nGROUP BY displayInfoId";
}
