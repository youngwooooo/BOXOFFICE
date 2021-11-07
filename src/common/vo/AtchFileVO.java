package common.vo;


public class AtchFileVO {
	
	private long atchFileCd	= -1;	// 첨부파일ID
	private int fileSn = 1; 		// 파일순번
	private String filePath; 	// 파일저장경로
	private String fileStoreName; 		// 저장파일명
	private String fileOrignName; 	// 원본파일명
	private String fileExtsn; 		// 파일확장자
	private String fileContent; 			// 파일내용
	private long fileSize = 0; 		// 파일크기
	
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
	
	
}
