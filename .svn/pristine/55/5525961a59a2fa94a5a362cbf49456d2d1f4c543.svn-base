package admin.seat.service;

import java.sql.SQLException;
import java.util.List;

import common.vo.CodeVO;

public interface ISeatService {
	
	/**
	 * 전체 좌석 유형 목록을 조회하기 위한 메서드 
	 * @return 전체 좌석 유형 목록
	 */
	public List<CodeVO> retrieveSeatList();
	
	/**
	 * 전체 좌석 유형 수를 알아내는 메서드
	 * @return		전체 좌석 유형 수 
	 */
	public int getTotalCnt();
	
	/**
	 * 좌석 유형 코드 정보 등록
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int createSeat(CodeVO codeVO);
	
	/**
	 * 좌석 유형 코드 정보 수정
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int modifySeat(CodeVO codeVO);
	
	/**
	 * 좌석 유형 코드 정보 삭제
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteSeat(CodeVO codeVO);
	
			
}
