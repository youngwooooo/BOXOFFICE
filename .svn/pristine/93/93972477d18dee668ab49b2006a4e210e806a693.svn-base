package member.movie.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.handler.CommandHandler;
import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import common.vo.MovieVO;
import common.vo.PagingVO;
import member.movie.service.IMovieService;
import member.movie.service.MovieServiceImpl;


public class ListMovieHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/member/movie/movielist.jsp";
	
	private IMovieService movieService = MovieServiceImpl.getInstance();
	
	private IAtchFileService fileService = AtchFileServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return false; //첫화면은 바로뜸
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		          
		       /*   String mvCd = req.getParameter("mvCd");
					
					// 2. 회원정보 조회
					MovieVO movieVO = movieService.getMovie(mvCd);
					
					
					
					if(movieVO.getAtchFileCd() > 0) {
						AtchFileVO fileVO = new AtchFileVO();
						fileVO.setAtchFileCd(movieVO.getAtchFileCd());
						
						List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
						
						req.setAttribute("atchFileList", atchFileList);
		        }
					
				req.setAttribute("movieVO", movieVO);*/
		
			// 1. 요청 페이지 번호 가져오기
				int pageNo = req.getParameter("pageNo") == null ? 
						1 : Integer.parseInt(req.getParameter("pageNo"));
				
				PagingVO pagingVO = new PagingVO();
				
				int totalCnt = movieService.getTotalCnt();
				
				pagingVO.setTotalCount(totalCnt);
				pagingVO.setCurrentPageNo(pageNo);
				pagingVO.setCountPerPage(4);
				pagingVO.setPageSize(4);
				
				List<MovieVO> movieList = movieService.getAllMovieList(pagingVO);
				
				req.setAttribute("movieList", movieList);
				req.setAttribute("pagingVO", pagingVO);
				
				
		
		
				
				
				return VIEW_PAGE;
		
	}

}
