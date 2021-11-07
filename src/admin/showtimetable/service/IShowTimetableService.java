package admin.showtimetable.service;

import java.sql.SQLException;
import java.util.List;

import common.vo.ShowTimetableVO;

public interface IShowTimetableService {
	
	/**
	 * 상영시간표 테이블 전체를 조회하기 위한 메서드  
	 * @return 전체 상영시간표 목록
	 */
	public List<ShowTimetableVO> retrieveShowTimetableList(ShowTimetableVO showVO);
	
	/**
	 * 상영시간표의 전체 행 수를 알아내는 메서드
	 * @return 전체 상영시간표 수 
	 */
	public int getTotalCnt();
	
	/**
	 * 상영시간표 정보 등록
	 * @param ShowTimetableVO
	 * @return
	 * @throws SQLException
	 */
	public int createShowTimetable(ShowTimetableVO showTimetableVO);
	
	/**
	 * 상영시간표 정보 수정
	 * @param ShowTimetableVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyShowTimetable(ShowTimetableVO showTimetableVO);
	
	/**
	 * 상영시간표 정보 삭제
	 * @param ShowTimetableVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteShowTimetable(ShowTimetableVO showTimetableVO);
	
			
}
