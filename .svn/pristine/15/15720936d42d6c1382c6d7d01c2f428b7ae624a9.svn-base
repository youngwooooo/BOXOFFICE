package member.signin.service;

import java.sql.SQLException;

import common.vo.MemberVO;
import member.signin.dao.ISignInDao;
import member.signin.dao.SignInDaoImpl;

public class SignInServiceImpl implements ISignInService {

	private ISignInDao signInDao;
	private static ISignInService instance;

	private SignInServiceImpl() {
		signInDao = SignInDaoImpl.getInstance();
	}
	
	public static ISignInService getInstance() {
		if(instance == null) {
			instance = new SignInServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public MemberVO retrieveMemberCount(MemberVO memberVO) {
		MemberVO resultMemberVO = null;
		
		try {
			resultMemberVO = signInDao.retrieveMemberCount(memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultMemberVO;
	}

}
