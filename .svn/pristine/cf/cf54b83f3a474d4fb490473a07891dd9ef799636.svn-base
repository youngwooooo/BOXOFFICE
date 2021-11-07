package admin.showtimetable.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.showtimetable.dao.ShowTimetableDaoImpl;
import admin.showtimetable.dao.IShowTimetableDao;
import common.vo.ShowTimetableVO;
import util.SqlMapClientFactory;

public class ShowTimetableServiceImpl implements IShowTimetableService {

	private IShowTimetableDao showTimetableDao;
	private static IShowTimetableService instance;
	private SqlMapClient smc;
	
	private ShowTimetableServiceImpl() {
		showTimetableDao = ShowTimetableDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IShowTimetableService getInstance() {
		if(instance == null) {
			instance = new ShowTimetableServiceImpl();
		}
		
		return instance;
	}

	@Override
	public List<ShowTimetableVO> retrieveShowTimetableList(ShowTimetableVO showVO) {
		List<ShowTimetableVO> list = new ArrayList<>();
		
		try {
			list = showTimetableDao.retrieveShowTimetableList(smc, showVO);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getTotalCnt() {
		
		int cnt = 0;
		
		try {
			cnt = showTimetableDao.getTotalCnt(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}

	
	@Override
	public int createShowTimetable(ShowTimetableVO showTimetableVO) {
		int count = 0;
		
		try {
			String cd = showTimetableDao.retrieveMaxShowTimetableCode(smc).substring(0, 2);
			int newMax = Integer.parseInt(showTimetableDao.retrieveMaxShowTimetableCode(smc).substring(2)) + 1;
				
			/* ex. SH00000001 */
			if(newMax < 10) {
				cd += "0000000" + newMax;
			}else if(newMax < 100) {
				cd += "000000" + newMax;
			}else if(newMax < 1000) {
				cd += "00000" + newMax;
			}else if(newMax < 10000) {
				cd += "0000" + newMax;
			}else if(newMax < 100000) {
				cd += "000" + newMax;
			}else if(newMax < 1000000) {
				cd += "00" + newMax;
			}else if(newMax < 10000000) {
				cd += "0" + newMax;
			}else {
				cd += String.valueOf(newMax);
			}
			
			showTimetableVO.setShowCd(cd);
			
			count = showTimetableDao.createShowTimetable(smc, showTimetableVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifyShowTimetable(ShowTimetableVO showTimetableVO) {
		int count = 0;
		
		try {
			count = showTimetableDao.modifyShowTimetable(smc, showTimetableVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return count;
	}

	@Override
	public int deleteShowTimetable(ShowTimetableVO showTimetableVO) {
		int count = 0;
		ShowTimetableVO checkCodeExist = null;
		
		try {
			checkCodeExist = showTimetableDao.retrieveShowTimetable(smc, showTimetableVO);
			
			if(checkCodeExist != null) {
				count = showTimetableDao.deleteShowTimetable(smc, showTimetableVO);
			} else {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
