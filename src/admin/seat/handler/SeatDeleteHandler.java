package admin.seat.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.seat.service.SeatServiceImpl;
import admin.seat.service.ISeatService;
import common.handler.CommandHandler;
import common.vo.CodeVO;

public class SeatDeleteHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private ISeatService seatService = SeatServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		CodeVO codeVO = new CodeVO();
		
		codeVO.setCd(req.getParameter("cd"));
		codeVO.setCdName(req.getParameter("cdName"));
		codeVO.setCdDesc(req.getParameter("cdDesc"));
		codeVO.setDeleteYn(req.getParameter("deleteYn"));
		
		int count = seatService.deleteSeat(codeVO);
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
