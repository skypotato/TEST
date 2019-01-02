package kr.or.skypotato.reservation.dao;

public class DisplayInfoImageDaoSqls {
	public static final String SELECT_ONE_DISPLAY_INFO_IMAGE = ""
			+ "\nSELECT "
			+ "\n	disInfoImage.id AS displayInfoImageId " 
			+ "\n	,disInfoImage.display_info_id AS displayInfoId " 
			+ "\n	,disInfoImage.file_id AS fileInfoId " 
			+ "\n	,fileInfo.file_name AS fileName " 
			+ "\n	,fileInfo.save_file_name AS saveFileName " 
			+ "\n	,fileInfo.content_type AS contentType " 
			+ "\n	,fileInfo.delete_flag AS deleteFlag " 
			+ "\n	,fileInfo.create_date AS createDate " 
			+ "\n	,fileInfo.create_date AS modifyDate "
			+ "\nFROM display_info_image disInfoImage "
			+ "\nLEFT JOIN file_info fileInfo "
			+ "\nON disInfoImage.file_id = fileInfo.id "
			+ "\nWHERE disInfoImage.display_info_id = :displayInfoId ";
}
