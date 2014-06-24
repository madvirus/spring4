package net.madvirus.spring4.chap17.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Processor {

	private ThreadPoolTaskExecutor taskExecutor;

	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void process(final Work work) {
        Future<?> future = taskExecutor.submit(new Runnable() {
			@Override
			public void run() {
				work.doWork();
			}
        });
        try {
            future.get();
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
        return;
    }
}
