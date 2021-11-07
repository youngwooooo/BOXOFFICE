package admin.cinema.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.cinema.service.CinemaServiceImpl;
import admin.cinema.service.ICinemaService;
import common.handler.CommandHandler;
import common.vo.SeatVO;

public class SeatListRetrieveHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/admin/cinema/seatListJson.jsp";
	private ICinemaService service = CinemaServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String theaterCd = req.getParameter("theaterCd");
		
		List<SeatVO> seatList = service.retrieveSeatList(theaterCd);
		
		req.setAttribute("seatList", seatList);
		
		return VIEW_PAGE;
	}

}
