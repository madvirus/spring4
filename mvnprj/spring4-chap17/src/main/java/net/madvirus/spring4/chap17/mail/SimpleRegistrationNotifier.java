package net.madvirus.spring4.chap17.mail;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleRegistrationNotifier implements RegistrationNotifier {

	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMail(Member member) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[Simple] 회원 가입 안내");
		message.setFrom("no-reply@madvirus.net");
		message.setText("회원 가입을 환영합니다.");
		message.setTo(member.getEmail());
		try {
			mailSender.send(message);
		} catch (MailException ex) {
			ex.printStackTrace();
		}

	}
}
