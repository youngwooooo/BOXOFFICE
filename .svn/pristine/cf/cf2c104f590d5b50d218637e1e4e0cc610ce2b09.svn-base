package admin.movierating.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.movierating.service.MovieRatingServiceImpl;
import admin.movierating.service.IMovieRatingService;
import common.handler.CommandHandler;
import common.vo.CodeVO;

public class MovieRatingListHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/admin/movieRating/movieRatingJson.jsp";
	
	private IMovieRatingService movieRatingService = MovieRatingServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List<CodeVO> movieRatingList = movieRatingService.retrieveMovieRatingList();
		
		req.setAttribute("movieRatingList", movieRatingList);
		
		return VIEW_PAGE;
	}
	
}
