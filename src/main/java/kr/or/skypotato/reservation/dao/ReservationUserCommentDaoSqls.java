package kr.or.skypotato.reservation.dao;

public class ReservationUserCommentDaoSqls {
	public static final String SELECT_RESERVATION_USER_COMMENTS_BY_DISPLAY_INFO_ID = ""
			+ "SELECT " 
			+ "\ncmt.id AS id, "
			+ "\ncmt.product_id AS productId, "
			+ "\ncmt.reservation_info_id AS reservationInfoId, "
			+ "\ncmt.score, "
			+ "\ncmt.comment, "
			+ "\ncmt.create_date AS createDate, "
			+ "\ncmt.modify_date AS modifyDate "
			+ "\nFROM reservation_user_comment cmt "
			+ "\nLEFT JOIN display_info disInfo ON("
			+ "\ndisInfo.product_id = cmt.product_id "
			+ "\n)"
			+ "\nWHERE disInfo.id = :disInfoId";
}
