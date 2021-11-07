package admin.audience.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.audience.service.AudienceServiceImpl;
import admin.audience.service.IAudienceService;
import common.handler.CommandHandler;
import common.vo.CodeVO;

public class AudienceListHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/admin/audience/audienceJson.jsp";
	
	private IAudienceService audienceService = AudienceServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List<CodeVO> audienceList = audienceService.retrieveAudienceList();
		
		req.setAttribute("audienceList", audienceList);
		
		return VIEW_PAGE;
	}
	
}
