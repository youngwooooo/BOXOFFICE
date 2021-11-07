package member.mypage.memberInfo.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.MemberVO;

public class MemberInfoDaoImpl extends BaseDao implements IMemberInfoDao{

	private SqlMapClient smc;
	private static IMemberInfoDao imd;
	
	public MemberInfoDaoImpl() {
		smc = super.getSqlMapClient();
	}
	
	public static IMemberInfoDao getInstance() {		
		if(imd == null) {
			imd = new MemberInfoDaoImpl();
		}
		
		return imd;
	}
	
	
	@Override
	public MemberVO retrieveMember(String memId) throws SQLException {
		
		return (MemberVO) smc.queryForObject("memberInfo.retrieveMember", memId);
	}
	
	@Override
	public MemberVO retrieveMemberByMemPass(String memPass) throws SQLException {
		
		return (MemberVO) smc.queryForObject("memberInfo.retrieveMemberByMemPass", memPass);
	}

	@Override
	public int updateMemberInfo(MemberVO mv) throws SQLException {
		
		int cnt = smc.update("memberInfo.updateMemInfo", mv);
		
		return cnt;
	}

	@Override
	public int deleteMemberInfo(String memId) throws SQLException {
		
		int cnt = smc.delete("memberInfo.deleteMemInfo", memId);
		
		return cnt;
	}

}
