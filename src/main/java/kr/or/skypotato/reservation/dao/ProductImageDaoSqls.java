package kr.or.skypotato.reservation.dao;

public class ProductImageDaoSqls {
	public static final String SELECT_ALL_PRODUCT_IMAGES = ""
			+ "\nSELECT "
			+ "\n	prmImage.product_id AS productId " 
			+ "\n	,prmImage.id AS productImageId " 
			+ "\n	,prmImage.type AS type " 
			+ "\n	,prmImage.file_id AS fileInfoId " 
			+ "\n	,fileInfo.file_name AS fileName " 
			+ "\n	,fileInfo.save_file_name AS saveFileName " 
			+ "\n	,fileInfo.content_type AS contentType " 
			+ "\n	,fileInfo.delete_flag AS deleteFlag " 
			+ "\n	,fileInfo.create_date AS createDate " 
			+ "\n	,fileInfo.modify_date AS modifyDate "
			+ "\nFROM product_image prmImage "
			+ "\nLEFT JOIN file_info fileInfo " 
			+ "\nON prmImage.file_id = fileInfo.id "
			+ "\nLEFT JOIN display_info disInfo "
			+ "\nON prmImage.product_id = disInfo.product_id"
			+ "\nWHERE disInfo.id = :displayInfoId "
			+ "\nGROUP BY productImageId";
}
