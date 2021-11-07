package admin.cinema.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.cinema.service.CinemaServiceImpl;
import admin.cinema.service.ICinemaService;
import common.handler.CommandHandler;
import common.vo.SeatVO;

public class SeatDeleteYnModifyHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private ICinemaService service = CinemaServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		SeatVO seatVO = new SeatVO();

		seatVO.setSeatCd(req.getParameter("seatCd"));
		seatVO.setDeleteYn(req.getParameter("deleteYn"));

		int count = service.modifySeatDeleteYn(seatVO);

		req.setAttribute("result", count);
		return VIEW_PAGE;
	}

}
