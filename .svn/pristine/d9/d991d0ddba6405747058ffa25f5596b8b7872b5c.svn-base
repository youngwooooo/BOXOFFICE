package admin.showtimetable.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.ShowTimetableVO;

public interface IShowTimetableDao {
	/**
	 * 상영시간표 전체를 조회하기 위한 메서드 
	 * @param smc SqlMapClient 객체
	 * @return ShowTimetableVO 객체를 담고 있는 List객체 
	 * @throws SQLException	JDBC관련 예외객체
	 */
	public List<ShowTimetableVO> retrieveShowTimetableList(SqlMapClient smc, ShowTimetableVO showVO) throws SQLException;
	
	/**
	 * 상영시간표의 전체 행 수를 알아내는 메서드
	 * @param smc SqlMapClient 객체
	 * @return 전체 상영시간표 수 
	 * @throws SQLException	JDBC관련 예외 객체
	 */
	public int getTotalCnt(SqlMapClient smc) throws SQLException;
	
	/**
	 * 상영시간표 정보가 존재하는지 조회
	 * @param smc, showTimetableVO
	 * @return
	 * @throws SQLException
	 */
	public ShowTimetableVO retrieveShowTimetable(SqlMapClient smc, ShowTimetableVO showTimetableVO) throws SQLException;
		
	/**
	 * 상영시간표 코드 최댓값 조회
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public String retrieveMaxShowTimetableCode(SqlMapClient smc) throws SQLException;
	
	/**
	 * 상영시간표 정보 등록
	 * @param smc, showTimetableVO
	 * @return
	 * @throws SQLException
	 */
	public int createShowTimetable(SqlMapClient smc, ShowTimetableVO showTimetableVO) throws SQLException;
	
	/**
	 * 상영시간표 정보 수정
	 * @param smc, showTimetableVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyShowTimetable(SqlMapClient smc, ShowTimetableVO showTimetableVO) throws SQLException;
	
	/**
	 * 상영시간표 정보 삭제
	 * @param smc, showTimetableVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteShowTimetable(SqlMapClient smc, ShowTimetableVO showTimetableVO) throws SQLException;
		
}
