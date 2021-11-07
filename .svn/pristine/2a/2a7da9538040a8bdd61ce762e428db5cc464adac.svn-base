package admin.member.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.member.service.IMemberService;
import admin.member.service.MemberServiceImpl;
import common.handler.CommandHandler;
import common.vo.DetailMemberVO;

public class DetailMemberHandler implements CommandHandler{
	
	private static final String VIEW_PAGE = "/jsp/admin/memberDetail.jsp";
	private IMemberService memService = MemberServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			String memId = req.getParameter("memId");
			System.out.println(memId);
			
			// 1. 회원정보 조회
			List<DetailMemberVO> memDetailList = memService.getMember(memId);
			
			// 3. request객체에 정보 저장
			req.setAttribute("memDetailList", memDetailList);
			
			return VIEW_PAGE;
		
	}

}
