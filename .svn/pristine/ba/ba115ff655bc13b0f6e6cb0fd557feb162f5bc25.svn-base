package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomCharacterEncoding implements Filter{

	private String encoding;	// 인코딩 정보를 저장할 변수
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		System.out.println("인코딩 설정 정보 : " + this.encoding);
		// req객체의 인코딩 설정
		req.setCharacterEncoding(this.encoding);
		// resp객체의 인코딩 설정
		resp.setCharacterEncoding(this.encoding);
		
		fc.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// web.xml에 <init-param>에 encoding을 설정했는지 여부를 확인한다. 
		if(config.getInitParameter("encoding") == null) {
			// 기본 인코딩을 UTF-8로 설정(원래 기본인코딩은 ISO-8859-1)
			this.encoding = "UTF-8";
		}else {
			this.encoding = config.getInitParameter("encoding");
		}
		
		
	}

}
