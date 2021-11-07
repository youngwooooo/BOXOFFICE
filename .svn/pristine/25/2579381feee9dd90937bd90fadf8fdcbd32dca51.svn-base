package member.signup.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.MemberVO;
import member.signup.service.ISignUpService;
import member.signup.service.SignUpServiceImpl;
import util.SHA256Util;

public class SignUpEncryptHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private ISignUpService service = SignUpServiceImpl.getInstance();
	
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
		memberVO.setMemName(req.getParameter("memName"));
		memberVO.setMemHp(req.getParameter("memHp"));
		memberVO.setMemMail(req.getParameter("memMail"));
		memberVO.setMemBir(req.getParameter("memBirth").replace("-", ""));
		memberVO.setMemZip(req.getParameter("memZip"));
		memberVO.setMemAddr1(req.getParameter("memAddr1"));
		memberVO.setMemAddr2(req.getParameter("memAddr2"));
		
		int count = service.createMember(memberVO);
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
