package admin.movierating.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.CodeVO;

public class MovieRatingDaoImpl extends BaseDao implements IMovieRatingDao {

	private static IMovieRatingDao instance;
	
	private MovieRatingDaoImpl() {

	}
	
	public static IMovieRatingDao getInstance() {
		if(instance == null) {
			instance = new MovieRatingDaoImpl();
		}
		
		return instance;
	}

	//영화관람등급 리스트 전체 조회
	@Override
	public List<CodeVO> retrieveMovieRatingList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("movieRating.retrieveMovieRatingList");
	}

	//영화관람등급 유형 전체 개수
	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("movieRating.getTotalCnt");
		
		return cnt;
	}

	//코드 존재 여부 확인
	@Override
	public CodeVO retrieveMovieRating(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return (CodeVO)smc.queryForObject("movieRating.retrieveMovieRating", codeVO);
	}

	//코드 최대값
	@Override
	public int retrieveMaxMovieRatingCode(SqlMapClient smc) throws SQLException {
		if((Integer)smc.queryForObject("movieRating.retrieveMaxMovieRatingCode") == null) {
			return 1;
		}
		return (int)smc.queryForObject("movieRating.retrieveMaxMovieRatingCode");
	}

	//등록
	@Override
	public int createMovieRating(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		if(smc.insert("movieRating.createMovieRating", codeVO) == null) {
			return 1;
		}
		return 0;
	}

	//수정
	@Override
	public int modifyMovieRating(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return smc.update("movieRating.modifyMovieRating", codeVO);
	}

	//삭제
	@Override
	public int deleteMovieRating(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return smc.update("movieRating.deleteMovieRating", codeVO);
	}


}
