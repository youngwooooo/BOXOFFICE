package member.board.handler;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.service.IBoardService;
import admin.board.service.BoardServiceImpl;
import common.handler.CommandHandler;
import common.vo.PagingVO;
import common.vo.PostVO;

public class NoticeListHandler implements CommandHandler{
	
//	private static final String VIEW_PAGE = "/jsp/admin/board/mainBoard.jsp";
	private static final String VIEW_PAGE = "/jsp/member/board/notice.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return false; //첫화면은 바로뜸
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo")); //기본적으로 파라미터 정보는 String이라서 int로 형변환
		
		IBoardService BoardService = BoardServiceImpl.getInstance();
		
		PagingVO pagingVO = new PagingVO();
		
		int totalCnt = BoardService.getTotalCnt();
		
		pagingVO.setTotalCount(totalCnt);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setCountPerPage(5);
		pagingVO.setPageSize(5);
		
		
		List<PostVO> boardList = BoardService.getAllBoardList();
		
		req.setAttribute("boardList", boardList);
		
		return VIEW_PAGE;
		
	}

}
