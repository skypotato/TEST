package kr.or.skypotato.reservation.dto;

public class DisplayInfoImage {
	private int displayInfoImageId;
	private int displayInfoId;
	private int fileInfoId;
	private String fileName;
	private String saveFileName;
	private String contentType;
	private boolean deleteFlag;
	private String createDate;
	private String modifyDate;
	
	public int getDisplayInfoImageId() {
		return displayInfoImageId;
	}

	public void setDisplayInfoImageId(int displayInfoImageId) {
		this.displayInfoImageId = displayInfoImageId;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getFileInfoId() {
		return fileInfoId;
	}

	public void setFileInfoId(int fileInfoId) {
		this.fileInfoId = fileInfoId;
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
		String displayInfoImageStr = "DisplayInfoImage ["
				+ "displayInfoImageId=${displayInfoImageId},displayInfoId=${displayInfoId} "
				+ ",fileInfoId=${fileInfoId},fileName=\"${fileName}\",saveFileName=\"${saveFileName}\" "
				+ ",contentType=\"${contentType}\",deleteFlag=${deleteFlag},createDate=\"${createDate}\",modifyDate=\"${modifyDate}\" "
				+ "]";
		displayInfoImageStr = displayInfoImageStr.replaceAll("${displayInfoImageId}",	""+displayInfoImageId);
		displayInfoImageStr = displayInfoImageStr.replaceAll("${displayInfoId}",		""+displayInfoId);
		displayInfoImageStr = displayInfoImageStr.replaceAll("${fileInfoId}",	""+fileInfoId);
		displayInfoImageStr = displayInfoImageStr.replaceAll("${fileName}", fileName);
		displayInfoImageStr = displayInfoImageStr.replaceAll("${saveFileName}", saveFileName);
		displayInfoImageStr = displayInfoImageStr.replaceAll("${contentType}", contentType);
		displayInfoImageStr = displayInfoImageStr.replaceAll("${deleteFlag}", ""+deleteFlag);
		displayInfoImageStr = displayInfoImageStr.replaceAll("${createDate}", createDate);
		displayInfoImageStr = displayInfoImageStr.replaceAll("${modifyDate}", modifyDate);
		return displayInfoImageStr;
	}
}
