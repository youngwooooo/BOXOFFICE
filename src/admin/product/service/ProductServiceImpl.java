package admin.product.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.product.dao.ProductDaoImpl;
import admin.product.dao.IProductDao;
import common.vo.ProductTypeVO;
import common.vo.ProductVO;
import util.SqlMapClientFactory;

public class ProductServiceImpl implements IProductService {

	private IProductDao productDao;
	private static IProductService instance;
	private SqlMapClient smc;
	
	private ProductServiceImpl() {
		productDao = ProductDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IProductService getInstance() {
		if(instance == null) {
			instance = new ProductServiceImpl();
		}
		
		return instance;
	}

	@Override
	public List<ProductVO> retrieveProductList() {
		List<ProductVO> list = new ArrayList<>();
		
		try {
			list = productDao.retrieveProductList(smc);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public int createProduct(ProductVO productVO) {
		int cnt = 0;
		
		try {
			
			cnt = productDao.createProduct(smc, productVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int modifyProduct(ProductVO productVO) {
		int count = 0;
		
		try {
			count = productDao.modifyProduct(smc, productVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return count;
	}

	@Override
	public int deleteProduct(ProductVO productVO) {
		int count = 0;
		ProductVO checkCodeExist = null;
		
		try {
			checkCodeExist = productDao.retrieveProduct(smc, productVO);
			
			if(checkCodeExist != null) {
				count = productDao.deleteProduct(smc, productVO);
			} else {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	
	@Override
	public List<ProductTypeVO> productTypeList() throws SQLException {
		List<ProductTypeVO> list = new ArrayList<>();
		
		try {
			list = productDao.productTypeList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
