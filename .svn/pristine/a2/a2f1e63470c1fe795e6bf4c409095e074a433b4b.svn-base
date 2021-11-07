package member.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import common.handler.CommandHandler;
import common.vo.PostVO;
import member.board.service.BoardServiceImpl;
import member.board.service.IBoardService;
import member.signup.handler.SignUpHandler;

/**
 * 문의사항 게시판 글 등록을 위한 핸들러
 * @author 이정범
 *
 */
public class InsertQuestionsBoardHandler implements CommandHandler{

	private static final Logger LOGGER = Logger.getLogger(SignUpHandler.class);
	
	private String VIEW_PAGE = "/jsp/member/board/InsertQuestionsBoard.jsp";
	
	private IBoardService ibs = BoardServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if( req.getParameter("flag") == null ) {
			return VIEW_PAGE;
		}else if( "Check".equals(req.getParameter("flag")) ) {
			PostVO pv = new PostVO();
			
//			req.getParameter("postCd");
//			req.getParameter("postTitle");
//			req.getParameter("postContent");
//			req.getParameter("boardCd");
			
			BeanUtils.populate(pv, req.getParameterMap());		
			
			int cnt = ibs.insertNotice(pv);
			
			if(cnt > 0) {
				LOGGER.debug("문의사항 등록 성공!!!");
			}else{
				LOGGER.debug("문의사항 등록 실패...");
			}
			
			req.setAttribute("result", cnt);
			VIEW_PAGE = "/jsp/common/resultJson.jsp";
			
		}		
		
		return VIEW_PAGE;
	}

}














