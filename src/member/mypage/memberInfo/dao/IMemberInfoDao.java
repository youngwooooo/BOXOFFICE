package member.mypage.memberInfo.dao;

import common.vo.MemberVO;

import java.sql.SQLException;

public interface IMemberInfoDao {
	public MemberVO retrieveMember(String memId) throws SQLException;
	
	public MemberVO retrieveMemberByMemPass(String memPass) throws SQLException;
	
	public int updateMemberInfo(MemberVO mv) throws SQLException;
	
	public int deleteMemberInfo(String memId) throws SQLException;
}
