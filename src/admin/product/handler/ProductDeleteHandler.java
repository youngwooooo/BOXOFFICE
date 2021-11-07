package admin.product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product.service.IProductService;
import admin.product.service.ProductServiceImpl;
import common.handler.CommandHandler;
import common.vo.ProductVO;

public class ProductDeleteHandler implements CommandHandler {
	
	private IProductService productService = ProductServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String prodCd = req.getParameter("prodCd");
		ProductVO productVO = new ProductVO();
		productVO.setProdCd(prodCd);
		
		int cnt = productService.deleteProduct(productVO);
		
		String redirectURL = req.getContextPath() + "/admin/product.do";
		
		return redirectURL;
	}

}
