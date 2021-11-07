package admin.charge.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.CdChargeVO;
import common.vo.PagingVO;

public interface IChargeDao {

	/**
	 * 요금 테이블 전체를 조회하기 위한 메서드 
	 * @param smc SqlMapClient 객체
	 * @param pagingVO 페이징 정보를 담고 있는 객체
	 * @return CdChargeVO 객체를 담고 있는 List객체 
	 * @throws SQLException	JDBC관련 예외객체
	 */
	public List<CdChargeVO> retrieveChargeList(SqlMapClient smc, PagingVO pagingVO) throws SQLException;
	
	/**
	 * 요금 테이블의 전체 행 수를 알아내는 메서드
	 * @param smc SqlMapClient 객체
	 * @return 전체 요금 수 
	 * @throws SQLException	JDBC관련 예외 객체
	 */
	public int getTotalCnt(SqlMapClient smc) throws SQLException;
	
	/**
	 * 요금 정보가 존재하는지 조회
	 * @param smc, cdChargeVO
	 * @return
	 * @throws SQLException
	 */
	public CdChargeVO retrieveCharge(SqlMapClient smc, CdChargeVO cdChargeVO) throws SQLException;
		
	/**
	 * 요금 코드 최댓값 조회
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public String retrieveMaxChargeCode(SqlMapClient smc) throws SQLException;
	
	/**
	 * 요금 정보 등록
	 * @param smc, cdChargeVO
	 * @return
	 * @throws SQLException
	 */
	public int createCharge(SqlMapClient smc, CdChargeVO cdChargeVO) throws SQLException;
	
	/**
	 * 요금 정보 수정
	 * @param smc, cdChargeVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyCharge(SqlMapClient smc, CdChargeVO cdChargeVO) throws SQLException;
	
	/**
	 * 요금 정보 삭제
	 * @param smc, cdChargeVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteCharge(SqlMapClient smc, CdChargeVO cdChargeVO) throws SQLException;
		
}
