package admin.movie.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.CodeVO;
import common.vo.PagingVO;

/**
 * 카테고리 DAO
 * @author 작성자: 정범
 *
 */

public interface IManageCategoryDao {
	// select 
	public List<CodeVO> getAllGenreList(SqlMapClient smc, PagingVO pagingVO) throws SQLException;
	
	// insert
	public int insertGenreObj(CodeVO cv) throws SQLException;
	
	// update
	public int updateGenreObject(CodeVO cv) throws SQLException;  
	
	// delete
	public int deleteGenreObject(CodeVO cv) throws SQLException;
	
	/**
	 * 영화 장르 전체 갯수를 알아내는 메서드
	 * @return 영화 장르 전체 갯수 
	 * @throws SQLException
	 */
	public int getTotalCnt(SqlMapClient smc) throws SQLException;
}
