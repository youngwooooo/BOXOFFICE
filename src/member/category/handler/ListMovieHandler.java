package member.category.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchMovieVO;
import common.vo.CodeVO;
import common.vo.MovieVO;
import common.vo.PagingVO;
import member.category.service.IMovieService;
import member.category.service.MovieServiceImpl;


public class ListMovieHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/member/category/category.jsp";
	
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
		pagingVO.setCountPerPage(1000);
		pagingVO.setPageSize(4);
		
		String groupCd = req.getParameter("groupCd");
		
		MovieVO movieVO = new MovieVO();
		movieVO.setFirstRecNo(pagingVO.getFirstRecNo());
		movieVO.setLastRecNo(pagingVO.getLastRecNo());
		movieVO.setGroupCd(groupCd);
		
		List<AtchMovieVO> atchMovieList = movieService.getAllMovieList(movieVO);
		//List<MovieVO> codeMovieList = movieService.getAllCodeMovieList();  
		
		req.setAttribute("atchMovieList", atchMovieList);
		//req.setAttribute("codeMovieList", codeMovieList);
		req.setAttribute("pagingVO", pagingVO);
		
		if(groupCd != null && groupCd.length() > 0) {
			return "/jsp/member/category/movieListResult.jsp";
		}
		
		return VIEW_PAGE;

	}

}
