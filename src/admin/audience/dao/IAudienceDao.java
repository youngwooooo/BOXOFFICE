package admin.audience.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.CodeVO;

public interface IAudienceDao {

	/**
	 * 전체 관람객 유형 목록을 조회하기 위한 메서드 
	 * @param smc SqlMapClient 객체
	 * @return CodeVO 객체를 담고 있는 List객체 
	 * @throws SQLException	JDBC관련 예외객체
	 */
	public List<CodeVO> retrieveAudienceList(SqlMapClient smc) throws SQLException;
	
	/**
	 * 관람객의 전체 유형 수를 알아내는 메서드
	 * @param smc SqlMapClient 객체
	 * @return 전체 관람객 수 
	 * @throws SQLException	JDBC관련 예외 객체
	 */
	public int getTotalCnt(SqlMapClient smc) throws SQLException;
	
	/**
	 * 관람객 유형 정보가 존재하는지 조회
	 * @param smc, codeVO
	 * @return
	 * @throws SQLException
	 */
	public CodeVO retrieveAudience(SqlMapClient smc, CodeVO codeVO) throws SQLException;
		
	/**
	 * 관람객 유형 코드 최댓값 조회
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public int retrieveMaxAudienceCode(SqlMapClient smc) throws SQLException;
	
	/**
	 * 관람객 유형 정보 등록
	 * @param smc, codeVO
	 * @return
	 * @throws SQLException
	 */
	public int createAudience(SqlMapClient smc, CodeVO codeVO) throws SQLException;
	
	/**
	 * 관람객 유형 정보 수정
	 * @param smc, codeVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyAudience(SqlMapClient smc, CodeVO codeVO) throws SQLException;
	
	/**
	 * 관람객 유형 정보 삭제
	 * @param smc, codeVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteAudience(SqlMapClient smc, CodeVO codeVO) throws SQLException;
		
}
