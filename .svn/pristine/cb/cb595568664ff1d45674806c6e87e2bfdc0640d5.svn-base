package admin.cinema.service;

import java.sql.SQLException;
import java.util.List;

import common.vo.CodeVO;

public interface IScreenService {
	/**
	 * 스크린 유형 코드 정보 조회
	 * @return
	 * @throws SQLException
	 */
	public List<CodeVO> retrieveScreenList();
	
	/**
	 * 스크린 유형 코드 정보 등록
	 * @param screenVO
	 * @return
	 * @throws SQLException
	 */
	public int createScreen(CodeVO codeVO);
	
	/**
	 * 스크린 유형 코드 정보 수정
	 * @param screenVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyScreen(CodeVO codeVO);
	
	/**
	 * 스크린 유형 코드 정보 삭제
	 * @param screenVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteScreen(CodeVO codeVO);
}
