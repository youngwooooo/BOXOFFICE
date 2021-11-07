package admin.member.handler;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.member.service.IMemberService;
import admin.member.service.MemberServiceImpl;
import common.handler.CommandHandler;
import common.vo.MemberVO;

public class SearchMemberHandler implements CommandHandler{
	
	private static final String VIEW_PAGE = "/TicketingProject/jsp/admin/memberSerached.jsp";
	private IMemberService memService = MemberServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			String search = req.getParameter("search");
			System.out.println(search);
			String searchVal = req.getParameter("searchVal");
			System.out.println(searchVal);
			
			MemberVO mv = new MemberVO();
			if(search.equals("memCd")) {
				mv.setMemCd(searchVal);
			}else if(search.equals("memId")){
				mv.setMemId(searchVal);
			}
			
		
			List<MemberVO> memSearchList = memService.getSearchMember(mv);
			
			req.setAttribute("memSearchList", memSearchList);
			
			return VIEW_PAGE;
		
	}

}
