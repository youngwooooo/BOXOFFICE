package member.ticketing.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.ChargeVO;
import member.ticketing.service.ITicketingService;
import member.ticketing.service.ticketingServiceImpl;

public class RetrieveTicketingPriceHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/member/ticketing/ticketingPriceJson.jsp";
	private ITicketingService ticketService = ticketingServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ChargeVO chargeVO = new ChargeVO();
		
		chargeVO.setChgWeekendYn(req.getParameter("weekendYn"));
		chargeVO.setChgAudienceCd(req.getParameter("audienceCd"));
		chargeVO.setChgTimeCd(req.getParameter("timeTypeCd"));
		chargeVO.setChgSeatCd(req.getParameter("seatTypeCd"));
		chargeVO.setChgScreenCd(req.getParameter("screenCd"));
		
		int price = ticketService.retrievePrice(chargeVO);
		
		req.setAttribute("price", price);
		
		return VIEW_PAGE;
	}

}
