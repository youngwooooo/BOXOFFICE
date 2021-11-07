package member.mypage.memberInfo.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import common.handler.CommandHandler;
import common.vo.MemberVO;
import member.mypage.memberInfo.service.IMemberInfoService;
import member.mypage.memberInfo.service.MemberInfoServiceImpl;
import member.signup.handler.SignUpHandler;

public class PassingHandler implements CommandHandler{	

	private static final Logger LOGGER = 
			Logger.getLogger(SignUpHandler.class);
	
	private static final String VIEW_PAGE = "/jsp/member/mypage/memberInfo/passingJson.jsp";
	
	private IMemberInfoService ims = MemberInfoServiceImpl.getInstance(); 
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {

		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String memPass = req.getParameter("userPwd");
		
		MemberInfoServiceImpl mis = new MemberInfoServiceImpl();
		MemberVO mv = null;
		int resultCnt = 0;
		
		try {
			mv = mis.retrieveMemberByMemPass(memPass);
			if(mv == null) {
				resultCnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("resultCnt", resultCnt);
		
		return VIEW_PAGE;
	}

}
