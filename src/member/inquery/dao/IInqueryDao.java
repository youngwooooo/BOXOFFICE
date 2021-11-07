package member.inquery.dao;

import java.sql.SQLException;

import common.vo.MemberVO;

public interface IInqueryDao {
	public int retrieveMemberForPassword(MemberVO memberVO) throws SQLException;
	
	public int modifyPassword(MemberVO memberVO) throws SQLException;
}
