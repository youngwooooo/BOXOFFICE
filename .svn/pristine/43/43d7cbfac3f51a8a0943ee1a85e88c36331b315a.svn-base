package admin.seat.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.seat.dao.SeatDaoImpl;
import admin.seat.dao.ISeatDao;
import common.vo.CodeVO;
import util.SqlMapClientFactory;

public class SeatServiceImpl implements ISeatService {

	private ISeatDao seatDao;
	private static ISeatService instance;
	private SqlMapClient smc;
	
	private SeatServiceImpl() {
		seatDao = SeatDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ISeatService getInstance() {
		if(instance == null) {
			instance = new SeatServiceImpl();
		}
		
		return instance;
	}

	@Override
	public List<CodeVO> retrieveSeatList() {
		List<CodeVO> list = new ArrayList<>();
		
		try {
			list = seatDao.retrieveSeatList(smc);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getTotalCnt() {
		
		int cnt = 0;
		
		try {
			cnt = seatDao.getTotalCnt(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int createSeat(CodeVO codeVO) {
		int count = 0;
		
		try {
			int newMax = seatDao.retrieveMaxSeatCode(smc) + 1;
			
			String cd = "";
			
			if(newMax < 10) {
				cd = "0" + newMax;
			} else {
				cd = String.valueOf(newMax);
			}
			
			codeVO.setCd(cd);
			
			count = seatDao.createSeat(smc, codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifySeat(CodeVO codeVO) {
		int count = 0;
		
		try {
			count = seatDao.modifySeat(smc, codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return count;
	}

	@Override
	public int deleteSeat(CodeVO codeVO) {
		int count = 0;
		CodeVO checkCodeExist = null;
		
		try {
			checkCodeExist = seatDao.retrieveSeat(smc, codeVO);
			
			if(checkCodeExist != null) {
				count = seatDao.deleteSeat(smc, codeVO);
			} else {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
