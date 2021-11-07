package member.category.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.AtchMovieVO;
import common.vo.CodeVO;
import common.vo.MovieVO;

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
		
		Object obj = smc.insert("categoryMovie.insertMovie", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<AtchMovieVO> getAllMovieList(SqlMapClient smc, MovieVO movieVO) throws SQLException {
		List<AtchMovieVO> movieList = smc.queryForList("categoryMovie.getAllMovieList", movieVO);
		return movieList;
	}
	
	@Override
	public MovieVO getMovie(SqlMapClient smc, String mvCd) throws SQLException {
		MovieVO mv =
				(MovieVO)smc.queryForObject("categoryMovie.getMovie", mvCd);
		return mv;
	}

	@Override
	public int updateMovie(SqlMapClient smc, MovieVO mv) throws SQLException {
		int cnt = smc.update("categoryMovie.updateMovie", mv);
		return cnt;
	}

	@Override
	public int deleteMovie(SqlMapClient smc, String mvCd) throws SQLException {
		int cnt = smc.update("categoryMovie.deleteMovie", mvCd);
		return cnt;
	}

	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("categoryMovie.getTotalCnt");
		return cnt;
	}

	@Override
	public List<MovieVO> getSearchMovie(SqlMapClient smc, MovieVO mv) throws SQLException {
		List<MovieVO> movieList =
				smc.queryForList("categoryMovie.getSearchMovie", mv);
		
		return movieList;
	}	

	/*@Override
	public List<MovieVO> getAllCodeMovieList(SqlMapClient smc) throws SQLException {

		List<MovieVO> movieCodeList = smc.queryForList("categoryMovie.getAllCodeMovieList");
		
		return movieCodeList;
	}*/

	@Override
	public List<CodeVO> getAllGenreList(SqlMapClient smc) throws SQLException {
		List<CodeVO> genreList = smc.queryForList("categoryMovie.getAllGenreList");
		return genreList;
	}

}
