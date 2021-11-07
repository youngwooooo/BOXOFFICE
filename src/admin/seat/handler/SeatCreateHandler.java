package admin.seat.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.seat.service.ISeatService;
import admin.seat.service.SeatServiceImpl;
import common.handler.CommandHandler;
import common.vo.CodeVO;

public class SeatCreateHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private ISeatService seatService = SeatServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		CodeVO codeVO = new CodeVO();
		codeVO.setCdName(req.getParameter("cdName"));
		codeVO.setCdDesc(req.getParameter("cdDesc"));
		codeVO.setDeleteYn(req.getParameter("deleteYn"));
		
		int count = seatService.createSeat(codeVO);
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
