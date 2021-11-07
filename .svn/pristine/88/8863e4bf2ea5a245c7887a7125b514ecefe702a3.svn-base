package admin.board.handler;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import admin.board.service.BoardServiceImpl;
import admin.board.service.IBoardService;
import common.handler.CommandHandler;

public class deleteEventHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String postCd = req.getParameter("postCd");
		
		IBoardService noticeService = BoardServiceImpl.getInstance();
		
		int cnt = noticeService.deleteNotice(postCd);
		
		String redirectURL = req.getContextPath()
				+ "/admin/mainBoard2.do";
		
		return redirectURL;
	}

}
