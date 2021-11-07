package admin.audience.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.CodeVO;

public class AudienceDaoImpl extends BaseDao implements IAudienceDao {

	private static IAudienceDao instance;
	
	private AudienceDaoImpl() {

	}
	
	public static IAudienceDao getInstance() {
		if(instance == null) {
			instance = new AudienceDaoImpl();
		}
		
		return instance;
	}

	//관람객 리스트 전체 조회
	@Override
	public List<CodeVO> retrieveAudienceList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("audience.retrieveAudienceList");
	}

	//관람객 유형 전체 개수
	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("audience.getTotalCnt");
		
		return cnt;
	}

	//코드 존재 여부 확인
	@Override
	public CodeVO retrieveAudience(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return (CodeVO)smc.queryForObject("audience.retrieveAudience", codeVO);
	}

	//코드 최대값
	@Override
	public int retrieveMaxAudienceCode(SqlMapClient smc) throws SQLException {
		if((Integer)smc.queryForObject("audience.retrieveMaxAudienceCode") == null) {
			return 1;
		}
		return (int)smc.queryForObject("audience.retrieveMaxAudienceCode");
	}

	//등록
	@Override
	public int createAudience(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		if(smc.insert("audience.createAudience", codeVO) == null) {
			return 1;
		}
		return 0;
	}

	//수정
	@Override
	public int modifyAudience(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return smc.update("audience.modifyAudience", codeVO);
	}

	//삭제
	@Override
	public int deleteAudience(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return smc.update("audience.deleteAudience", codeVO);
	}


}
