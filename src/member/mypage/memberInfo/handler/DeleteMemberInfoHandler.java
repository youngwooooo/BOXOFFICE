package member.mypage.memberInfo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import common.handler.CommandHandler;
import common.vo.LoginVO;
import common.vo.MemberVO;
import member.mypage.memberInfo.service.IMemberInfoService;
import member.mypage.memberInfo.service.MemberInfoServiceImpl;
import member.signup.handler.SignUpHandler;

public class DeleteMemberInfoHandler implements CommandHandler{

	private static final Logger LOGGER = 
			Logger.getLogger(SignUpHandler.class);
	
	private IMemberInfoService ims = MemberInfoServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String VIEW_PAGE = "/jsp/member/mypage/mypage.jsp";
		
		if(req.getParameter("flag") == null) {
			
			
			return VIEW_PAGE;
			
		}else if( "Check".equals(req.getParameter("flag")) ) {
			
			String mv = req.getParameter("memId");
			
			int cnt = ims.deleteMemberInfo(mv);
			
			if(cnt > 0) {
				LOGGER.debug("회원 탈퇴!");
			}else {
				LOGGER.debug("회원정보 탈퇴 실패...");
			}
			
			req.setAttribute("result", cnt);
			
			VIEW_PAGE = "/jsp/common/resultJson.jsp";
		}		
		
		return VIEW_PAGE;
	}

}
