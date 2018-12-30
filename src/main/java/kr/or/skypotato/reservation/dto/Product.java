package kr.or.skypotato.reservation.dto;

public class Product {
	private int displayInfoId;
	private String placeName;
	private String productContent;
	private String productDescription;
	private int productId;
	private String productImageUrl;
	
	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	@Override
	public String toString() {
		String productStr = "Product [";
		productStr += "displayInfoId=${displayInfoId}, placeName=\"${placeName}\"";
		productStr += ",productContent=\"${productContent}\",productDescription=\"${productDescription}";
		productStr += ",productId=${productId},productImageUrl=\"${productImageUrl}";
		productStr += "]";
		
		productStr = productStr.replaceAll("${displayInfoId}",		""+displayInfoId);
		productStr = productStr.replaceAll("${placeName}",			placeName);
		productStr = productStr.replaceAll("${productContent}",		productContent);
		productStr = productStr.replaceAll("${productDescription}",	productDescription);
		productStr = productStr.replaceAll("${productId}",			""+productId);
		productStr = productStr.replaceAll("${productImageUrl}",	productImageUrl);
		return productStr;
	}
}
