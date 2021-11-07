package member.product.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.MemberProductVO;
import member.product.service.IMemberProductService;
import member.product.service.MemberProductServiceImpl;

public class MemberProductListHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/member/product/memberProductList.jsp";
	private IMemberProductService memberProductService = MemberProductServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<MemberProductVO> memberProductList = memberProductService.memberProductList();
		
		req.setAttribute("memberProductList", memberProductList);
		
		return VIEW_PAGE;
	}

}
