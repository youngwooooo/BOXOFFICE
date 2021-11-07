package member.signup.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.MemberVO;

public class SignUpDaoImpl extends BaseDao implements ISignUpDao{

	private SqlMapClient smc;
	private static ISignUpDao isd;
	
	public SignUpDaoImpl() {
		smc = super.getSqlMapClient();
	}
	
	public static ISignUpDao getInstance() {
		if(isd == null) {
			isd = new SignUpDaoImpl(); 
		}	
		
		return isd;
	}
	
	@Override
	public void insertMemberInfo(MemberVO mv) throws SQLException {		
		smc.insert("memberForSignUp.insertMemberInfo", mv);
	}

	@Override
	public MemberVO retrieveMemberByMemId(String memId) throws SQLException {
		
		return (MemberVO) smc.queryForObject("memberForSignUp.retrieveMemberByMemId", memId);
	}

	@Override
	public int retrieveMaxMemCd() throws SQLException {
		return (Integer)smc.queryForObject("memberForSignUp.retrieveMaxMemCd");
	}

	@Override
	public int createMember(MemberVO memberVO) throws SQLException {
		int result = smc.insert("memberForSignUp.createMember", memberVO) == null ? 1 : 0;
		
		return result;
	}	
	
}
