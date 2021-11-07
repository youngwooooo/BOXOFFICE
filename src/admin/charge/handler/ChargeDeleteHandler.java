package admin.charge.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.charge.service.ChargeServiceImpl;
import admin.charge.service.IChargeService;
import common.handler.CommandHandler;
import common.vo.CdChargeVO;

public class ChargeDeleteHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private IChargeService chargeService = ChargeServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		CdChargeVO cdChargeVO = new CdChargeVO();
		String s = req.getParameter("chgChargeCd");
		cdChargeVO.setChgChargeCd(req.getParameter("chgChargeCd"));
		cdChargeVO.setChgWeekendYn(req.getParameter("chgWeekendYn"));
		String cdname1 = req.getParameter("cdName1");
		cdChargeVO.setCdName1(req.getParameter("cdName1"));
		cdChargeVO.setCdName2(req.getParameter("cdName2"));
		cdChargeVO.setCdName3(req.getParameter("cdName3"));
		cdChargeVO.setCdName4(req.getParameter("cdName4"));
		cdChargeVO.setChgPrice(req.getParameter("chgPrice"));
		
		int count = chargeService.deleteCharge(cdChargeVO);
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
