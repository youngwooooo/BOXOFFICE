package admin.cinema.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.cinema.service.CinemaServiceImpl;
import admin.cinema.service.ICinemaService;
import common.handler.CommandHandler;
import common.vo.CinemaVO;

public class CinemaListRetrieveHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/admin/cinema/cinemaListJson.jsp";
	private ICinemaService service = CinemaServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<CinemaVO> cinemaList = service.retrieveCinemaList();

		req.setAttribute("list", cinemaList);
		
		return VIEW_PAGE;
	}

}
