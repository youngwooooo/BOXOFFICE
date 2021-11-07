package admin.movierating.service;

import java.sql.SQLException;
import java.util.List;

import common.vo.CodeVO;

public interface IMovieRatingService {
	
	/**
	 * 전체 영화관람등급 유형 목록을 조회하기 위한 메서드 
	 * @return 전체 영화관람등급 목록
	 */
	public List<CodeVO> retrieveMovieRatingList();
	
	/**
	 * 전체 영화관람등급 유형 수를 알아내는 메서드
	 * @return		전체 영화관람등급 수 
	 */
	public int getTotalCnt();
	
	/**
	 * 영화관람등급 유형 코드 정보 등록
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int createMovieRating(CodeVO codeVO);
	
	/**
	 * 영화관람등급 유형 코드 정보 수정
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyMovieRating(CodeVO codeVO);
	
	/**
	 * 영화관람등급 유형 코드 정보 삭제
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteMovieRating(CodeVO codeVO);
	
			
}
