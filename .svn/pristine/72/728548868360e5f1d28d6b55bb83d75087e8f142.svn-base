package admin.movie.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.movie.service.IManageCategoryService;
import admin.movie.service.ManageCategoryServiceImpl;
import common.handler.CommandHandler;
import common.vo.CodeVO;
import common.vo.PagingVO;

public class ManageCategoryHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/jsp/admin/category/manageCategory.jsp";	
	
	private IManageCategoryService imcs = ManageCategoryServiceImpl.getInstance();	
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {		
		
		// 요청 페이지 번호 가져오기
		int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		
		PagingVO pagingVO = new PagingVO();
		
		int totalCnt = imcs.getTotalCnt();
		
		pagingVO.setTotalCount(totalCnt);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setCountPerPage(5);
		pagingVO.setPageSize(5);
		
		// 영화장르 정보를 출력하기 위한 리스트
		List<CodeVO> genreList = imcs.getAllGenreList(pagingVO);
		
		req.setAttribute("genreList", genreList);
		req.setAttribute("pagingVO", pagingVO);
		
		return VIEW_PAGE;
	}
	
}













