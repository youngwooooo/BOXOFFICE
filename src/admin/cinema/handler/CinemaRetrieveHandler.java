package admin.cinema.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.cinema.service.CinemaServiceImpl;
import admin.cinema.service.ICinemaService;
import common.handler.CommandHandler;

public class CinemaRetrieveHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/admin/cinema/cinemaDetail.jsp";
	private ICinemaService service = CinemaServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String cinemaCd = req.getParameter("cinemaCd");

		Map<String, Object> cinemaInfo = service.retrieveCinema(cinemaCd);

		req.setAttribute("cinemaInfo", cinemaInfo);
		
		return VIEW_PAGE;
	}

}
