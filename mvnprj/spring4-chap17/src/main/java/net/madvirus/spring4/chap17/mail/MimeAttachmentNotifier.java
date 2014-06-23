package net.madvirus.spring4.chap17.mail;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MimeAttachmentNotifier implements RegistrationNotifier {

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
			messageHelper.setSubject("회원 가입 안내 [Attachemtn]");
			String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다.";
			messageHelper.setText(htmlContent, true);
			messageHelper.setFrom("no-reply@madvirus.net", "운영자");
			messageHelper.setTo(new InternetAddress(member.getEmail(), "utf-8"));

			DataSource dataSource = new FileDataSource("안내문.docx");
			messageHelper.addAttachment(
					MimeUtility.encodeText("안내문.docx", "utf-8", "B"), dataSource);
		} catch (Throwable e) {
			e.printStackTrace();
			return;
		}
		try {
			mailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		}

	}

}
