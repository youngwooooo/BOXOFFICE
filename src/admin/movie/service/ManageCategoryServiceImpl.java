package admin.movie.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.movie.dao.IManageCategoryDao;
import admin.movie.dao.ManageCategoryDaoImpl;
import common.dao.BaseDao;
import common.vo.CodeVO;
import common.vo.PagingVO;
import util.SqlMapClientFactory;

/**
 * 
 * @author 작성자: 정범
 *
 */
public class ManageCategoryServiceImpl extends BaseDao implements IManageCategoryService{
	//비즈니스 로직 처리	
	private static IManageCategoryDao imcd; //Dao
	private static IManageCategoryService imcs; //Service
	
	private static SqlMapClient smc; 
	
	public ManageCategoryServiceImpl() {
		imcd = ManageCategoryDaoImpl.getInstance();
		smc = super.getSqlMapClient();
	}
	
	public static IManageCategoryService getInstance() {
		
		if(imcs == null) {
			imcs = new ManageCategoryServiceImpl();
		}
		
		return imcs;		
	}
	
	
	@Override
	public List<CodeVO> getAllGenreList(PagingVO pagingVO) {
		
		List<CodeVO> genreList = new ArrayList<CodeVO>();
		
		try {
			genreList = imcd.getAllGenreList(smc, pagingVO);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return genreList;
	}

	@Override
	public int getTotalCnt() {
		int cnt = 0;
		
		try {
			cnt = imcd.getTotalCnt(smc);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}
	
}
