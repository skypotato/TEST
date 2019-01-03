package kr.or.skypotato.reservation.dto;

public class DisplayInfo {
	private int productId;
	private int categoryId;
	private int displayInfoId;
	private String categoryName;
	private String productDescription;
	private String productContent;
	private String productEvent;
	private String openingHours;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String telephone;
	private String homepage;
	private String email;
	private String createDate;
	private String modifyDate;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public String getProductEvent() {
		return productEvent;
	}

	public void setProductEvent(String productEvent) {
		this.productEvent = productEvent;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceLot() {
		return placeLot;
	}

	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}

	public String getPlaceStreet() {
		return placeStreet;
	}

	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		String displayInfoStr = "DisplayInfo [";
		displayInfoStr += "productId=${productId},categoryId=\"${categoryId}\",displayInfoId=\"${displayInfoId}\" ";
		displayInfoStr += ",categoryName=${categoryName} ";
		displayInfoStr += ",productDescription=\"${productDescription},productContent=\"${productContent}\",productEvent=\"${productEvent}\" ";
		displayInfoStr += ",openingHours=\"${openingHours},placeName=\"${placeName}\",placeLot=\"${placeLot}\",placeStreet=\"${placeStreet}\" ";
		displayInfoStr += ",telephone=\"${telephone},homepage=\"${homepage}\",email=\"${email}\" ";
		displayInfoStr += ",createDate=\"${createDate},modifyDate=\"${modifyDate}\" ";
		displayInfoStr += "] ";
		
		displayInfoStr = displayInfoStr.replaceAll("${productId}",""+productId);
		displayInfoStr = displayInfoStr.replaceAll("${categoryId}",""+categoryId);
		displayInfoStr = displayInfoStr.replaceAll("${displayInfoId}",""+displayInfoId);
		displayInfoStr = displayInfoStr.replaceAll("${categoryName}",categoryName);
		displayInfoStr = displayInfoStr.replaceAll("${productDescription}",productDescription);
		displayInfoStr = displayInfoStr.replaceAll("${productContent}",productContent);
		displayInfoStr = displayInfoStr.replaceAll("${productEvent}",productEvent);
		displayInfoStr = displayInfoStr.replaceAll("${openingHours}",openingHours);
		displayInfoStr = displayInfoStr.replaceAll("${placeName}",placeName);
		displayInfoStr = displayInfoStr.replaceAll("${placeLot}",placeLot);
		displayInfoStr = displayInfoStr.replaceAll("${placeStreet}",placeStreet);
		displayInfoStr = displayInfoStr.replaceAll("${telephone}",telephone);
		displayInfoStr = displayInfoStr.replaceAll("${homepage}",homepage);
		displayInfoStr = displayInfoStr.replaceAll("${email}",email);
		displayInfoStr = displayInfoStr.replaceAll("${createDate}",createDate);
		displayInfoStr = displayInfoStr.replaceAll("${modifyDate}",modifyDate);
		return displayInfoStr;
	}
}