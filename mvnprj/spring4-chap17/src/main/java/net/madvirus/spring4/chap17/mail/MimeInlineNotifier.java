package net.madvirus.spring4.chap17.mail;

import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MimeInlineNotifier implements RegistrationNotifier {

	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMail(Member member) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = 
					new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setSubject("[Inline] 회원 가입 안내");
			String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다."
                    + "<img src='cid:signature' />";
			messageHelper.setText(htmlContent, true);
			messageHelper.setFrom("no-reply@madvirus.net", "운영자");
			messageHelper.setTo(new InternetAddress(member.getEmail(), "utf-8"));

			messageHelper.addInline("signature", new FileDataSource("sign.jpg"));
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
