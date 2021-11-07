package common.vo;

public class ProductVO {
	private String prodCd;
	private String prodName;
	private String prodPrice;
	private String prodTypeCd;
	private String prodDesc;
	private long atchFileCd;

	public String getProdCd() {
		return prodCd;
	}
	public void setProdCd(String prodCd) {
		this.prodCd = prodCd;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdTypeCd() {
		return prodTypeCd;
	}
	public void setProdTypeCd(String prodTypeCd) {
		this.prodTypeCd = prodTypeCd;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public long getAtchFileCd() {
		return atchFileCd;
	}
	public void setAtchFileCd(long atchFileCd) {
		this.atchFileCd = atchFileCd;
	}
	
}