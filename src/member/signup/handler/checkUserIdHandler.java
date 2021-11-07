package member.signup.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import common.handler.CommandHandler;
import common.vo.MemberVO;
import member.signup.service.ISignUpService;
import member.signup.service.SignUpServiceImpl;

public class checkUserIdHandler implements CommandHandler{

	private static final Logger LOGGER = 
			Logger.getLogger(SignUpHandler.class);
	
	private static final String VIEW_PAGE = "/jsp/common/signUp/memberResult.jsp";
	
	private ISignUpService iss = SignUpServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String memId = req.getParameter("userId");
		
		SignUpServiceImpl ssi = new SignUpServiceImpl();
		MemberVO mv = null;
		int resultCnt = 0;
		try {
			mv = iss.retrieveMemberByMemId(memId);
			if(mv != null) {
				resultCnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("resultCnt", resultCnt);		
		
		return VIEW_PAGE;
	}

}
