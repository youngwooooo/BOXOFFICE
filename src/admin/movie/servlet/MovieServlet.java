package admin.movie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.movie.service.IMovieService;
import admin.movie.service.MovieServiceImpl;
import common.vo.MovieVO;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IMovieService movieService = MovieServiceImpl.getInstance();
	
    public MovieServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mvCd = (String) request.getParameter("mvCd");
		MovieVO movieVo = movieService.getMovie(mvCd);
		
		int resultCnt = 0;
		if(movieVo != null) {
			resultCnt = 1;
		}
		// {"resultCnt" : 0}
		String result = "{\"resultCnt\" : " + resultCnt + "}";
		response.getWriter().append(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
