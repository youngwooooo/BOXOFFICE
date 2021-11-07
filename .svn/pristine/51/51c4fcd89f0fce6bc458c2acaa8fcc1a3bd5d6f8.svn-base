package member.signup.service;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.MemberVO;
import member.signup.dao.ISignUpDao;
import member.signup.dao.SignUpDaoImpl;

public class SignUpServiceImpl extends BaseDao implements ISignUpService {
	private static ISignUpDao isd;
	private static ISignUpService iss; 
	
	private static SqlMapClient smc;
	
	public SignUpServiceImpl() {
		isd = SignUpDaoImpl.getInstance();
		smc = super.getSqlMapClient();
	}
	
	public static ISignUpService getInstance() {
		
		if(iss == null) {
			iss = new SignUpServiceImpl();
		}
		return iss;
	}

	@Override
	public int insertMemberInfo(MemberVO mv) {
		
		int cnt = 0;
		
		try {
			isd.insertMemberInfo(mv);
			cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public MemberVO retrieveMemberByMemId(String memId) throws SQLException {
		
		return isd.retrieveMemberByMemId(memId);
	}

	@Override
	public int createMember(MemberVO memberVO) throws SQLException {
		int max = isd.retrieveMaxMemCd() + 1;
		
		String memCd = "M";
		for(int i=0 ; i<7-String.valueOf(max).length() ; i++) {
			memCd += 0;
		}
		memCd += max;
		
		memberVO.setMemCd(memCd);
		
		return isd.createMember(memberVO);
	}
	
	

}
