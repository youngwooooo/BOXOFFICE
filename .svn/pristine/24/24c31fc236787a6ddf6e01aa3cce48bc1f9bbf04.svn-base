package member.inquery.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.MemberVO;
import member.inquery.service.IInqueryService;
import member.inquery.service.InqueryServiceImpl;

public class RetrieveMemberForPasswordChange implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private IInqueryService service = InqueryServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setMemId(req.getParameter("memId"));
		memberVO.setMemName(req.getParameter("memName"));
		
		int count = service.retrieveMemberForPassword(memberVO);
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
