package admin.time.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.CodeVO;

public interface ITimeDao {

	/**
	 * 전체 시간대 유형 목록을 조회하기 위한 메서드 
	 * @param smc SqlMapClient 객체
	 * @return CodeVO 객체를 담고 있는 List객체 
	 * @throws SQLException	JDBC관련 예외객체
	 */
	public List<CodeVO> retrieveTimeList(SqlMapClient smc) throws SQLException;
	
	/**
	 * 시간대의 전체 유형 수를 알아내는 메서드
	 * @param smc SqlMapClient 객체
	 * @return 전체 시간대 수 
	 * @throws SQLException	JDBC관련 예외 객체
	 */
	public int getTotalCnt(SqlMapClient smc) throws SQLException;
	
	/**
	 * 시간대 유형 정보가 존재하는지 조회
	 * @param smc, codeVO
	 * @return
	 * @throws SQLException
	 */
	public CodeVO retrieveTime(SqlMapClient smc, CodeVO codeVO) throws SQLException;
		
	/**
	 * 시간대 유형 코드 최댓값 조회
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public int retrieveMaxTimeCode(SqlMapClient smc) throws SQLException;
	
	/**
	 * 시간대 유형 정보 등록
	 * @param smc, codeVO
	 * @return
	 * @throws SQLException
	 */
	public int createTime(SqlMapClient smc, CodeVO codeVO) throws SQLException;
	
	/**
	 * 시간대 유형 정보 수정
	 * @param smc, codeVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyTime(SqlMapClient smc, CodeVO codeVO) throws SQLException;
	
	/**
	 * 시간대 유형 정보 삭제
	 * @param smc, codeVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteTime(SqlMapClient smc, CodeVO codeVO) throws SQLException;
		
}
