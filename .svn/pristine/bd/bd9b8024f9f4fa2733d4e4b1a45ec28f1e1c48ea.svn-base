package member.signin.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.MemberVO;

public class SignInDaoImpl extends BaseDao implements ISignInDao {

	private SqlMapClient smc;
	private static ISignInDao instance;
	
	private SignInDaoImpl() {
		smc = super.getSqlMapClient();
	}
	
	public static ISignInDao getInstance() {
		if(instance == null) {
			instance = new SignInDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public MemberVO retrieveMemberCount(MemberVO memberVO) throws SQLException {
		return (MemberVO)smc.queryForObject("signin.retrieveMemberCount", memberVO);
	}

}
