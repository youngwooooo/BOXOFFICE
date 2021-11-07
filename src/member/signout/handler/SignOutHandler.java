package member.signout.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.handler.CommandHandler;

public class SignOutHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/jsp/common/main.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getSession().invalidate();
		
		return VIEW_PAGE;
	}

}
