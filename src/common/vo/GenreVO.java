package common.vo;


/**
 * 영화장르 관리를 위한 VO
 * @author 작성: 정범
 *
 */
public class GenreVO {
	private String mvCd; // 영화 코드
	private String genreCd; // 영화 장르
	
	public String getMvCd() {
		return mvCd;
	}
	public void setMvCd(String mvCd) {
		this.mvCd = mvCd;
	}
	public String getGenreCd() {
		return genreCd;
	}
	public void setGenreCd(String genreCd) {
		this.genreCd = genreCd;
	}
	
}
