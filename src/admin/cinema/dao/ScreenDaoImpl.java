package admin.cinema.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.CodeVO;

public class ScreenDaoImpl extends BaseDao implements IScreenDao {
	
	private SqlMapClient smc;
	private static IScreenDao instance;
	
	private ScreenDaoImpl() {
		smc = super.getSqlMapClient();
	}
	
	public static IScreenDao getInstance() {
		if(instance == null) {
			instance = new ScreenDaoImpl();
		}
		
		return instance;
	}

	@Override
	public List<CodeVO> retrieveScreenList() throws SQLException {
		return smc.queryForList("screen.retrieveScreenList");
	}
	
	@Override
	public CodeVO retrieveScreen(CodeVO codeVO) throws SQLException {
		return (CodeVO)smc.queryForObject("screen.retrieveScreen", codeVO);
	}

	@Override
	public int retrieveMaxScreenCode() throws SQLException {
		if((Integer)smc.queryForObject("screen.retrieveMaxScreenCode") == null) {
			return 1;
		}
		return (int)smc.queryForObject("screen.retrieveMaxScreenCode");
	}
	
	@Override
	public int createScreen(CodeVO codeVO) throws SQLException {
		if(smc.insert("screen.createScreen", codeVO) == null) {
			return 1;
		}
		return 0;
	}

	@Override
	public int modifyScreen(CodeVO codeVO) throws SQLException {
		return smc.update("screen.modifyScreen", codeVO);
	}

	@Override
	public int deleteScreen(CodeVO codeVO) throws SQLException {
		return smc.delete("screen.deleteScreen", codeVO);
	}


}
