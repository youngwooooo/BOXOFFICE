package admin.showtimetable.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.showtimetable.service.ShowTimetableServiceImpl;
import admin.showtimetable.service.IShowTimetableService;
import common.handler.CommandHandler;
import common.vo.ShowTimetableVO;

public class ShowTimetableListHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/admin/showTimetable/showTimetableJson.jsp";
	
	private IShowTimetableService showTimetableService = ShowTimetableServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ShowTimetableVO showVO = new ShowTimetableVO();
		
		showVO.setShowDate(req.getParameter("showDate"));
		showVO.setCinemaCd(req.getParameter("cinemaCd"));
		
		List<ShowTimetableVO> showTimetableList = showTimetableService.retrieveShowTimetableList(showVO);
		
		req.setAttribute("showTimetableList", showTimetableList);
		
		return VIEW_PAGE;
	}
	
}
