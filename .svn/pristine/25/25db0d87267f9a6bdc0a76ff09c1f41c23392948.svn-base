package member.category.service;

import java.util.List;

import common.vo.AtchMovieVO;
import common.vo.CodeVO;
import common.vo.MovieVO;

public interface IMovieService {
	
	public List<AtchMovieVO> getAllMovieList(MovieVO movieVO); //리스트 
	
	public int insertMovie(MovieVO mv); //등록 
	
	public int updateMovie(MovieVO mv); //수정
	
	public int deleteMovie(String mvCd); //삭제 
	
	public MovieVO getMovie(String mvCd); //영화정보조회 
	
	public List<CodeVO> getAllGenreList(); // 장르 조회
	
	//public List<MovieVO> getAllCodeMovieList(); // 장르 포함한 영화 조회
	
	public int getTotalCnt();
	
	public List<MovieVO> getSearchMovie(MovieVO mv);	
	
	

}
