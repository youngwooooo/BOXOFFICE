package member.ticketing.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.CinemaVO;
import common.vo.TheaterVO;
import member.ticketing.service.ITicketingService;
import member.ticketing.service.ticketingServiceImpl;

public class TicketingCreateHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private ITicketingService ticketingService = ticketingServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Map<String, Object> ticketingInfo = new HashMap<>();
		
		//결제 테이블 
		ticketingInfo.put("memCd", req.getParameter("memCd"));
		
		//티켓 테이블
		ticketingInfo.put("showCd", req.getParameter("showCd"));		
		ticketingInfo.put("totalPrice", req.getParameter("totalPrice"));
		
		//티켓 상세 테이블
		ticketingInfo.put("seatCd", req.getParameter("seatCd"));		
		ticketingInfo.put("seatNo", req.getParameter("seatNo"));		
		ticketingInfo.put("audienceTypeCd", req.getParameter("audienceTypeCd"));		
		ticketingInfo.put("totalPriceStr", req.getParameter("totalPriceStr"));
		ticketingInfo.put("theaterCd", req.getParameter("theaterCd"));
		
		int count = ticketingService.createTicketing(ticketingInfo);

		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
