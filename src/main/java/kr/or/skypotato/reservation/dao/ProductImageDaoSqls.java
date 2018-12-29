package kr.or.skypotato.reservation.dao;

public class ProductImageDaoSqls {
	public static final String SELECT_PRODUCT_IMAGES_BY_DISPLAY_INFO_ID = ""
			+ "SELECT"
			+ "\nimg.product_id AS productId," 
			+ "\nimg.id AS productImageId," 
			+ "\nimg.type AS type, " 
			+ "\nimg.file_id AS fileInfoId," 
			+ "\nfInfo.file_name AS fileName,"  
			+ "\nfInfo.save_file_name AS saveFileName,"  
			+ "\nfInfo.content_type AS contentType" 
			+ "\nFROM product_image img" 
			+ "\nLEFT JOIN file_info fInfo ON("  
			+ "\n\tfInfo.id = img.file_id" 
			+ "\n)"
			+ "\nLEFT JOIN display_info disInfo ON("
			+ "\ndisInfo.product_id = img.product_id "
			+ "\n)"
			+ "\nWHERE disInfo.id = :disInfoId";
}
