package admin.cinema.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.cinema.dao.IScreenDao;
import admin.cinema.dao.ScreenDaoImpl;
import common.vo.CodeVO;

public class ScreenServiceImpl implements IScreenService {
	
	private IScreenDao screenDao;
	private static IScreenService instance;
	
	private ScreenServiceImpl() {
		screenDao = ScreenDaoImpl.getInstance();
	}
	
	public static IScreenService getInstance() {
		if(instance == null) {
			instance = new ScreenServiceImpl();
		}
		
		return instance;
	}

	@Override
	public List<CodeVO> retrieveScreenList() {
		List<CodeVO> list = new ArrayList<>();
		
		try {
			list = screenDao.retrieveScreenList();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int createScreen(CodeVO codeVO) {
		int count = 0;
		
		try {
			int max = screenDao.retrieveMaxScreenCode() + 1;
			
			String cd = "";
			
			if(max < 10) {
				cd = "0" + max;
			} else {
				cd = String.valueOf(max);
			}
			
			codeVO.setCd(cd);
			
			count = screenDao.createScreen(codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifyScreen(CodeVO codeVO) {
		int count = 0;
		
		try {
			count = screenDao.modifyScreen(codeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return count;
	}

	@Override
	public int deleteScreen(CodeVO codeVO) {
		int count = 0;
		CodeVO checkCodeExist = null;
		
		try {
			checkCodeExist = screenDao.retrieveScreen(codeVO);
			
			if(checkCodeExist != null) {
				count = screenDao.deleteScreen(codeVO);
			} else {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
