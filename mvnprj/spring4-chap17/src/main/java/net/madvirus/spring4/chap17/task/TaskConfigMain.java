package net.madvirus.spring4.chap17.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskConfigMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(TaskConfig.class);

		MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
		System.out.println("MessageSender.send(메시지!!) 호출함");
		messageSender.send("메시지");

		sleep(20000);

		ctx.close();
	}

	private static void sleep(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
		}
	}
}
