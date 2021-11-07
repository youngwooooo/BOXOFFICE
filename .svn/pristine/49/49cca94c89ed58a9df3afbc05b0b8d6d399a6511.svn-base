package admin.seat.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.CodeVO;

public class SeatDaoImpl extends BaseDao implements ISeatDao {

	private static ISeatDao instance;
	
	private SeatDaoImpl() {

	}
	
	public static ISeatDao getInstance() {
		if(instance == null) {
			instance = new SeatDaoImpl();
		}
		
		return instance;
	}

	//좌석 리스트 전체 조회
	@Override
	public List<CodeVO> retrieveSeatList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("seat.retrieveSeatList");
	}

	//좌석 유형 전체 개수
	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("seat.getTotalCnt");
		
		return cnt;
	}

	//코드 존재 여부 확인
	@Override
	public CodeVO retrieveSeat(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return (CodeVO)smc.queryForObject("seat.retrieveSeat", codeVO);
	}

	//코드 최대값
	@Override
	public int retrieveMaxSeatCode(SqlMapClient smc) throws SQLException {
		if((Integer)smc.queryForObject("seat.retrieveMaxSeatCode") == null) {
			return 1;
		}
		return (int)smc.queryForObject("seat.retrieveMaxSeatCode");
	}

	//등록
	@Override
	public int createSeat(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		if(smc.insert("seat.createSeat", codeVO) == null) {
			return 1;
		}
		return 0;
	}

	//수정
	@Override
	public int modifySeat(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return smc.update("seat.modifySeat", codeVO);
	}

	//삭제
	@Override
	public int deleteSeat(SqlMapClient smc, CodeVO codeVO) throws SQLException {
		return smc.update("seat.deleteSeat", codeVO);
	}


}
