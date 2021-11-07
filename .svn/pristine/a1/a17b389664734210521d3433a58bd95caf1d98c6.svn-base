package admin.movie.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.movie.service.IManageCategoryService;
import admin.movie.service.ManageCategoryServiceImpl;
import common.vo.CodeVO;
import common.vo.PagingVO;

/**
 * Servlet implementation class ManageCategoryServlet
 */
@WebServlet("/ManageCategoryServlet")
public class ManageCategoryServlet extends HttpServlet {
	
	private static final String VIEW_PAGE = "/jsp/common/pagingJson.jsp";	
	
	private IManageCategoryService imcs = ManageCategoryServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		
		PagingVO pagingVO = new PagingVO();
		
		int totalCnt = imcs.getTotalCnt();
		
		pagingVO.setTotalCount(totalCnt);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setCountPerPage(5);
		pagingVO.setPageSize(5);
		System.out.println("getLastPageNo : " + pagingVO.getLastPageNo());
		
		// 영화장르 정보를 출력하기 위한 리스트
		List<CodeVO> genreList = imcs.getAllGenreList(pagingVO);
		
		req.setAttribute("list", genreList);
		req.setAttribute("pagingVO", pagingVO);
		
		req.getRequestDispatcher(VIEW_PAGE).forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		doGet(request, response);
		
		
	}

}
