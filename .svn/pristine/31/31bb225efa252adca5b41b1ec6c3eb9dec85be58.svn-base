package member.ticketing.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.SeatVO;
import common.vo.TheaterVO;
import common.vo.TicketingVO;
import member.ticketing.service.ITicketingService;
import member.ticketing.service.ticketingServiceImpl;

public class ticketingHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/member/ticketing/ticketing2.jsp";
	private ITicketingService ticketService = ticketingServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		
		String cinemaCd = req.getParameter("cinemaCd");
		String showDate = req.getParameter("showDate");
		String mvNameKor = req.getParameter("mvNameKor");
		String showStartTime = req.getParameter("showStartTime");
	
		
		TicketingVO tkVO = new TicketingVO();
		tkVO.setCinemaCd(cinemaCd);
		tkVO.setShowDate(showDate);
		tkVO.setMvNameKor(mvNameKor);
		tkVO.setShowStartTime(showStartTime);
		
		
		
		List<TicketingVO> ticketingInfoList = ticketService.getTicketingInfoList(tkVO);
		TheaterVO theaterVO = ticketService.retrieveTheater(ticketingInfoList.get(0).getTheaterCd());
		List<SeatVO> seatList = ticketService.retrieveSeatList(ticketingInfoList.get(0).getTheaterCd());
		
		System.out.println("seatList : " + seatList.size());
		
		req.setAttribute("ticketingInfoList", ticketingInfoList);  // memList를 request객체에 저장
		req.setAttribute("theaterVO", theaterVO);
		req.setAttribute("seatList", seatList);
		
		return VIEW_PAGE;
	}

}
