package admin.charge.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import admin.charge.service.ChargeServiceImpl;
import admin.charge.service.IChargeService;
import common.handler.CommandHandler;
import common.vo.CdChargeVO;
import common.vo.PagingVO;

public class ChargeListHandler implements CommandHandler {
	
	private static final Logger LOGGER = Logger.getLogger(ChargeListHandler.class);
	private static final String VIEW_PAGE = "/jsp/admin/charge/chargeJson.jsp";

	private IChargeService chargeService = ChargeServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		System.out.println("확인 pageNo : " + req.getParameter("pageNo"));
		int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo")); 

		PagingVO pagingVO = new PagingVO();
		
		int totalCount = chargeService.getTotalCnt();
		
		pagingVO.setTotalCount(totalCount);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setCountPerPage(12);
		pagingVO.setPageSize(10);
						
		List<CdChargeVO> list = chargeService.retrieveChargeList(pagingVO);
		
		req.setAttribute("pagingVO", pagingVO);
		req.setAttribute("list", list);
		
		return VIEW_PAGE;
	}
	
}
