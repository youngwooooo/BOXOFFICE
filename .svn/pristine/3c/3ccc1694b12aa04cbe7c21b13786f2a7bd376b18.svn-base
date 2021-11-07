package admin.product.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import admin.product.service.IProductService;
import admin.product.service.ProductServiceImpl;
import common.filter.FileUploadRequestWrapper;
import common.handler.CommandHandler;
import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import common.vo.ProductTypeVO;
import common.vo.ProductVO;

public class ProductInsertHandler implements CommandHandler {
	
	private static final Logger LOGGER = Logger.getLogger(ProductListHandler.class);
	private static final String VIEW_PAGE = "/TicketingProject/jsp/admin/product/productInsert.jsp";
	
	private IProductService productService = ProductServiceImpl.getInstance();
	private IAtchFileService fileService = AtchFileServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		if(req.getMethod().equalsIgnoreCase("get")) {
//			List<ProductTypeVO> productTypeList = productService.productTypeList();
//			req.setAttribute("productTypeList", productTypeList);
//			System.out.println("좀들어와라 = " + productTypeList.get(0).getProdTypeCd());
//			return VIEW_PAGE;
//			
//		}else if(req.getMethod().equalsIgnoreCase("post")){
			AtchFileVO atchFileVO = new AtchFileVO();
			
			// 멀티파트 처리된 래퍼객체가 맞는지 확인
			if(FileUploadRequestWrapper.hasWrapper(req)) {
				// 정보가 담겨있는 맵 객체 생성
				Map<String, Object> fileItemMap = ((FileUploadRequestWrapper)req).getFileItemMap();
				LOGGER.info("파일아이템 사이즈 : " + fileItemMap.size());
				
				if(fileItemMap.size() > 0) {  // 파일이 존재하면~
					atchFileVO = fileService.saveAtchFileList(fileItemMap);
				}
			}
			
			String prodTypeCd = req.getParameter("prodTypeCd");
			String prodCd = req.getParameter("prodCd");
			String prodName = req.getParameter("prodName");
			String prodPrice = req.getParameter("prodPrice");
			String prodDesc =  req.getParameter("prodDesc");
			
			ProductVO pdVO = new ProductVO();
			pdVO.setProdTypeCd(prodTypeCd);
			pdVO.setProdCd(prodCd);
			pdVO.setProdName(prodName);
			pdVO.setProdPrice(prodPrice);
			pdVO.setProdDesc(prodDesc);
			pdVO.setAtchFileCd(atchFileVO.getAtchFileCd());  // 첨부파일 ID 저장ㄴ
			
			
			// 3. 회원등록
			int cnt = productService.createProduct(pdVO);
			
			// 4. 목록 조회화면으로 이동
			//req.getRequestDispatcher("/member/list").forward(req, resp);
			String redirectURL = req.getContextPath() + "/admin/product.do";
			return redirectURL;
			
//		}
//		return null;
	}
}
