package net.madvirus.spring4.chap17.task;

import org.springframework.scheduling.annotation.Async;

public class MessageSender {

	@Async
	public void send(String message) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.printf("MessageSender.send(%s) 실행됨\n", message);
	}
}
