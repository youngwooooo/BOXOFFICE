package member.ticketing.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.TicketingShowVO;
import member.ticketing.service.ITicketingService;
import member.ticketing.service.ticketingServiceImpl;

public class SetTicketingPayHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/jsp/member/ticketing/ticketingPayment.jsp";
	private ITicketingService ticketService = ticketingServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		TicketingShowVO ticketingShowVO = new TicketingShowVO();
		
		ticketingShowVO.setShowDate(req.getParameter("payDate"));
		ticketingShowVO.setMvCd(req.getParameter("payMovieCd"));
		ticketingShowVO.setMvNameKor(req.getParameter("payMovieName"));
		ticketingShowVO.setCinemaCd(req.getParameter("payCinemaCd"));
		ticketingShowVO.setCinemaName(req.getParameter("payCinemaName"));
		ticketingShowVO.setShowStartTime(req.getParameter("payTime"));
		ticketingShowVO.setTheaterCd(req.getParameter("payTheaterCd"));
		ticketingShowVO.setTheaterNo(req.getParameter("payTheaterNo"));
		ticketingShowVO.setScreenCd(req.getParameter("payScreenCd"));
		ticketingShowVO.setScreenName(req.getParameter("payScreenName"));
		ticketingShowVO.setFileStoreName(req.getParameter("payMovieFileStoreName"));
		ticketingShowVO.setShowCd(req.getParameter("payShowCd"));
		
		String payCount = req.getParameter("payCount");
		String paySeat = req.getParameter("paySeat");
		String paySeatNo = req.getParameter("paySeatNo");
		String payPrice = req.getParameter("payPrice");
		String payPriceStr = req.getParameter("payPriceStr");
		String payShowCd = req.getParameter("payShowCd");
		String payAudienceCdStr = req.getParameter("payAudienceCdStr");
		
		req.setAttribute("ticketingShowVO", ticketingShowVO);
		req.setAttribute("payCount", payCount);
		req.setAttribute("paySeat", paySeat);
		req.setAttribute("paySeatNo", paySeatNo);
		req.setAttribute("payPrice", payPrice);
		req.setAttribute("payPriceStr", payPriceStr);
		req.setAttribute("payShowCd", payShowCd);
		req.setAttribute("payAudienceCdStr", payAudienceCdStr);
		
		return VIEW_PAGE;
	}

}
