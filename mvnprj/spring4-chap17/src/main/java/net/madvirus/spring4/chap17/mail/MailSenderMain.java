package net.madvirus.spring4.chap17.mail;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MailSenderMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-mail.xml");
		SimpleRegistrationNotifier simpleNotifier = ctx.getBean("simpleNotifier", SimpleRegistrationNotifier.class);
		simpleNotifier.sendMail(new Member("madvirus@madvirus.net"));
		
//		SimpleRegistrationNotifier2 simpleNotifier2 = ctx.getBean("simpleNotifier2", SimpleRegistrationNotifier2.class);
//		simpleNotifier2.sendMail(new Member("madvirus@madvirus.net"));
		
//		MimeRegistrationNotifier mimeNotifier = ctx.getBean("mimeNotifier", MimeRegistrationNotifier.class);
//		mimeNotifier.sendMail(new Member("madvirus@madvirus.net"));
		
//		MimeAttachmentNotifier mimeAttachmentNotifier = ctx.getBean("mimeAttachmentNotifier", MimeAttachmentNotifier.class);
//		mimeAttachmentNotifier.sendMail(new Member("madvirus@madvirus.net"));
		
//		MimeInlineNotifier mimeInlineNotifier = ctx.getBean("mimeInlineNotifier", MimeInlineNotifier.class);
//		mimeInlineNotifier.sendMail(new Member("madvirus@madvirus.net"));
		
		ctx.close();

	}
}
