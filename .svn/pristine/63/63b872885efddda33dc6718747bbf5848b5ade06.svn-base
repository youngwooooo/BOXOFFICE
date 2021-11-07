package admin.board.handler;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.service.IBoardService;
import admin.board.service.BoardServiceImpl;
import common.handler.CommandHandler;
import common.vo.PostVO;

public class ListBoard2Handler implements CommandHandler{
	
//	private static final String VIEW_PAGE = "/jsp/admin/board/mainBoard2.jsp";
	private static final String VIEW_PAGE = "/jsp/admin/board/event.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return false; //첫화면은 바로뜸
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		IBoardService BoardService = BoardServiceImpl.getInstance();
		
		List<PostVO> boardList = BoardService.getAllBoardList2();
		
		req.setAttribute("boardList", boardList);
		
		return VIEW_PAGE;
		
	}

}
