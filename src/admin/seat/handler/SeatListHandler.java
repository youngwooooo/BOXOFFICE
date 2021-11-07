package admin.seat.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.seat.service.SeatServiceImpl;
import admin.seat.service.ISeatService;
import common.handler.CommandHandler;
import common.vo.CodeVO;

public class SeatListHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/admin/seat/seatJson.jsp";
	
	private ISeatService seatService = SeatServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List<CodeVO> seatList = seatService.retrieveSeatList();
		
		req.setAttribute("seatList", seatList);
		
		return VIEW_PAGE;
	}
	
}
