package member.ticketing.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import member.ticketing.service.ITicketingService;
import member.ticketing.service.ticketingServiceImpl;

public class SetTicketingMainHandler implements CommandHandler {

//	private static final String VIEW_PAGE = "/jsp/member/ticketing/ticketingMovieMainJson.jsp";
	private static final String VIEW_PAGE = "/jsp/member/ticketing/ticketingMovie.jsp";
	private ITicketingService ticketService = ticketingServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, Object> mapForSetMain = ticketService.setTicketingMain();
		
		req.setAttribute("mapForSetMain", mapForSetMain);
		
		
		return VIEW_PAGE;
	}

}
