package admin.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.CodeVO;
import common.vo.DetailMemberVO;
import common.vo.MemberVO;
import common.vo.PagingVO;


/**
	실제 DB와 연결해서 SQL문을 수행한 결과를 작성하여 Service에 전달하는 DAO의 Interface
 */
public interface IMemberDao {
	
	/**
	 * DB의 MYMEMBER테이블 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @param smc - SqlMapClient 객체
	 * @param pagingVO - 페이지 정보를 담고있는 객체
	 * @return MemberVO객체를 담고 있는 List객체
	 * @throws SQLException - JDBC관련 예외 객체
	 */
	public List<MemberVO> getAllMemberList(SqlMapClient smc, PagingVO pagingVO) throws SQLException;	
	
	/**
	 * 주어진 회원ID에 해당하는 회원정보를 조회하는 메서드
	 * @param smc - SqlMapClient 객체
	 * @param memId - 검색할 회원ID
	 * @return 검색된 회원정보를 담은 MemberVO객체
	 * @throws SQLException - JDBC관련 예외 객체
	 */
	public List<DetailMemberVO> getMember(SqlMapClient smc, String memId) throws SQLException;
	
	/**
	 * 전체 회원 수를 알아내는 메서드
	 * @param smc - SqlMapClient 객체
	 * @return 전체 회원 수 
	 * @throws SQLException
	 */
	public int getTotalCnt(SqlMapClient smc) throws SQLException;
	
	/**
	 * 회원정보를 검색하기 위한 메서드
	 * @param smc - SqlMapClient 객체
	 * @param mv - 검색할 회원 정보
	 * @return - 검색된 회원정보를 담은 List객체
	 * @throws SQLException - JDBC관련 예외 객체
	 */
	public List<MemberVO> getSearchMember(SqlMapClient smc, MemberVO mv) throws SQLException;

	
	
	
}
