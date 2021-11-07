package admin.time.service;

import java.sql.SQLException;
import java.util.List;

import common.vo.CodeVO;

public interface ITimeService {
	
	/**
	 * 전체 시간대 유형 목록을 조회하기 위한 메서드 
	 * @return 전체 시간대 유형 목록
	 */
	public List<CodeVO> retrieveTimeList();
	
	/**
	 * 전체 시간대 유형 수를 알아내는 메서드
	 * @return		전체 시간대 유형 수 
	 */
	public int getTotalCnt();
	
	/**
	 * 시간대 유형 코드 정보 등록
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int createTime(CodeVO codeVO);
	
	/**
	 * 시간대 유형 코드 정보 수정
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyTime(CodeVO codeVO);
	
	/**
	 * 시간대 유형 코드 정보 삭제
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteTime(CodeVO codeVO);
	
			
}
