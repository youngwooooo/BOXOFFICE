package member.movie.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;


import common.vo.MovieVO;
import common.vo.PagingVO;
import member.movie.dao.IMovieDao;
import member.movie.dao.MovieDaoImpl;
import util.SqlMapClientFactory;

public class MovieServiceImpl implements IMovieService {

	private IMovieDao movieDao;
	
	private static IMovieService movieService;
	
	private SqlMapClient smc;
	
	private MovieServiceImpl() {
		// TODO Auto-generated constructor stub
		movieDao = MovieDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
		
	}
	
	public static IMovieService getInstance() {
		if(movieService == null) {
			movieService = new MovieServiceImpl();
		}
		
		return movieService;
	}
	
	
	@Override
	public int insertMovie(MovieVO mv) {
		
		
		int cnt = 0;
		
		try {
			cnt = movieDao.insertMovie(smc, mv);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<MovieVO> getAllMovieList() {
	
		List<MovieVO> movieList = new ArrayList<MovieVO>();
		
		
		try {
			movieList = movieDao.getAllMovieList(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movieList;
		
	}

	@Override
	public int updateMovie(MovieVO mv) {
		
		int cnt = 0;
		
		try {
			cnt = movieDao.updateMovie(smc, mv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public MovieVO getMovie(String mvCd) {
		
		
		MovieVO mv = null;
		try {
			mv = movieDao.getMovie(smc, mvCd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}

	@Override
	public int deleteMovie(String mvCd) {
		
		int cnt = 0;
		
		try {
			cnt = movieDao.deleteMovie(smc, mvCd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int getTotalCnt() {
		
		
		int cnt = 0;
		
		try {
			cnt = movieDao.getTotalCnt(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<MovieVO> getAllMovieList(PagingVO pagingVO) {
		
		
		List<MovieVO> movieList = new ArrayList<MovieVO>();
		
		try {
			movieList = movieDao.getAllMovieList(smc, pagingVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movieList;
	}

	@Override
	public List<MovieVO> getSearchMovie(MovieVO mv) {
		
		
		List<MovieVO> movieList = new ArrayList<>();
		
		try {
			movieList = movieDao.getSearchMovie(smc, mv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movieList;
	}
	
	

}
