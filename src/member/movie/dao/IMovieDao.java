package member.movie.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.MovieVO;
import common.vo.PagingVO;

public interface IMovieDao {
	
	public List<MovieVO> getAllMovieList(SqlMapClient smc)throws SQLException;
	
	public int insertMovie(SqlMapClient smc, MovieVO mv) throws SQLException;
	
	public int updateMovie(SqlMapClient smc, MovieVO mv) throws SQLException;
	
	public MovieVO getMovie(SqlMapClient smc, String mvCd) throws SQLException;
	
	public int deleteMovie(SqlMapClient smc, String mvCd) throws SQLException;
	
	public int getTotalCnt(SqlMapClient smc) throws SQLException;
	
	public List<MovieVO> getSearchMovie(SqlMapClient smc, MovieVO mv) throws SQLException;

	public List<MovieVO> getAllMovieList(SqlMapClient smc, PagingVO pagingVO) throws SQLException;
	
	

}
