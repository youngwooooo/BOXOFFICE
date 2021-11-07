package member.ticketing.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.TicketingShowVO;

public class SetTicketingSeatHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/member/ticketing/ticketingSeat.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		TicketingShowVO ticketingShowVO = new TicketingShowVO();
		
		ticketingShowVO.setShowDate(req.getParameter("savedDate"));
		ticketingShowVO.setMvCd(req.getParameter("savedMovieCd"));
		ticketingShowVO.setMvNameKor(req.getParameter("savedMovieName"));
		ticketingShowVO.setCinemaCd(req.getParameter("savedCinemaCd"));
		ticketingShowVO.setCinemaName(req.getParameter("savedCinemaName"));
		ticketingShowVO.setShowStartTime(req.getParameter("savedTime"));
		ticketingShowVO.setTheaterCd(req.getParameter("savedTheaterCd"));
		ticketingShowVO.setTheaterNo(req.getParameter("savedTheaterNo"));
		ticketingShowVO.setScreenCd(req.getParameter("savedScreenCd"));
		ticketingShowVO.setScreenName(req.getParameter("savedScreenName"));
		ticketingShowVO.setFileStoreName(req.getParameter("savedMovieFileStoreName"));
		ticketingShowVO.setShowCd(req.getParameter("savedShowCd"));
		
		req.setAttribute("ticketingShowVO", ticketingShowVO);
		
		return VIEW_PAGE;
	}

}
