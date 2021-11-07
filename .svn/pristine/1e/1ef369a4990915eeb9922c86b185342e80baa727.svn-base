package admin.cinema.dao;

import java.sql.SQLException;
import java.util.List;

import common.vo.CodeVO;

public interface IScreenDao {
	/**
	 * 스크린 유형 코드 정보 리스트 조회
	 * @return
	 * @throws SQLException
	 */
	public List<CodeVO> retrieveScreenList() throws SQLException;
	
	/**
	 * 스크린 유형 코드 정보가 존재하는지 조회
	 * @param codeVO
	 * @return
	 * @throws SQLException
	 */
	public CodeVO retrieveScreen(CodeVO codeVO) throws SQLException;
	
	/**
	 * 스크린 유형 코드 최댓값 조회
	 * @return
	 * @throws SQLException
	 */
	public int retrieveMaxScreenCode() throws SQLException;
	
	/**
	 * 스크린 유형 코드 정보 등록
	 * @param screenVO
	 * @return
	 * @throws SQLException
	 */
	public int createScreen(CodeVO codeVO) throws SQLException;
	
	/**
	 * 스크린 유형 코드 정보 수정
	 * @param screenVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyScreen(CodeVO codeVO) throws SQLException;
	
	/**
	 * 스크린 유형 코드 정보 삭제
	 * @param screenVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteScreen(CodeVO codeVO) throws SQLException;
}
