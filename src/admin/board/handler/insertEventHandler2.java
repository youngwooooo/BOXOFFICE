package admin.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.service.BoardServiceImpl;
import admin.board.service.IBoardService;
import common.handler.CommandHandler;
import common.vo.PostVO;

public class insertEventHandler2 implements CommandHandler{

//	private static final String VIEW_PAGE = "/jsp/admin/board/insertEvent.jsp";
	private static final String VIEW_PAGE = "/jsp/admin/board/eventInsert2.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false; // forward
			
		}else if(req.getMethod().equals("POST")) {
			return true; // redirect
		}
		
		return false; //디폴트
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
			
		}else {
			String postCd = req.getParameter("postCd");
			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			String boardCd = req.getParameter("boardCd");
//			String postDate = req.getParameter("postDate");
			
			PostVO pv = new PostVO();
			pv.setPostCd(postCd);
			pv.setPostTitle(postTitle);
			pv.setPostContent(postContent);
			pv.setBoardCd(boardCd);
			
			IBoardService noticeService = BoardServiceImpl.getInstance();
			
			int cnt = noticeService.insertNotice(pv);
			
			
			String redirectURL = req.getContextPath()
					+ "/admin/mainBoard2.do";
			
			return redirectURL;
		}
		
		
		
	}

}
