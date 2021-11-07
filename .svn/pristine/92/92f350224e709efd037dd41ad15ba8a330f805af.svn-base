package member.board.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import common.handler.CommandHandler;
import common.vo.PagingVO;
import common.vo.PostVO;
import member.board.service.BoardServiceImpl;
import member.board.service.IBoardService;
import member.signup.handler.SignUpHandler;

public class QuestionsListHandler implements CommandHandler{
	
private static final Logger LOGGER = Logger.getLogger(SignUpHandler.class);
	
	private static final String VIEW_PAGE = "/jsp/member/board/questionsBoard.jsp";
	
	private IBoardService ibs = BoardServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// 요청 페이지 번호 가져오기
		int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		
		PagingVO pagingVO = new PagingVO();
		
		int totalCnt = ibs.getTotalCnt();
		
		pagingVO.setTotalCount(totalCnt);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setCountPerPage(5);
		pagingVO.setPageSize(5);
		System.out.println("getLastPageNo : " + pagingVO.getLastPageNo());
		
		List<PostVO> list = ibs.getQuestionsBoardList(pagingVO);
		
		req.setAttribute("list", list);
		req.setAttribute("pagingVO", pagingVO);						
		
		return VIEW_PAGE;
	}

}
