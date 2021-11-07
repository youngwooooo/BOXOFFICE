package member.ticketing.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.TicketingShowVO;
import member.ticketing.service.ITicketingService;
import member.ticketing.service.ticketingServiceImpl;

public class RetrieveTicketingShowHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/member/ticketing/ticketingShowJson.jsp";
	private ITicketingService ticketService = ticketingServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		TicketingShowVO param = new TicketingShowVO();
		param.setMvCd(req.getParameter("savedMovieCd"));
		param.setCinemaCd(req.getParameter("savedCinemaCd"));
		param.setShowDate(req.getParameter("savedDate"));
		
		List<TicketingShowVO> showList = ticketService.retrieveTicketingShow(param);
		
		req.setAttribute("showList", showList);
		
		return VIEW_PAGE;
	}

}
