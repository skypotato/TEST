package kr.or.skypotato.reservation.dto;

public class CommentImage {
	private int imageId;
	private int reservationInfoId;
	private int reservationUserCommentId;
	private int fileId;
	private String fileName;
	private String saveFileName;
	private String contentType;
	private boolean deleteFlag;
	private String createDate;
	private String modifyDate;
	
	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}

	public void setReservationUserCommentId(int reservationUserCommentId) {
		this.reservationUserCommentId = reservationUserCommentId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		String commentImageStr = "CommentImage [";
		commentImageStr += "imageId=${imageId},reservationInfoId=${reservationInfoId},reservationUserCommentId=${reservationUserCommentId},fileId=${fileId} ";
		commentImageStr += ",fileName=\"${fileName},saveFileName=\"${saveFileName}\",contentType=\"${contentType}\" ";
		commentImageStr += ",deleteFlag=\"${deleteFlag}\" ";
		commentImageStr += ",createDate=\"${createDate},modifyDate=\"${modifyDate}\" ";
		commentImageStr += "] ";
		
		commentImageStr = commentImageStr.replaceAll("${imageId}",""+imageId);
		commentImageStr = commentImageStr.replaceAll("${reservationInfoId}",""+reservationInfoId);
		commentImageStr = commentImageStr.replaceAll("${reservationUserCommentId}",""+reservationUserCommentId);
		commentImageStr = commentImageStr.replaceAll("${fileId}",""+fileId);
		commentImageStr = commentImageStr.replaceAll("${fileName}",fileName);
		commentImageStr = commentImageStr.replaceAll("${saveFileName}",saveFileName);
		commentImageStr = commentImageStr.replaceAll("${contentType}",contentType);
		commentImageStr = commentImageStr.replaceAll("${deleteFlag}",""+deleteFlag);
		commentImageStr = commentImageStr.replaceAll("${createDate}",createDate);
		commentImageStr = commentImageStr.replaceAll("${modifyDate}",modifyDate);
		return commentImageStr;
	}
}
