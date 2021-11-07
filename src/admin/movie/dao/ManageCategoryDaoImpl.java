package admin.movie.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.CodeVO;
import common.vo.PagingVO;

/**
 * 카테고리 DAO 실제 구현 
 * @author 작성자: 정범
 *
 */
public class ManageCategoryDaoImpl extends BaseDao implements IManageCategoryDao{
	/*==============싱글톤 패톤 선언==============*/
	private SqlMapClient smc;
	private static IManageCategoryDao imcd;
	
	public ManageCategoryDaoImpl() {		
		smc = super.getSqlMapClient();
	}
	
	public static IManageCategoryDao getInstance() {
		if(imcd == null) {
			imcd = new ManageCategoryDaoImpl();
		}
		
		return imcd;
	}
	/*=======================================*/

	@Override
	public List<CodeVO> getAllGenreList(SqlMapClient smc, PagingVO pagingVO) throws SQLException {	
		
		List<CodeVO> genreList = smc.queryForList("genre.getAllGenreList", pagingVO);
		
		return genreList;
	}

	@Override
	public int insertGenreObj(CodeVO cv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("genre.insertGenreObject", cv);
		
		if(obj == null) {
			cnt = 1;
		}		
		
		return cnt;
	}

	@Override
	public int updateGenreObject(CodeVO cv) throws SQLException {		
		
		int cnt = smc.update("genre.updateGenreObject", cv);
		
		return cnt;
	}

	@Override
	public int deleteGenreObject(CodeVO cv) throws SQLException {
		
		int cnt = smc.delete("genre.deleteGenreObject", cv);
		
		return 0;
	}

	@Override
	public int getTotalCnt(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("genre.getTotalCnt");
		return cnt;
	}
	
		
}
