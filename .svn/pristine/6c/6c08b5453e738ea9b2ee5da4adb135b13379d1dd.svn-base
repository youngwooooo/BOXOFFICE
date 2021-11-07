package member.signin.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.cinema.service.CinemaServiceImpl;
import admin.cinema.service.ICinemaService;
import common.handler.CommandHandler;
import common.vo.LoginVO;
import common.vo.MemberVO;
import member.signin.service.ISignInService;
import member.signin.service.SignInServiceImpl;
import util.SHA256Util;

public class SignInHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/member/signIn/signInJson.jsp";
	private ISignInService service = SignInServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMemId(req.getParameter("memId"));
		
		String password = SHA256Util.getEncrypt(req.getParameter("memPass"), req.getParameter("memId"));
		
		memberVO.setMemPass(password);
		
		MemberVO resultMemberVO = service.retrieveMemberCount(memberVO);
		
		if(resultMemberVO != null) {
			HttpSession session = req.getSession(true);
			
			LoginVO loginVO = new LoginVO();
			loginVO.setMemCd(resultMemberVO.getMemCd());
			loginVO.setMemId(resultMemberVO.getMemId());
			loginVO.setMemName(resultMemberVO.getMemName());
			loginVO.setMemHp(resultMemberVO.getMemHp());
			loginVO.setMemMail(resultMemberVO.getMemMail());
			loginVO.setManagerYn(resultMemberVO.getManagerYn());
			
			// 추가
			loginVO.setMemAddr1(resultMemberVO.getMemAddr1());
			loginVO.setMemAddr2(resultMemberVO.getMemAddr2());
			loginVO.setMemBir(resultMemberVO.getMemBir());
			loginVO.setMemZip(resultMemberVO.getMemZip());
			
			session.setAttribute("loginVO", loginVO);
		}
		
		req.setAttribute("memberVO", resultMemberVO);
		
		return VIEW_PAGE;
	}

}
