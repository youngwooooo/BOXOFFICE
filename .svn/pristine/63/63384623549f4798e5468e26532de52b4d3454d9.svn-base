package member.inquery.handler;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.vo.MemberVO;
import member.inquery.service.IInqueryService;
import member.inquery.service.InqueryServiceImpl;
import util.SHA256Util;

public class ModifyPasswordHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/jsp/common/resultJson.jsp";
	private IInqueryService service = InqueryServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String memId = req.getParameter("memId");
		String memMail = req.getParameter("memMail");
		
		String tempPassword = "";
		for (int i = 0; i < 12; i++) {
			tempPassword += (char)((Math.random() * 26) + 97);
		}
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMemId(memId);
		
		String encPassword = SHA256Util.getEncrypt(tempPassword, memId);
		
		memberVO.setMemPass(encPassword);
		
		//서비스단에 전달하여 비밀번호 변경
		int count = service.modifyPassword(memberVO);
		
		if(count > 0) {
			mailSend(memMail, tempPassword);
		}
		
		req.setAttribute("result", count);
		
		return VIEW_PAGE;
	}
	
	public static void mailSend(String memMail, String tempPassword) {
		String host = "smtp.naver.com";			// 네이버일 경우 네이버 계정
		String user = "derstern_8@naver.com";	// 보내는 계정
		String password = "ASDFasdf1!";			// 보내는 계정 패스워드
		
		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", 587); 
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(memMail));
			
			message.setSubject("BOX OFFICE 임시 비밀번호 입니다.");
			message.setText("임시 비밀번호는 " + tempPassword + " 입니다. 보안을 위해 로그인 후 즉시 비밀번호를 변경해주세요.");
			
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
