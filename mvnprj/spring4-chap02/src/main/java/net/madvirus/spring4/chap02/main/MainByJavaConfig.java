package net.madvirus.spring4.chap02.main;

import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.conf.Config;
import net.madvirus.spring4.chap02.conf.Config1;
import net.madvirus.spring4.chap02.conf.Config2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaConfig {

	public static void main(String[] args) {
		useSingleClass();
		useMultipleClass();
	}

	private static void useSingleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config.class);
		useBean(ctx);
		ctx.close();
	}

	private static void useBean(AnnotationConfigApplicationContext ctx) {
		AuthenticationService authSvc =
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");

		PasswordChangeService pwChgSvc =
				ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	}

	private static void useMultipleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config1.class, Config2.class);
		useBean(ctx);
		ctx.close();
	}
}
