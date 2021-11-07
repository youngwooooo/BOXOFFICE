package member.signup.dao;

import java.sql.SQLException;

import common.vo.MemberVO;

public interface ISignUpDao {
	public void insertMemberInfo(MemberVO mv) throws SQLException;	
	
	public MemberVO retrieveMemberByMemId(String memId) throws SQLException;
	
	public int retrieveMaxMemCd() throws SQLException;
	
	public int createMember(MemberVO memberVO) throws SQLException;
}
