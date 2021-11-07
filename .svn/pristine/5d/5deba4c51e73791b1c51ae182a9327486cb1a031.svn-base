package admin.product.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.vo.ProductTypeVO;
import common.vo.ProductVO;

public interface IProductService {
	
	/**
	 * 전체 전체 상품(간식) 목록을 조회하기 위한 메서드 
	 * @return 전체 전체 상품(간식) 목록
	 */
	public List<ProductVO> retrieveProductList();
	
	
	/**
	 * 전체 상품(간식) 코드 정보 등록
	 * @param productVO
	 * @return
	 * @throws SQLException
	 */
	public int createProduct(ProductVO productVO);
	
	/**
	 * 전체 상품(간식) 코드 정보 수정
	 * @param productVO
	 * @return
	 * @throws SQLException
	 */
	public int modifyProduct(ProductVO productVO);
	
	/**
	 * 전체 상품(간식) 코드 정보 삭제
	 * @param productVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteProduct(ProductVO productVO);
	
	public List<ProductTypeVO> productTypeList() throws SQLException;		
}
