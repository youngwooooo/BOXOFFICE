package admin.cinema.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.cinema.service.CinemaServiceImpl;
import admin.cinema.service.ICinemaService;
import common.handler.CommandHandler;
import common.vo.CinemaVO;
import common.vo.CodeVO;

public class CinemaModifyHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/admin/cinema/cinemaModify.jsp";
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
			Map<String, Object> cinemaInfo = service.retrieveCinema(req.getParameter("cinemaCd"));

			req.setAttribute("list", list);
			req.setAttribute("cinemaInfo", cinemaInfo);
			
			return VIEW_PAGE;
			
		} else {
			CinemaVO cinemaVO = new CinemaVO();
			cinemaVO.setCinemaCd(req.getParameter("cinemaCd"));
			cinemaVO.setCinemaOpenDate(req.getParameter("cinemaOpenDate").replace("-", ""));
			cinemaVO.setCinemaTel(req.getParameter("cinemaTel"));
			cinemaVO.setCinemaZip(req.getParameter("cinemaZip"));
			cinemaVO.setCinemaAddr1(req.getParameter("cinemaAddr1"));
			cinemaVO.setCinemaAddr2(req.getParameter("cinemaAddr2"));
			cinemaVO.setCinemaStatusCd(req.getParameter("cinemaStatus"));
			cinemaVO.setMapX(req.getParameter("mapX"));
			cinemaVO.setMapY(req.getParameter("mapY"));
			
			int count = service.modifyCinema(cinemaVO);
			
			req.setAttribute("result", count);
			
			return "/jsp/common/resultJson.jsp";
		}
	}
}
