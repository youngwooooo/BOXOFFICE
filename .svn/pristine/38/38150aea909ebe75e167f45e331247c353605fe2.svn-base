package admin.product.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import admin.product.service.IProductService;
import admin.product.service.ProductServiceImpl;
import common.handler.CommandHandler;
import common.vo.ProductTypeVO;
import common.vo.ProductVO;

public class ProductListHandler implements CommandHandler {
	
	private static final Logger LOGGER = Logger.getLogger(ProductListHandler.class);
	private static final String VIEW_PAGE = "/jsp/admin/product/productList3.jsp";

	private IProductService productService = ProductServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		
		List<ProductVO> productList = productService.retrieveProductList();
		
		req.setAttribute("productList", productList);
		
		
		return VIEW_PAGE;
	}
	
}
