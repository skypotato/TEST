package kr.or.skypotato.reservation.dao;

public class CommentDaoSqls {
	public static final String SELECT_ALL_COMMENTS= ""
			+ "\nSELECT "
			+ "\n	comment.id AS commentId " 
			+ "\n	,comment.product_id AS productId " 
			+ "\n	,comment.reservation_info_id AS reservationInfoId " 
			+ "\n	,comment.score AS score " 
			+ "\n	,comment.comment AS comment " 
			+ "\n	,reservationInfo.reservation_name AS reservationName " 
			+ "\n	,reservationInfo.reservation_tel AS reservationTelephone " 
			+ "\n	,reservationInfo.reservation_email AS reservationEmail " 
			+ "\n	,reservationInfo.reservation_date AS reservationDate " 
			+ "\n	,comment.create_date AS createDate " 
			+ "\n	,comment.modify_date AS modifyDate " 
			+ "\nFROM reservation_user_comment comment "
			+ "\nLEFT JOIN reservation_info reservationInfo"
			+ "\nON comment.reservation_info_id = reservationInfo.id "
			+ "\nWHERE reservationInfo.display_info_id = :displayInfoId "
			+ "\nGROUP BY commentId";
}
