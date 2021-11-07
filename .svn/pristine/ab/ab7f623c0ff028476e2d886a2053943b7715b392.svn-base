package common.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
	/**
	 * 해당 화면에 대해 포워드 및 리다이렉트 여부를 결정하기 위한 메소드
	 * @param req
	 * @return redirect일 경우 true, forward일 경우 false
	 */
	public boolean isRedirect(HttpServletRequest req);
	
	/**
	 * 요청한 내용을 실제 처리하는 메소드
	 * @param req 요청 객체
	 * @param resp 응답 객체
	 * @return 뷰 페이지 정보
	 * @throws Exception
	 */
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}