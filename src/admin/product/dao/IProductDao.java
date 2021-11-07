package admin.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.ProductTypeVO;
import common.vo.ProductVO;

public interface IProductDao {

	/**
	 * 전체 상품(간식) 목록을 조회하기 위한 메서드 
	 * @param smc SqlMapClient 객체
	 * @return ProductVO 객체를 담고 있는 List객체 
	 * @throws SQLException	JDBC관련 예외객체
	 */
	public List<ProductVO> retrieveProductList(SqlMapClient smc) throws SQLException;
	
	/**
	 * 상품(간식) 정보가 존재하는지 조회
	 * @param smc, productVO
	 * @return
	 * @throws SQLException
	 */
	public ProductVO retrieveProduct(SqlMapClient smc, ProductVO productVO) throws SQLException;
	
	/**
	 * 상품(간식) 정보 등록
	 * @param smc, productVO
	 * @return
	 * @throws SQLException
	 */
	public int createProduct(SqlMapClient smc, ProductVO productVO) throws SQLException;
	
	/**
	 * 상품(간식) 정보 수정
	 * @param smc, productVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyProduct(SqlMapClient smc, ProductVO productVO) throws SQLException;
	
	/**
	 * 상품(간식) 정보 삭제
	 * @param smc, productVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteProduct(SqlMapClient smc, ProductVO productVO) throws SQLException;
	
	public List<ProductTypeVO> productTypeList(SqlMapClient smc) throws SQLException;
		
}
