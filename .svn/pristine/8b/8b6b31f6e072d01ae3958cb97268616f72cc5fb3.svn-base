package admin.cinema.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.cinema.service.IScreenService;
import admin.cinema.service.ScreenServiceImpl;
import common.handler.CommandHandler;
import common.vo.CodeVO;

public class ScreenListHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/common/codeJson.jsp";
	private IScreenService service = ScreenServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<CodeVO> list = service.retrieveScreenList();
		
		req.setAttribute("list", list);
		
		return VIEW_PAGE;
	}

}
