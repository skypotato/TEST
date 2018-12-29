package kr.or.skypotato.reservation.dao;

public class DisplayInfoImageDaoSqls {
	public static final String SELECT_DISPLAY_INFO_IMAGES_BY_DISPLAY_INFO_ID = ""
			+ "\nSELECT "  
			+ "\ndisImg.id AS id, disImg.file_id AS fileId, "  
			+ "\nfInfo.file_name AS fileName, fInfo.save_file_name AS saveFileName, fInfo.content_type AS contentType, "  
			+ "\nfInfo.delete_flag AS deleteFlag, fInfo.create_date AS createDate,  fInfo.modify_date AS modifyDate"  
			+ "\nFROM display_info_image disImg"  
			+ "\nLEFT JOIN file_info fInfo ON("  
			+ "\n\tfInfo.id = disImg.file_id"  
			+ "\n)"
			+ "\nLEFT JOIN display_info disInfo ON("
			+ "\ndisInfo.id = disImg.display_info_id "
			+ "\n)"  
			+ "\nWHERE disInfo.id = :disInfoId";
}
