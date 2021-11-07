package member.signin.dao;

import java.sql.SQLException;

import common.vo.MemberVO;

public interface ISignInDao {
	public MemberVO retrieveMemberCount(MemberVO memberVO) throws SQLException;
}
