package net.madvirus.spring4.chap02;

import net.madvirus.spring4.chap02.conf.Config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config.class);

		AuthenticationService authSvc =
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");

		User user1 = ctx.getBean("user1", User.class);
		System.out.println(user1.getId());
		// Monitor monitor = ctx.getBean(Monitor.class);
		// System.out.println(monitor);
		ctx.close();
	}

}
