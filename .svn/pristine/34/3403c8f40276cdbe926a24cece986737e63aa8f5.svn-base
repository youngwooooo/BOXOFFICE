package admin.audience.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.audience.service.IAudienceService;
import admin.audience.service.AudienceServiceImpl;
import common.handler.CommandHandler;
import common.vo.CodeVO;

public class AudienceModifyHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private IAudienceService audienceService = AudienceServiceImpl.getInstance();
	
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
		
		int count = audienceService.modifyAudience(codeVO);
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
