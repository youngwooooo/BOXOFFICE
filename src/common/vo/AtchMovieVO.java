package common.vo;

public class AtchMovieVO {
	
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
	private String groupCd;
	private long atchFileCd	= -1;	// 첨부파일ID
	private int fileSn = 1; 		// 파일순번
	private String filePath; 	// 파일저장경로
	private String fileStoreName; 		// 저장파일명
	private String fileOrignName; 	// 원본파일명
	private String fileExtsn; 		// 파일확장자
	private String fileContent; 			// 파일내용
	private long fileSize = 0; 		// 파일크기
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
	public String getGroupCd() {
		return groupCd;
	}
	public void setGroupCd(String groupCd) {
		this.groupCd = groupCd;
	}
	public long getAtchFileCd() {
		return atchFileCd;
	}
	public void setAtchFileCd(long atchFileCd) {
		this.atchFileCd = atchFileCd;
	}
	public int getFileSn() {
		return fileSn;
	}
	public void setFileSn(int fileSn) {
		this.fileSn = fileSn;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileStoreName() {
		return fileStoreName;
	}
	public void setFileStoreName(String fileStoreName) {
		this.fileStoreName = fileStoreName;
	}
	public String getFileOrignName() {
		return fileOrignName;
	}
	public void setFileOrignName(String fileOrignName) {
		this.fileOrignName = fileOrignName;
	}
	public String getFileExtsn() {
		return fileExtsn;
	}
	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	@Override
	public String toString() {
		return "AtchMovieVO [mvCd=" + mvCd + ", mvNameKor=" + mvNameKor + ", mvNameEng=" + mvNameEng + ", mvRelDate="
				+ mvRelDate + ", mvRatingCd=" + mvRatingCd + ", mvRunningTime=" + mvRunningTime + ", director="
				+ director + ", actor=" + actor + ", showYn=" + showYn + ", mvPlot=" + mvPlot + ", dubbingYn="
				+ dubbingYn + ", mvCompany=" + mvCompany + ", mvCountry=" + mvCountry + ", mvShowStartDate="
				+ mvShowStartDate + ", mvShowEndDate=" + mvShowEndDate + ", groupCd=" + groupCd + ", atchFileCd="
				+ atchFileCd + ", fileSn=" + fileSn + ", filePath=" + filePath + ", fileStoreName=" + fileStoreName
				+ ", fileOrignName=" + fileOrignName + ", fileExtsn=" + fileExtsn + ", fileContent=" + fileContent
				+ ", fileSize=" + fileSize + "]";
	}
	
	
}
