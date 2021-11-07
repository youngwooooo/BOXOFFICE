package member.category.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.AtchMovieVO;
import common.vo.CodeVO;
import common.vo.MovieVO;

public interface IMovieDao {
	
	public List<AtchMovieVO> getAllMovieList(SqlMapClient smc, MovieVO movieVO) throws SQLException;
	
	public int insertMovie(SqlMapClient smc, MovieVO mv) throws SQLException;
	
	public int updateMovie(SqlMapClient smc, MovieVO mv) throws SQLException;
	
	public MovieVO getMovie(SqlMapClient smc, String mvCd) throws SQLException;
	
	public List<CodeVO> getAllGenreList(SqlMapClient smc) throws SQLException; // 장르 조회
	
	//public List<MovieVO> getAllCodeMovieList(SqlMapClient smc) throws SQLException; // 장르 컬럼 포함 리스트 
	
	public int deleteMovie(SqlMapClient smc, String mvCd) throws SQLException;
	
	public int getTotalCnt(SqlMapClient smc) throws SQLException;
	
	public List<MovieVO> getSearchMovie(SqlMapClient smc, MovieVO mv) throws SQLException;

	//public List<MovieVO> getMovieAll(SqlMapClient smc, MovieVO mv) throws SQLException;

}
