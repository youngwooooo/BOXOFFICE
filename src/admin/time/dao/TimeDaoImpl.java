package admin.time.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.CodeVO;

public class TimeDaoImpl extends BaseDao implements ITimeDao {

	private static ITimeDao instance;
	
	private TimeDaoImpl() {

	}
	
	public static ITimeDao getInstance() {
		if(instance == null) {
			instance = new TimeDaoImpl();
		}
		
		return instance;
	}

	//시간대 리스트 전체 조회
	@Override
	public List<CodeVO> retrieveTimeList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("time.retrieveTimeList");
	}

	//시간대 유형 전체 개수
	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("time.getTotalCnt");
		
		return cnt;
	}

	//코드 존재 여부 확인
	@Override
	public CodeVO retrieveTime(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return (CodeVO)smc.queryForObject("time.retrieveTime", codeVO);
	}

	//코드 최대값
	@Override
	public int retrieveMaxTimeCode(SqlMapClient smc) throws SQLException {
		if((Integer)smc.queryForObject("time.retrieveMaxTimeCode") == null) {
			return 1;
		}
		return (int)smc.queryForObject("time.retrieveMaxTimeCode");
	}

	//등록
	@Override
	public int createTime(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		if(smc.insert("time.createTime", codeVO) == null) {
			return 1;
		}
		return 0;
	}

	//수정
	@Override
	public int modifyTime(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return smc.update("time.modifyTime", codeVO);
	}

	//삭제
	@Override
	public int deleteTime(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return smc.update("time.deleteTime", codeVO);
	}


}
