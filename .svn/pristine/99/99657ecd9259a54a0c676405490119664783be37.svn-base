package member.inquery.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.MemberVO;

public class InqueryDaoImpl extends BaseDao implements IInqueryDao {

	private SqlMapClient smc;
	private static IInqueryDao instance;
	
	private InqueryDaoImpl() {
		smc = super.getSqlMapClient();
	}
	
	public static IInqueryDao getInstance() {
		if(instance == null) {
			instance = new InqueryDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public int retrieveMemberForPassword(MemberVO memberVO) throws SQLException {
		return (Integer)smc.queryForObject("inquery.retrieveMemberForPassword", memberVO);
	}

	@Override
	public int modifyPassword(MemberVO memberVO) throws SQLException {
		return smc.update("inquery.modifyPassword", memberVO);
	}

}
