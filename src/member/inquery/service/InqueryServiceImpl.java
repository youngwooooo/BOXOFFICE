package member.inquery.service;

import java.sql.SQLException;

import common.vo.MemberVO;
import member.inquery.dao.IInqueryDao;
import member.inquery.dao.InqueryDaoImpl;

public class InqueryServiceImpl implements IInqueryService {

	private IInqueryDao inqueryDao;
	private static IInqueryService instance;

	private InqueryServiceImpl() {
		inqueryDao = InqueryDaoImpl.getInstance();
	}
	
	public static IInqueryService getInstance() {
		if(instance == null) {
			instance = new InqueryServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public int retrieveMemberForPassword(MemberVO memberVO) {
		int count = 0;
		
		try {
			count = inqueryDao.retrieveMemberForPassword(memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int modifyPassword(MemberVO memberVO) {
		int result = 0;
		
		try {
			result = inqueryDao.modifyPassword(memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
