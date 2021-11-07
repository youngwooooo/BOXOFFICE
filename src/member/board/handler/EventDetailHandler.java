package member.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.service.IBoardService;
import admin.board.service.BoardServiceImpl;
import common.handler.CommandHandler;
import common.vo.PostVO;

public class EventDetailHandler implements CommandHandler{
	
//	private static final String VIEW_PAGE = "/jsp/admin/board/detailEvent.jsp";
	private static final String VIEW_PAGE = "/jsp/member/board/eventDetail.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String postCd = req.getParameter("postCd");
		
		IBoardService noticeService = BoardServiceImpl.getInstance();
		
		PostVO postVO = noticeService.detailNotice(postCd);
		
		req.setAttribute("postVO", postVO);
		
		return VIEW_PAGE;
	}

}
