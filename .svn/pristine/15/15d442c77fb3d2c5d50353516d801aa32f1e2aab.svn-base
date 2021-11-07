package member.mypage.memberInfo.service;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.MemberVO;
import member.mypage.memberInfo.dao.IMemberInfoDao;
import member.mypage.memberInfo.dao.MemberInfoDaoImpl;

public class MemberInfoServiceImpl extends BaseDao implements IMemberInfoService{
	private static IMemberInfoDao imd;
	private static IMemberInfoService ims;
	
	private static SqlMapClient smc;
	
	public MemberInfoServiceImpl() {
		imd = MemberInfoDaoImpl.getInstance();
		smc = super.getSqlMapClient();
	}
	
	public static IMemberInfoService getInstance() {
		
		if(ims == null) {
			ims = new MemberInfoServiceImpl();
		}
		
		return ims;
	}
	
	@Override
	public MemberVO retrieveMember(String memId) throws SQLException {
		return imd.retrieveMember(memId);
	}
	@Override
	public MemberVO retrieveMemberByMemPass(String memPass) throws SQLException {
		
		return imd.retrieveMemberByMemPass(memPass);
	}

	@Override
	public int updateMemberInfo(MemberVO mv) throws SQLException {
		
		int cnt = 0;
		
		try {
			cnt = imd.updateMemberInfo(mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteMemberInfo(String memId) throws SQLException {
		
		int cnt = 0;
		
		try {
			cnt = imd.deleteMemberInfo(memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
