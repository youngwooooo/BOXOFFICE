package admin.charge.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.CdChargeVO;
import common.vo.CodeVO;
import common.vo.PagingVO;

public class ChargeDaoImpl extends BaseDao implements IChargeDao {

	private static IChargeDao instance;
	
	private ChargeDaoImpl() {

	}
	
	public static IChargeDao getInstance() {
		if(instance == null) {
			instance = new ChargeDaoImpl();
		}
		
		return instance;
	}

	//요금 리스트
	@Override
	public List<CdChargeVO> retrieveChargeList(SqlMapClient smc, PagingVO pagingVO) throws SQLException {
		return smc.queryForList("charge.retrieveChargeList", pagingVO);
	}

	//요금 테이블 전체 행 개수
	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("charge.getTotalCnt");
		
		return cnt;
	}

	//코드 존재 여부 확인
	@Override
	public CdChargeVO retrieveCharge(SqlMapClient smc, CdChargeVO cdChargeVO) throws SQLException {
		return (CdChargeVO)smc.queryForObject("charge.retrieveCharge", cdChargeVO);
	}

	//코드 최대값
	@Override
	public String retrieveMaxChargeCode(SqlMapClient smc) throws SQLException {
		if((String)smc.queryForObject("charge.retrieveMaxChargeCode") == null) {
			return "1";
		}
		return (String)smc.queryForObject("charge.retrieveMaxChargeCode");
	}

	//등록
	@Override
	public int createCharge(SqlMapClient smc, CdChargeVO cdChargeVO) throws SQLException {
		if(smc.insert("charge.createCharge", cdChargeVO) == null) {
			return 1;
		}
		return 0;
	}

	//수정
	@Override
	public int modifyCharge(SqlMapClient smc, CdChargeVO cdChargeVO) throws SQLException {
		return smc.update("charge.modifyCharge", cdChargeVO);
	}

	//삭제
	@Override
	public int deleteCharge(SqlMapClient smc, CdChargeVO cdChargeVO) throws SQLException {
		return smc.update("charge.deleteCharge", cdChargeVO);
	}


}
