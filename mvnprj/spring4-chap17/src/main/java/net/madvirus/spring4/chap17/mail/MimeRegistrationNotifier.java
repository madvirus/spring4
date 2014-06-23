package net.madvirus.spring4.chap17.mail;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

public class MimeRegistrationNotifier implements RegistrationNotifier {
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMail(Member member) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			message.setSubject("[Mime] 회원 가입 안내", "utf-8");
			String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다.";
			message.setText(htmlContent, "utf-8", "html");
			message.setFrom(new InternetAddress("madvirus@madvirus.net"));
			message.addRecipient(
					RecipientType.TO,
					new InternetAddress(member.getEmail()));
			mailSender.send(message);
		} catch (Exception e) {
			// 실제로 익셉션 발생 내지 로그 남김
			e.printStackTrace();
		}
	}

}
