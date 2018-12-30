package kr.or.skypotato.reservation.dto;

public class Promotion {
	private int id;
	private int productId;
	private String productImageUrl;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		String promotionStr = "Promotion [";
		promotionStr += "id=${id},productId=${productId},productImageUrl\"${productImageUrl}\"]";
		
		promotionStr = promotionStr.replaceAll("${id}",				""+id);
		promotionStr = promotionStr.replaceAll("${productId}",		""+productId);
		promotionStr = promotionStr.replaceAll("${productImageUrl}",productImageUrl);
		return promotionStr;
	}
}
