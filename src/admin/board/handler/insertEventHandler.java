package admin.board.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import admin.board.service.BoardServiceImpl;
import admin.board.service.IBoardService;
import common.filter.FileUploadRequestWrapper;
import common.handler.CommandHandler;
import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import common.vo.PostVO;

public class insertEventHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/jsp/admin/board/eventInsert.jsp";
	private static final Logger LOGGER = Logger.getLogger(insertEventHandler.class);
	
	private IBoardService eventService = BoardServiceImpl.getInstance();
	private IAtchFileService fileService = AtchFileServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false; // forward
			
		}else if(req.getMethod().equals("POST")) {
			return true; // redirect
		}
		
		return false; //디폴트
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
			
		}else if(req.getMethod().equals("POST")) {
			
			AtchFileVO atchFileVO = new AtchFileVO();
			
			if(FileUploadRequestWrapper.hasWrapper(req)) {
				//멀티파트라면 Map 들고오기
				Map<String, Object> fileItemMap = ((FileUploadRequestWrapper)req).getFileItemMap();
				
				//파싱된 데이터를 담은 Map을 갖고 왔으면
				
				LOGGER.info("파일 아이템 사이즈 : " + fileItemMap.size());
				
				if(fileItemMap.size() > 0) { // 파일이 존재하면...
					atchFileVO = fileService.saveAtchFileList(fileItemMap);
				}
				
			}	
			
			String postCd = req.getParameter("postCd");
			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			String boardCd = req.getParameter("boardCd");
//			String postDate = req.getParameter("postDate");
			
			System.out.println("파라미터 ==>" + postCd + " " + postTitle + " " + postContent + " " + boardCd);
			
			PostVO pv = new PostVO();
			pv.setPostCd(postCd);
			pv.setPostTitle(postTitle);
			pv.setPostContent(postContent);
			pv.setBoardCd(boardCd);
//			pv.setAtchFileCd(atchFileVO.getAtchFileCd()); // 첨부파일 ID 저장
			
//			int cnt = noticeService.insertNotice(pv);
			int cnt = eventService.insertEvent(pv);
						
			String redirectURL = req.getContextPath()
					+ "/admin/mainBoard2.do";
			
			return redirectURL;
		}
		
		return null;
		
	}

}
