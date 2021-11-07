package admin.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.dao.BaseDao;
import common.vo.ProductTypeVO;
import common.vo.ProductVO;

public class ProductDaoImpl extends BaseDao implements IProductDao {

	private static IProductDao instance;
	
	private ProductDaoImpl() {

	}
	
	public static IProductDao getInstance() {
		if(instance == null) {
			instance = new ProductDaoImpl();
		}
		
		return instance;
	}

	//좌석 리스트 전체 조회
	@Override
	public List<ProductVO> retrieveProductList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("product.retrieveProductList");
	}

	

	//코드 존재 여부 확인
	@Override
	public ProductVO retrieveProduct(SqlMapClient smc, ProductVO productVO) throws SQLException {
		return (ProductVO)smc.queryForObject("product.retrieveProduct", productVO);
	}

	
	//등록
	@Override
	public int createProduct(SqlMapClient smc, ProductVO productVO) throws SQLException {
		if(smc.insert("product.createProduct", productVO) == null) {
			return 1;
		}
		return 0;
	}

	//수정
	@Override
	public int modifyProduct(SqlMapClient smc, ProductVO productVO) throws SQLException {
		return smc.update("product.modifyProduct", productVO);
	}

	//삭제
	@Override
	public int deleteProduct(SqlMapClient smc, ProductVO productVO) throws SQLException {
		return smc.update("product.deleteProduct", productVO);
	}

	@Override
	public List<ProductTypeVO> productTypeList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("product.productTypeList");
	}


}
