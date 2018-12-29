package kr.or.skypotato.reservation.dao;

public class ReservationUserCommentImageDaoSqls {
	public static final String SELECT_RESERVATION_USER_COMMENT_IMAGES = ""
			+ "SELECT " 
			+ "\ncmtImg.id AS id,"  
			+ "\ncmtImg.reservation_info_id AS reservationInfoId,"  
			+ "\ncmtImg.reservation_user_comment_id AS reservationUserCommentId,"  
			+ "\ncmtImg.file_id AS fileId,"  
			+ "\nfInfo.file_name AS fileName,"  
			+ "\nfInfo.save_file_name AS saveFileName,"  
			+ "\nfInfo.content_type AS contentType,"  
			+ "\nfInfo.delete_flag AS deleteFlag,"  
			+ "\nfInfo.create_date AS createDate,"  
			+ "\nfInfo.modify_date AS modifyDate"  
			+ "\nFROM reservation_user_comment_image cmtImg"  
			+ "\nLEFT JOIN reservation_user_comment cmt ON("  
			+ "\n\tcmt.id = cmtImg.reservation_user_comment_id"  
			+ "\n)"  
			+ "\nLEFT JOIN file_info fInfo ON("  
			+ "\n\tfInfo.id = cmtImg.file_id"  
			+ "\n)"
			+ "\nWHERE cmt.id =:id";
}
