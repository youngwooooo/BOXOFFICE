package common.vo;

public class CodeVO extends PagingVO {
	private String groupCd;
	private String groupCdName;
	private String cd;
	private String cdName;
	private String cdDesc;
	private String deleteYn;
	
	public String getGroupCd() {
		return groupCd;
	}
	public void setGroupCd(String groupCd) {
		this.groupCd = groupCd;
	}
	public String getGroupCdName() {
		return groupCdName;
	}
	public void setGroupCdName(String groupCdName) {
		this.groupCdName = groupCdName;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getCdName() {
		return cdName;
	}
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	public String getCdDesc() {
		return cdDesc;
	}
	public void setCdDesc(String cdDesc) {
		this.cdDesc = cdDesc;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	
	
}
