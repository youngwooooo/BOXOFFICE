package member.movie.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

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
		
		Object obj = smc.insert("movieMem.insertMovie", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<MovieVO> getAllMovieList(SqlMapClient smc) throws SQLException {
		List<MovieVO> movieList = 
				smc.queryForList("movieMem.getAllMovieList");
		return movieList;
	}
	
	@Override
	public MovieVO getMovie(SqlMapClient smc, String mvCd) throws SQLException {
		
		
		MovieVO mv =
				(MovieVO)smc.queryForObject("movieMem.getMovie", mvCd);
		
		return mv;
	}

	@Override
	public int updateMovie(SqlMapClient smc, MovieVO mv) throws SQLException {
		
		int cnt = smc.update("movieMem.updateMovie", mv);
		
		return cnt;
	}

	@Override
	public int deleteMovie(SqlMapClient smc, String mvCd) throws SQLException {
		
		int cnt = smc.update("movieMem.deleteMovie", mvCd);
		
		return cnt;
	}

	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("movieMem.getTotalCnt");
		return cnt;
	}

	@Override
	public List<MovieVO> getAllMovieList(SqlMapClient smc, PagingVO pagingVO) throws SQLException {
		
		List<MovieVO> movieList = 
				smc.queryForList("movieMem.getMovieAll", pagingVO);
		
		return movieList;
	}

	@Override
	public List<MovieVO> getSearchMovie(SqlMapClient smc, MovieVO mv) throws SQLException {
		
		
		List<MovieVO> movieList =
				smc.queryForList("movieMem.getSearchMovie", mv);
		
		return movieList;
	}
	
	

	
	
	


}
