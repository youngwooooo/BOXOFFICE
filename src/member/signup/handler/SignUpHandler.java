package member.signup.handler;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import common.handler.CommandHandler;
import common.vo.MemberVO;
import member.signup.service.ISignUpService;
import member.signup.service.SignUpServiceImpl;

public class SignUpHandler implements CommandHandler {

	private static final Logger LOGGER = 
			Logger.getLogger(SignUpHandler.class);
	
	private static final String VIEW_PAGE = "/jsp/common/signUp/signUpPage.jsp";
	
	private ISignUpService iss = SignUpServiceImpl.getInstance();	
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {		
		
		return false;
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {	
		
		if(req.getParameter("flag") == null) {
			return VIEW_PAGE;
			
		} else if("C".equals(req.getParameter("flag"))) {
			
			MemberVO mv = new MemberVO();		
			
			BeanUtils.populate(mv, req.getParameterMap());					
					
			mv.setMemHp(mv.getMemHp().replaceAll("-", ""));		
			
			int cnt = iss.insertMemberInfo(mv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "가입 성공";
			}else {
				msg = "가입 실패";
			}
		}
		
		return VIEW_PAGE;
	}

}
