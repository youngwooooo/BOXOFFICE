package admin.time.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.time.service.TimeServiceImpl;
import admin.time.service.ITimeService;
import common.handler.CommandHandler;
import common.vo.CodeVO;

public class TimeListHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/admin/time/timeJson.jsp";
	
	private ITimeService timeService = TimeServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List<CodeVO> timeList = timeService.retrieveTimeList();
		
		req.setAttribute("timeList", timeList);
		
		return VIEW_PAGE;
	}
	
}
