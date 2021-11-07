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

public class UpdateMemberInfoHandler implements CommandHandler{	

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
			LoginVO lv = (LoginVO) req.getSession().getAttribute("loginVO");
			
			MemberVO memberVO;
			if(lv == null || lv.getMemId() == null) {
				memberVO = new MemberVO();
			} else {
				memberVO = ims.retrieveMember(lv.getMemId());
			}

			req.setAttribute("memberVO", memberVO);
			
			return VIEW_PAGE;
			
		}else if( "Check".equals(req.getParameter("flag")) ) {
			MemberVO mv = new MemberVO();
			
			BeanUtils.populate(mv, req.getParameterMap());
			
			mv.setMemHp(mv.getMemHp().replaceAll("-", ""));
			
			int cnt = ims.updateMemberInfo(mv);
			
			if(cnt > 0) {
				LOGGER.debug("회원정보 수정 성공!");
			}else {
				LOGGER.debug("회원정보 수정 실패...");
			}
			
			req.setAttribute("result", cnt);
			
			VIEW_PAGE = "/jsp/common/resultJson.jsp";
		}
		
		
		return VIEW_PAGE;
	}

}
