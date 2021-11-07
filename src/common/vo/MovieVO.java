package common.vo;

public class MovieVO {
	
	private String mvCd;
	private String mvNameKor;
	private String mvNameEng;
	private String mvRelDate;
	private String mvRatingCd;
	private String mvRunningTime;
	private String director;
	private String actor;
	private String showYn;
	private String mvPlot;
	private String dubbingYn;
	private String mvCompany;
	private String mvCountry;
	private String mvShowStartDate;
	private String mvShowEndDate;
	private long atchFileCd = -1;
	private String fileStoreName;
	private String groupCd;
	
	private int firstRecNo;
	private int lastRecNo;
	
	
	public String getMvCd() {
		return mvCd;
	}
	public void setMvCd(String mvCd) {
		this.mvCd = mvCd;
	}
	public String getMvNameKor() {
		return mvNameKor;
	}
	public void setMvNameKor(String mvNameKor) {
		this.mvNameKor = mvNameKor;
	}
	public String getMvNameEng() {
		return mvNameEng;
	}
	public void setMvNameEng(String mvNameEng) {
		this.mvNameEng = mvNameEng;
	}
	public String getMvRelDate() {
		return mvRelDate;
	}
	public void setMvRelDate(String mvRelDate) {
		this.mvRelDate = mvRelDate;
	}
	public String getMvRatingCd() {
		return mvRatingCd;
	}
	public void setMvRatingCd(String mvRatingCd) {
		this.mvRatingCd = mvRatingCd;
	}
	public String getMvRunningTime() {
		return mvRunningTime;
	}
	public void setMvRunningTime(String mvRunningTime) {
		this.mvRunningTime = mvRunningTime;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getShowYn() {
		return showYn;
	}
	public void setShowYn(String showYn) {
		this.showYn = showYn;
	}
	public String getMvPlot() {
		return mvPlot;
	}
	public void setMvPlot(String mvPlot) {
		this.mvPlot = mvPlot;
	}
	public String getDubbingYn() {
		return dubbingYn;
	}
	public void setDubbingYn(String dubbingYn) {
		this.dubbingYn = dubbingYn;
	}
	public String getMvCompany() {
		return mvCompany;
	}
	public void setMvCompany(String mvCompany) {
		this.mvCompany = mvCompany;
	}
	public String getMvCountry() {
		return mvCountry;
	}
	public void setMvCountry(String mvCountry) {
		this.mvCountry = mvCountry;
	}
	public String getMvShowStartDate() {
		return mvShowStartDate;
	}
	public void setMvShowStartDate(String mvShowStartDate) {
		this.mvShowStartDate = mvShowStartDate;
	}
	public String getMvShowEndDate() {
		return mvShowEndDate;
	}
	public void setMvShowEndDate(String mvShowEndDate) {
		this.mvShowEndDate = mvShowEndDate;
	}
	public long getAtchFileCd() {
		return atchFileCd;
	}
	public void setAtchFileCd(long atchFileCd) {
		this.atchFileCd = atchFileCd;
	}
	
	public String getGroupCd() {
		return groupCd;
	}
	public void setGroupCd(String groupCd) {
		this.groupCd = groupCd;
	}

	public int getFirstRecNo() {
		return firstRecNo;
	}
	public void setFirstRecNo(int firstRecNo) {
		this.firstRecNo = firstRecNo;
	}
	public int getLastRecNo() {
		return lastRecNo;
	}
	public void setLastRecNo(int lastRecNo) {
		this.lastRecNo = lastRecNo;
	}
	
	public String getFileStoreName() {
		return fileStoreName;
	}
	public void setFileStoreName(String fileStoreName) {
		this.fileStoreName = fileStoreName;
	}
	@Override
	public String toString() {
		return "MovieVO [mvCd=" + mvCd + ", mvNameKor=" + mvNameKor + ", mvNameEng=" + mvNameEng + ", mvRelDate="
				+ mvRelDate + ", mvRatingCd=" + mvRatingCd + ", mvRunningTime=" + mvRunningTime + ", director="
				+ director + ", actor=" + actor + ", showYn=" + showYn + ", mvPlot=" + mvPlot + ", dubbingYn="
				+ dubbingYn + ", mvCompany=" + mvCompany + ", mvCountry=" + mvCountry + ", mvShowStartDate="
				+ mvShowStartDate + ", mvShowEndDate=" + mvShowEndDate + ", atchFileCd=" + atchFileCd + ", groupCd="
				+ groupCd + "]";
	}

}
