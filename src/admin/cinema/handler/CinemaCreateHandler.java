package admin.cinema.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.cinema.service.CinemaServiceImpl;
import admin.cinema.service.ICinemaService;
import common.handler.CommandHandler;
import common.vo.CinemaVO;
import common.vo.CodeVO;
import common.vo.TheaterVO;

public class CinemaCreateHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/codeJson.jsp";
	private ICinemaService service = CinemaServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			//코드 값만 가져오기
			List<CodeVO> list = service.retrieveCodeList();
			
			req.setAttribute("list", list);
			
			return VIEW_PAGE;
			
		} else {
			Map<String, Object> cinemaInfo = new HashMap<>();

			CinemaVO cinemaVO = new CinemaVO();
			cinemaVO.setCinemaName(req.getParameter("cinemaName").trim());
			cinemaVO.setCinemaOpenDate(req.getParameter("cinemaOpenDate").replace("-", ""));
			cinemaVO.setCinemaZip(req.getParameter("cinemaZip"));
			cinemaVO.setCinemaAddr1(req.getParameter("cinemaAddr1"));
			cinemaVO.setCinemaAddr2(req.getParameter("cinemaAddr2"));
			cinemaVO.setCinemaTel(req.getParameter("cinemaTel"));
			cinemaVO.setCinemaStatusCd(req.getParameter("cinemaStatusCd"));
			cinemaVO.setMapX(req.getParameter("mapX"));
			cinemaVO.setMapY(req.getParameter("mapY"));

			TheaterVO theaterVO = new TheaterVO();
			theaterVO.setTheaterNo(Integer.parseInt(req.getParameter("theaterNo")));
			theaterVO.setScreenCd(req.getParameter("screenCd"));
			theaterVO.setDeleteYn(req.getParameter("deleteYn"));
			theaterVO.setRowCount(Integer.parseInt(req.getParameter("seatRows")));
			theaterVO.setColCount(Integer.parseInt(req.getParameter("seatCols")));

			int flag = Integer.parseInt(req.getParameter("flag"));

			cinemaInfo.put("cinemaVO", cinemaVO);
			cinemaInfo.put("theaterVO", theaterVO);
			cinemaInfo.put("flag", flag);

			int count = service.createCinema(cinemaInfo);

			req.setAttribute("result", count);
			
			return "/jsp/common/resultJson.jsp";
		}
	}
}
