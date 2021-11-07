package admin.movie.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.movie.service.IMovieService;
import admin.movie.service.MovieServiceImpl;
import common.handler.CommandHandler;
import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import common.vo.AtchMovieVO;
import common.vo.CodeVO;
import common.vo.MovieVO;
import common.vo.PagingVO;


public class ListMovieHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/admin/movie/movielist.jsp";
	
	private IMovieService movieService = MovieServiceImpl.getInstance();
	
	private IAtchFileService fileService = AtchFileServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return false; //첫화면은 바로뜸
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		          
		PagingVO pagingVO = new PagingVO();
		CodeVO codeVO = new CodeVO();	
		
		// 2. 회원정보 조회

	
		// 1. 요청 페이지 번호 가져오기
			int pageNo = req.getParameter("pageNo") == null ? 
					1 : Integer.parseInt(req.getParameter("pageNo"));
			
						
			
			int totalCnt = movieService.getTotalCnt();
			
			pagingVO.setTotalCount(totalCnt);
			pagingVO.setCurrentPageNo(pageNo);
			pagingVO.setCountPerPage(4);
			pagingVO.setPageSize(4);				
			
			List<MovieVO> atchMovieList = movieService.getAllMovieList(pagingVO);
			//List<MovieVO> codeMovieList = movieService.getAllCodeMovieList();  
			
			req.setAttribute("atchMovieList", atchMovieList);
			//req.setAttribute("codeMovieList", codeMovieList);
			req.setAttribute("pagingVO", pagingVO);
			
	
	
			
			
			return VIEW_PAGE;
		
	}

}
