package admin.charge.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.charge.service.IChargeService;
import admin.charge.service.ChargeServiceImpl;
import common.handler.CommandHandler;
import common.vo.CdChargeVO;

public class ChargeModifyHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private IChargeService chargeService = ChargeServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		CdChargeVO cdChargeVO = new CdChargeVO();
		
		if(req.getParameter("chgWeekendYn").equals("주중")) {
			cdChargeVO.setChgWeekendYn("N");
		}else if(req.getParameter("chgWeekendYn").equals("주말")) {
			cdChargeVO.setChgWeekendYn("Y");
		}
		
		if(req.getParameter("cdName1").equals("성인")) {
			cdChargeVO.setCdName1("01");
		}else if(req.getParameter("cdName1").equals("청소년")) {
			cdChargeVO.setCdName1("02");
		}else if(req.getParameter("cdName1").equals("경로")) {
			cdChargeVO.setCdName1("03");
		}else if(req.getParameter("cdName1").equals("우대")) {
			cdChargeVO.setCdName1("04");
		}
		
		if(req.getParameter("cdName2").equals("조조")) {
			cdChargeVO.setCdName2("01");
		}else if(req.getParameter("cdName2").equals("일반")) {
			cdChargeVO.setCdName2("02");
		}else if(req.getParameter("cdName2").equals("심야")) {
			cdChargeVO.setCdName2("03");
		}
		
		if(req.getParameter("cdName3").equals("이코노미")) {
			cdChargeVO.setCdName3("01");
		}else if(req.getParameter("cdName3").equals("스탠다드")) {
			cdChargeVO.setCdName3("02");
		}else if(req.getParameter("cdName3").equals("프리미엄")) {
			cdChargeVO.setCdName3("03");
		}else if(req.getParameter("cdName3").equals("장애인석")) {
			cdChargeVO.setCdName3("04");
		}
		
		if(req.getParameter("cdName4").equals("2D")) {
			cdChargeVO.setCdName4("01");
		}else if(req.getParameter("cdName4").equals("3D")) {
			cdChargeVO.setCdName4("02");
		}else if(req.getParameter("cdName4").equals("4D")) {
			cdChargeVO.setCdName4("03");
		}else if(req.getParameter("cdName4").equals("IMAX")) {
			cdChargeVO.setCdName4("04");
		}
		
		cdChargeVO.setChgChargeCd(req.getParameter("chgChargeCd"));
//		cdChargeVO.setChgWeekendYn(req.getParameter("chgWeekendYn"));
//		cdChargeVO.setCdName1(req.getParameter("cdName1"));
//		cdChargeVO.setCdName2(req.getParameter("cdName2"));
//		cdChargeVO.setCdName3(req.getParameter("cdName3"));
//		cdChargeVO.setCdName4(req.getParameter("cdName4"));
		cdChargeVO.setChgPrice(req.getParameter("chgPrice"));
		
		int count = chargeService.modifyCharge(cdChargeVO);
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}

}
