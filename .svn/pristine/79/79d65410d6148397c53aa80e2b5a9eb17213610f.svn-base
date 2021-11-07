package admin.charge.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.charge.dao.ChargeDaoImpl;
import admin.charge.dao.IChargeDao;
import common.vo.CdChargeVO;
import common.vo.CdChargeVO;
import common.vo.PagingVO;
import util.SqlMapClientFactory;

public class ChargeServiceImpl implements IChargeService {

	private IChargeDao chargeDao;
	private static IChargeService instance;
	private SqlMapClient smc;
	
	private ChargeServiceImpl() {
		chargeDao = ChargeDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IChargeService getInstance() {
		if(instance == null) {
			instance = new ChargeServiceImpl();
		}
		
		return instance;
	}

	@Override
	public List<CdChargeVO> retrieveChargeList(PagingVO pagingVO) {
		List<CdChargeVO> list = new ArrayList<>();
		
		try {
			list = chargeDao.retrieveChargeList(smc, pagingVO);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getTotalCnt() {
		
		int cnt = 0;
		
		try {
			cnt = chargeDao.getTotalCnt(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}

	
	@Override
	public int createCharge(CdChargeVO cdChargeVO) {
		int count = 0;
		
		try {
//			String newMax = "CHG" + Integer.toString(Integer.parseInt(chargeDao.retrieveMaxChargeCode(smc).substring(3)) + 1);
			
//			String cd = max;
			
//			if(max < 10) {
//				cd = "0" + max;
//			} else {
//				cd = String.valueOf(max);
//			}
			
//			cdChargeVO.setChgChargeCd(newMax);
			
			String cd = chargeDao.retrieveMaxChargeCode(smc).substring(0, 3);
			int newMax = Integer.parseInt(chargeDao.retrieveMaxChargeCode(smc).substring(3)) + 1;
			
			if(newMax < 10) {
				cd += "00" + newMax;
			}else if(newMax < 100) {
				cd += "0" + newMax;
			}else {
				cd += String.valueOf(newMax);
			}
			
			cdChargeVO.setChgChargeCd(cd);
			
			count = chargeDao.createCharge(smc, cdChargeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifyCharge(CdChargeVO cdChargeVO) {
		int count = 0;
		
		try {
			count = chargeDao.modifyCharge(smc, cdChargeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return count;
	}

	@Override
	public int deleteCharge(CdChargeVO cdChargeVO) {
		int count = 0;
		CdChargeVO checkCodeExist = null;
		
		try {
			checkCodeExist = chargeDao.retrieveCharge(smc, cdChargeVO);
			
			if(checkCodeExist != null) {
				count = chargeDao.deleteCharge(smc, cdChargeVO);
			} else {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
