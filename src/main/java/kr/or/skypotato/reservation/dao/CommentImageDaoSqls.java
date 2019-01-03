package kr.or.skypotato.reservation.dao;

public class CommentImageDaoSqls {
	public static final String SELECT_ALL_COMMENT_IMAGES = ""
			+ "\nSELECT "
			+ "\n	commentImage.id AS imageId " 
			+ "\n	,commentImage.reservation_info_id AS reservationInfoId " 
			+ "\n	,commentImage.reservation_user_comment_id AS reservationUserCommentId " 
			+ "\n	,commentImage.file_id AS fileId " 
			+ "\n	,fileInfo.file_name AS fileName " 
			+ "\n	,fileInfo.save_file_name AS saveFileName " 
			+ "\n	,fileInfo.content_type AS contentType " 
			+ "\n	,fileInfo.delete_flag AS deleteFlag " 
			+ "\n	,fileInfo.create_date AS createDate " 
			+ "\n	,fileInfo.modify_date AS modifyDate "
			+ "\nFROM reservation_user_comment_image commentImage "
			+ "\nLEFT JOIN file_info fileInfo " 
			+ "\nON commentImage.file_id = fileInfo.id "
			+ "\nWHERE commentImage.reservation_user_comment_id = :commentId "
			+ "\nGROUP BY imageId";
}
