package admin.movie.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.movie.service.IMovieService;
import admin.movie.service.MovieServiceImpl;
import common.handler.CommandHandler;

public class DeleteMovieHandler implements CommandHandler{
	
	private IMovieService movieService = MovieServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		
		String mvCd = req.getParameter("mvCd");
		
		int cnt = movieService.deleteMovie(mvCd);
		
		String msg = "";
		
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		String redirectURL = req.getContextPath() 
				+ "/admin/movielist.do?msg=" + URLEncoder.encode(msg, "utf-8");
		
		return redirectURL;
	}

}
