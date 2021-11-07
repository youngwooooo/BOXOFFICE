package admin.time.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.time.service.ITimeService;
import admin.time.service.TimeServiceImpl;
import common.handler.CommandHandler;
import common.vo.CodeVO;

public class TimeModifyHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private ITimeService timeService = TimeServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		CodeVO codeVO = new CodeVO();
		codeVO.setCd(req.getParameter("cd"));
		codeVO.setCdName(req.getParameter("cdName"));
		codeVO.setCdDesc(req.getParameter("cdDesc"));
		codeVO.setDeleteYn(req.getParameter("deleteYn"));
		
		int count = timeService.modifyTime(codeVO);
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
