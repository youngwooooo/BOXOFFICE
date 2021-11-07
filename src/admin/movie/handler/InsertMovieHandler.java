package admin.movie.handler;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import admin.movie.service.IMovieService;
import admin.movie.service.MovieServiceImpl;
import common.filter.FileUploadRequestWrapper;
import common.handler.CommandHandler;
import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import common.vo.AtchMovieVO;
import common.vo.CodeVO;
import common.vo.MovieVO;

public class InsertMovieHandler implements CommandHandler {

	private static final Logger LOGGER = Logger.getLogger(InsertMovieHandler.class);

	private static final String VIEW_PAGE = "/jsp/admin/movie/movieregister.jsp";

	private IMovieService movieService = MovieServiceImpl.getInstance();

	private IAtchFileService fileService = AtchFileServiceImpl.getInstance();

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if (req.getMethod().equals("GET")) {
			return false;
		} else if (req.getMethod().equals("POST")) {
			return true;
		}

		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		
		
		if (req.getMethod().equals("GET")) {
			List<CodeVO> genreName = movieService.getAllGenreList();
			req.setAttribute("genreName", genreName);
			
			return VIEW_PAGE;
		} else if (req.getMethod().equals("POST")) {

			AtchFileVO atchFileVO = new AtchFileVO();

			// 멀티파트 처리된 래퍼객체가 맞는지 확인..
			if (FileUploadRequestWrapper.hasWrapper(req)) {

				Map<String, Object> fileItemMap = ((FileUploadRequestWrapper) req).getFileItemMap();

				LOGGER.info("파일 아이템 사이즈 : " + fileItemMap.size());

				if (fileItemMap.size() > 0) { // 파일이 존재하면...
					atchFileVO = fileService.saveAtchFileList(fileItemMap);
				}
			}
			
			
			
			
			MovieVO movieVO = new MovieVO();
			
			BeanUtils.populate(movieVO, req.getParameterMap());
			
			movieVO.setAtchFileCd(atchFileVO.getAtchFileCd());
		
			int cnt = movieService.insertMovie(movieVO);

			String msg = "";
			if (cnt > 0) {
				msg = "성공";
			} else {
				msg = "실패";
			}

			String redirectURL = req.getContextPath() + "/admin/movielist.do?msg=" + URLEncoder.encode(msg, "utf-8");
			return redirectURL;

		}
		
		return null;
	}

}
