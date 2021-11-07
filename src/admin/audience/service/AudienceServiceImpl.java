package admin.audience.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.audience.dao.AudienceDaoImpl;
import admin.audience.dao.IAudienceDao;
import common.vo.CodeVO;
import util.SqlMapClientFactory;

public class AudienceServiceImpl implements IAudienceService {

	private IAudienceDao audienceDao;
	private static IAudienceService instance;
	private SqlMapClient smc;
	
	private AudienceServiceImpl() {
		audienceDao = AudienceDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IAudienceService getInstance() {
		if(instance == null) {
			instance = new AudienceServiceImpl();
		}
		
		return instance;
	}

	@Override
	public List<CodeVO> retrieveAudienceList() {
		List<CodeVO> list = new ArrayList<>();
		
		try {
			list = audienceDao.retrieveAudienceList(smc);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getTotalCnt() {
		
		int cnt = 0;
		
		try {
			cnt = audienceDao.getTotalCnt(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int createAudience(CodeVO codeVO) {
		int count = 0;
		
		try {
			int newMax = audienceDao.retrieveMaxAudienceCode(smc) + 1;
			
			String cd = "";
			
			if(newMax < 10) {
				cd = "0" + newMax;
			} else {
				cd = String.valueOf(newMax);
			}
			
			codeVO.setCd(cd);
			
			count = audienceDao.createAudience(smc, codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifyAudience(CodeVO codeVO) {
		int count = 0;
		
		try {
			count = audienceDao.modifyAudience(smc, codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return count;
	}

	@Override
	public int deleteAudience(CodeVO codeVO) {
		int count = 0;
		CodeVO checkCodeExist = null;
		
		try {
			checkCodeExist = audienceDao.retrieveAudience(smc, codeVO);
			
			if(checkCodeExist != null) {
				count = audienceDao.deleteAudience(smc, codeVO);
			} else {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
