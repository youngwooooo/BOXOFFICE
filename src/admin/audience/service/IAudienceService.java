package admin.audience.service;

import java.sql.SQLException;
import java.util.List;

import common.vo.CodeVO;

public interface IAudienceService {
	
	/**
	 * 전체 관람객 유형 목록을 조회하기 위한 메서드 
	 * @return 전체 관람객 유형 목록
	 */
	public List<CodeVO> retrieveAudienceList();
	
	/**
	 * 전체 관람객 유형 수를 알아내는 메서드
	 * @return		전체 관람객 유형 수 
	 */
	public int getTotalCnt();
	
	/**
	 * 관람객 유형 코드 정보 등록
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int createAudience(CodeVO codeVO);
	
	/**
	 * 관람객 유형 코드 정보 수정
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyAudience(CodeVO codeVO);
	
	/**
	 * 관람객 유형 코드 정보 삭제
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteAudience(CodeVO codeVO);
	
			
}
