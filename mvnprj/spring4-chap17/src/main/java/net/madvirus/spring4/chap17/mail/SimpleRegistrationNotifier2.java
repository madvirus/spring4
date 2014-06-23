package net.madvirus.spring4.chap17.mail;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleRegistrationNotifier2 implements RegistrationNotifier {

	private MailSender mailSender;
	private SimpleMailMessage templateMailMessage;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setTemplateMailMessage(SimpleMailMessage templateMailMessage) {
		this.templateMailMessage = templateMailMessage;
	}

	@Override
	public void sendMail(Member member) {
		SimpleMailMessage message = new SimpleMailMessage(templateMailMessage);
		message.setTo(member.getEmail());
		try {
			mailSender.send(message);
		} catch (MailException ex) {
			ex.printStackTrace();
		}

	}
}
