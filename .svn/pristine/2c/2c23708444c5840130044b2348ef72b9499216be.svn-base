package admin.movierating.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.movierating.dao.MovieRatingDaoImpl;
import admin.movierating.dao.IMovieRatingDao;
import common.vo.CodeVO;
import util.SqlMapClientFactory;

public class MovieRatingServiceImpl implements IMovieRatingService {

	private IMovieRatingDao movieRatingDao;
	private static IMovieRatingService instance;
	private SqlMapClient smc;
	
	private MovieRatingServiceImpl() {
		movieRatingDao = MovieRatingDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IMovieRatingService getInstance() {
		if(instance == null) {
			instance = new MovieRatingServiceImpl();
		}
		
		return instance;
	}

	@Override
	public List<CodeVO> retrieveMovieRatingList() {
		List<CodeVO> list = new ArrayList<>();
		
		try {
			list = movieRatingDao.retrieveMovieRatingList(smc);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getTotalCnt() {
		
		int cnt = 0;
		
		try {
			cnt = movieRatingDao.getTotalCnt(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int createMovieRating(CodeVO codeVO) {
		int count = 0;
		
		try {
			int newMax = movieRatingDao.retrieveMaxMovieRatingCode(smc) + 1;
			
			String cd = "";
			
			if(newMax < 10) {
				cd = "0" + newMax;
			} else {
				cd = String.valueOf(newMax);
			}
			
			codeVO.setCd(cd);
			
			count = movieRatingDao.createMovieRating(smc, codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifyMovieRating(CodeVO codeVO) {
		int count = 0;
		
		try {
			count = movieRatingDao.modifyMovieRating(smc, codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return count;
	}

	@Override
	public int deleteMovieRating(CodeVO codeVO) {
		int count = 0;
		CodeVO checkCodeExist = null;
		
		try {
			checkCodeExist = movieRatingDao.retrieveMovieRating(smc, codeVO);
			
			if(checkCodeExist != null) {
				count = movieRatingDao.deleteMovieRating(smc, codeVO);
			} else {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
