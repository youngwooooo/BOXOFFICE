package admin.member.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.member.service.IMemberService;
import admin.member.service.MemberServiceImpl;
import common.handler.CommandHandler;
import common.vo.MemberVO;
import common.vo.PagingVO;

public class ListMemberHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/admin/memberManagement.jsp";
	private IMemberService memService = MemberServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. 요청 페이지번호 가져오기
		int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		
		// 페이징 객체 생성
		PagingVO pagingVO = new PagingVO();
		// 전체 회원 수 가져오기
		int totalCnt = memService.getTotalCnt();
		// 객체에 SET
		pagingVO.setTotalCount(totalCnt);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setCountPerPage(10);
		pagingVO.setPageSize(5);
		
		
		List<MemberVO> memList = memService.getAllMemberList(pagingVO);
		
		req.setAttribute("memList", memList);  // memList를 request객체에 저장
		req.setAttribute("pagingVO", pagingVO);
		
		return VIEW_PAGE;
	}

}
