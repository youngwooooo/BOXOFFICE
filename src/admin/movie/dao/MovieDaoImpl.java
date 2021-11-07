package admin.movie.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.AtchMovieVO;
import common.vo.CodeVO;
import common.vo.MovieVO;
import common.vo.PagingVO;

public class MovieDaoImpl implements IMovieDao {

	private static IMovieDao movieDao;

	private MovieDaoImpl() {
		
	}
	
	public static IMovieDao getInstance() {
		// TODO Auto-generated constructor stub
		if(movieDao == null) {
			movieDao = new MovieDaoImpl();
		}
				
		return movieDao;
	}

	@Override
	public int insertMovie(SqlMapClient smc, MovieVO mv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("movie.insertMovie", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<MovieVO> getAllMovieList(SqlMapClient smc, PagingVO pagingVO) throws SQLException {
		List<MovieVO> movieList = 
				smc.queryForList("movie.getAllMovieList", pagingVO);
		return movieList;
	}
	
	@Override
	public MovieVO getMovie(SqlMapClient smc, String mvCd) throws SQLException {
		
		
		MovieVO mv =
				(MovieVO)smc.queryForObject("movie.getMovie", mvCd);
		
		return mv;
	}

	@Override
	public int updateMovie(SqlMapClient smc, MovieVO mv) throws SQLException {
		
		int cnt = smc.update("movie.updateMovie", mv);
		
		return cnt;
	}

	@Override
	public int deleteMovie(SqlMapClient smc, String mvCd) throws SQLException {
		
		int cnt = smc.update("movie.deleteMovie", mvCd);
		
		return cnt;
	}

	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("movie.getTotalCnt");
		return cnt;
	}


	@Override
	public List<MovieVO> getSearchMovie(SqlMapClient smc, MovieVO mv) throws SQLException {
		
		
		List<MovieVO> movieList =
				smc.queryForList("movie.getSearchMovie", mv);
		
		return movieList;
	}	

	/*@Override
	public List<MovieVO> getAllCodeMovieList(SqlMapClient smc) throws SQLException {

		List<MovieVO> movieCodeList = smc.queryForList("movie.getAllCodeMovieList");
		
		return movieCodeList;
	}*/

	@Override
	public List<CodeVO> getAllGenreList(SqlMapClient smc) throws SQLException {
		
		List<CodeVO> genreList = smc.queryForList("movie.getAllGenreList");
		
		return genreList;
	}

	

	
	
	


}
