package kr.or.skypotato.reservation.dao;

public class CommentDaoSqls {
	public static final String SELECT_ALL_COMMENTS= ""
			+ "\nSELECT "
			+ "\n	userComment.id AS commentId " 
			+ "\n	,userComment.product_id AS productId " 
			+ "\n	,userComment.reservation_info_id AS reservationInfoId " 
			+ "\n	,userComment.score AS score " 
			+ "\n	,userComment.comment AS comment " 
			+ "\n	,reservationInfo.reservation_name AS reservationName " 
			+ "\n	,reservationInfo.reservation_tel AS reservationTelephone " 
			+ "\n	,reservationInfo.reservation_email AS reservationEmail " 
			+ "\n	,reservationInfo.reservation_date AS reservationDate " 
			+ "\n	,userComment.create_date AS createDate " 
			+ "\n	,userComment.modify_date AS modifyDate " 
			+ "\nFROM reservation_user_comment userComment "
			+ "\nLEFT JOIN reservation_info reservationInfo"
			+ "\nON userComment.reservation_info_id = reservationInfo.id "
			+ "\nWHERE reservationInfo.display_info_id = :displayInfoId "
			+ "\nGROUP BY commentId";
}
