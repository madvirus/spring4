package net.madvirus.spring4.chap17.task;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

public class TaskMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-task.xml");

		MessageSender messageSender = ctx.getBean(MessageSender.class);
		messageSender.send("메시지!!");
		System.out.println("MessageSender.send(메시지!!) 호출함");

		Processor processor = ctx.getBean("processor", Processor.class);
		processor.process(new Work());

		ThreadPoolTaskScheduler scheduler = ctx.getBean("scheduler",
				ThreadPoolTaskScheduler.class);

		Runnable cacheInitializerRunner = new Runnable() {
			@Override
			public void run() {
				System.out.println("cacheInitializerRunner 실행: " + new Date());
			}
		};
		Runnable statusMonitorRunner = new Runnable() {
			@Override
			public void run() {
				System.out.println("statusMonitorRunner 실행: " + new Date());
			}
		};
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 5);
		scheduler.schedule(cacheInitializerRunner, calendar.getTime());
		scheduler.scheduleAtFixedRate(statusMonitorRunner, 1000);

		Runnable logCollector = new Runnable() {
			@Override
			public void run() {
				System.out.println("logCollector 실행: " + new Date());
			}
		};
		scheduler.schedule(logCollector, new CronTrigger("*/10 * * * * *"));

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
