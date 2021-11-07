package member.category.handler;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import admin.movie.service.IMovieService;
import admin.movie.service.MovieServiceImpl;
import common.filter.FileUploadRequestWrapper;
import common.handler.CommandHandler;
import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import common.vo.MovieVO;

public class UpdateMovieHandler implements CommandHandler {
	
	private static final String VIEW_PAGE 
				= "/jsp/admin/movie/movieDetail.jsp";
	
	private static final Logger LOGGER = 
			Logger.getLogger(UpdateMovieHandler.class); 
	
	private IMovieService movieService =
			MovieServiceImpl.getInstance();
	
	private IAtchFileService fileService = AtchFileServiceImpl.getInstance();
	
	

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return false; // forward
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return true; // redirect
		}
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			if(req.getMethod().equalsIgnoreCase("GET")) {
			
			String mvCd = req.getParameter("mvCd");
			
			// 2. 회원정보 조회
			MovieVO movieVO = movieService.getMovie(mvCd);
			
			
			
			if(movieVO.getAtchFileCd() > 0) {
				AtchFileVO fileVO = new AtchFileVO();
				fileVO.setAtchFileCd(movieVO.getAtchFileCd());
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
				
			}
			// 3. request객체에 회원정보 저장
			req.setAttribute("movieVO", movieVO);
			
			return VIEW_PAGE;
		
			
			}else if(req.getMethod().equalsIgnoreCase("POST")) {
				
				
				/*//기존의 첨부파일 아이디 정보 가져오기 
				long atchFileCd = req.getParameter("atchFileCd") == null ? 
						-1 : Long.parseLong(req.getParameter("atchFileCd"));
				
				AtchFileVO atchFileVO = new AtchFileVO();
				atchFileVO.setAtchFileCd(atchFileCd);
		
				
				// 멀티파트 처리된 래퍼객체가 맞는지 확인..
				if(FileUploadRequestWrapper.hasWrapper(req)) {
					
					Map<String, Object> fileItemMap = 
							((FileUploadRequestWrapper)req).getFileItemMap();
					
					LOGGER.info("파일 아이템 사이즈 : " + fileItemMap.size());
					
					if(fileItemMap.size() > 0) { // 파일이 존재하면...
						atchFileVO = fileService.saveAtchFileList(fileItemMap);
					}
				}*/
				
				// 1. 요청파라미터 정보 가져오기
				 String mvCd = req.getParameter("mvCd");
				 String mvNameKor = req.getParameter("mvNameKor");
				 String mvNameEng  = req.getParameter("mvNameEng");
				 String mvRelDate  = req.getParameter("mvRelDate");
				 String mvRatingCd  = req.getParameter("mvRatingCd");
				 String mvRunningTime  = req.getParameter("mvRunningTime");
				 String director  = req.getParameter("director");
				 String actor  = req.getParameter("actor");
				 String showYn  = req.getParameter("showYn");
				 String mvPlot  = req.getParameter("mvPlot");
				 String dubbingYn  = req.getParameter("dubbingYn");
				 String mvCompany  = req.getParameter("mvCompany");
				 String mvCountry = req.getParameter("mvCountry");		 
				 String mvShowStartDate  = req.getParameter("mvShowStartDate");
				 String mvShowEndDate  = req.getParameter("mvShowEndDatev");
				
				 MovieVO mv = new MovieVO();
				 mv.setMvCd(mvCd);
				 mv.setMvNameKor(mvNameKor);
				 mv.setMvNameEng(mvNameEng);
				 mv.setMvRelDate(mvRelDate);
				 mv.setMvRelDate(mvRelDate);
				 mv.setMvRunningTime(mvRunningTime);
				 mv.setDirector(director);
				 mv.setActor(actor);
				 mv.setShowYn(showYn);
				 mv.setMvPlot(mvPlot);
				 mv.setDubbingYn(dubbingYn);
				 mv.setMvCompany(mvCompany);
				 mv.setMvCompany(mvCompany);
				 mv.setMvShowStartDate(mvShowStartDate);
				 mv.setMvShowEndDate(mvShowEndDate);
				// mv.setAtchFileCd(atchFileVO.getAtchFileCd());
				 
				 
		
				
				// 3. 회원정보 수정하기
				int cnt = movieService.updateMovie(mv);
				
				String msg = "";
				if( cnt > 0) {
					msg = "성공";
				}else {
					msg = "실패";
				}
				
				String redirectURL = req.getContextPath() 
						+ "/admin/movielist.do?msg=" + URLEncoder.encode(msg, "utf-8");
				
				return redirectURL;
			}
			
			return null;
		}
}
