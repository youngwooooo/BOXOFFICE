package admin.time.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.time.dao.TimeDaoImpl;
import admin.time.dao.ITimeDao;
import common.vo.CodeVO;
import util.SqlMapClientFactory;

public class TimeServiceImpl implements ITimeService {

	private ITimeDao timeDao;
	private static ITimeService instance;
	private SqlMapClient smc;
	
	private TimeServiceImpl() {
		timeDao = TimeDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ITimeService getInstance() {
		if(instance == null) {
			instance = new TimeServiceImpl();
		}
		
		return instance;
	}

	@Override
	public List<CodeVO> retrieveTimeList() {
		List<CodeVO> list = new ArrayList<>();
		
		try {
			list = timeDao.retrieveTimeList(smc);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getTotalCnt() {
		
		int cnt = 0;
		
		try {
			cnt = timeDao.getTotalCnt(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int createTime(CodeVO codeVO) {
		int count = 0;
		
		try {
			int newMax = timeDao.retrieveMaxTimeCode(smc) + 1;
			
			String cd = "";
			
			if(newMax < 10) {
				cd = "0" + newMax;
			} else {
				cd = String.valueOf(newMax);
			}
			
			codeVO.setCd(cd);
			
			count = timeDao.createTime(smc, codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifyTime(CodeVO codeVO) {
		int count = 0;
		
		try {
			count = timeDao.modifyTime(smc, codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return count;
	}

	@Override
	public int deleteTime(CodeVO codeVO) {
		int count = 0;
		CodeVO checkCodeExist = null;
		
		try {
			checkCodeExist = timeDao.retrieveTime(smc, codeVO);
			
			if(checkCodeExist != null) {
				count = timeDao.deleteTime(smc, codeVO);
			} else {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
