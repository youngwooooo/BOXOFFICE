package member.signup.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.MemberVO;
import member.signup.service.ISignUpService;
import member.signup.service.SignUpServiceImpl;

public class RetrieveIdDuplHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private ISignUpService service = SignUpServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String memId = req.getParameter("memId");
		
		MemberVO memberVO = service.retrieveMemberByMemId(memId);
		
		if(memberVO != null) {
			req.setAttribute("result", 1);
		} else {
			req.setAttribute("result", 0);
		}
		
		return VIEW_PAGE;
	}

}
