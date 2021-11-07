package member.ticketing.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.SeatVO;
import common.vo.TheaterVO;
import member.ticketing.service.ITicketingService;
import member.ticketing.service.ticketingServiceImpl;

public class RetrieveTicketingSeatHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/member/ticketing/ticketingSeatJson.jsp";
	private ITicketingService ticketService = ticketingServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String theaterCd = req.getParameter("theaterCd");
		
		TheaterVO theaterVO = ticketService.retrieveTheater(theaterCd);
		List<SeatVO> seatList = ticketService.retrieveSeatList(theaterCd);
		
		req.setAttribute("theaterVO", theaterVO);
		req.setAttribute("seatList", seatList);
		
		return VIEW_PAGE;
	}

}
