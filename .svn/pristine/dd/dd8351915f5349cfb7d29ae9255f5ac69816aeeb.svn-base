package member.product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.LoginVO;
import common.vo.MemberProductVO;
import member.product.service.IMemberProductService;
import member.product.service.MemberProductServiceImpl;

public class MemberProductDetailHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/jsp/member/product/memberProductDetail.jsp";
	private IMemberProductService productService = MemberProductServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String prodCd = req.getParameter("prodCd");
		
		MemberProductVO memberProductVO = productService.getProductDetail(prodCd);
		req.setAttribute("memberProductVO", memberProductVO);
		
		
		return VIEW_PAGE;
	}

}
