package admin.board.handler;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import admin.board.service.IBoardService;
import admin.board.service.BoardServiceImpl;
import common.handler.CommandHandler;
import common.vo.PostVO;

public class updateEventHandler implements CommandHandler{

//	private static final String VIEW_PAGE = "/jsp/admin/board/updateEvent.jsp";
	private static final String VIEW_PAGE = "/jsp/admin/board/eventUpdate.jsp";

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
			
			String postCd = req.getParameter("postCd");
			
			IBoardService noticeService = BoardServiceImpl.getInstance();
			
			PostVO postVO = noticeService.getBoard(postCd);
			
			req.setAttribute("postVO", postVO);
			
			return VIEW_PAGE;
			
		}else {
			
			String postCd = req.getParameter("postCd");
			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			String postDate = req.getParameter("postDate");
			
			PostVO pv = new PostVO();
			
			pv.setPostCd(postCd);
			pv.setPostTitle(postTitle);
			pv.setPostContent(postContent);
			pv.setPostDate(postDate);

			IBoardService noticeService = BoardServiceImpl.getInstance();
			
			int cnt = noticeService.updateNotice(pv);
			
			
			String redirectURL = req.getContextPath()
					+ "/admin/mainBoard2.do";
			
			return redirectURL;
		}
		
		
		
	}

}
