package admin.cinema.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.cinema.service.CinemaServiceImpl;
import admin.cinema.service.ICinemaService;
import common.handler.CommandHandler;
import common.vo.TheaterVO;

public class TheaterModifyHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private ICinemaService service = CinemaServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		TheaterVO theaterVO = new TheaterVO();
		
		theaterVO.setCinemaCd(req.getParameter("cinemaCd"));
		theaterVO.setTheaterCd(req.getParameter("theaterCd"));
		theaterVO.setTheaterNo(Integer.parseInt(req.getParameter("theaterNo")));
		theaterVO.setScreenCd(req.getParameter("screenCd"));
		theaterVO.setRowCount(Integer.parseInt(req.getParameter("seatRows")));
		theaterVO.setColCount(Integer.parseInt(req.getParameter("seatCols")));
		theaterVO.setDeleteYn(req.getParameter("deleteYn"));
		
		String flag = req.getParameter("flag");
		
		int count = service.modifyTheater(theaterVO, flag);
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
