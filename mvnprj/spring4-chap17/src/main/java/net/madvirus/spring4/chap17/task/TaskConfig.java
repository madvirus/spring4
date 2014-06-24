package net.madvirus.spring4.chap17.task;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
@EnableAsync(proxyTargetClass = true)
public class TaskConfig implements SchedulingConfigurer, AsyncConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addCronTask(new Runnable() {
			@Override
			public void run() {
				logCollector().collect();
			}
		}, "*/5 * * * * *");
	}

	@Bean
	public LogCollector logCollector() {
		return new LogCollector();
	}

	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(4);
		scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		return scheduler;
	}

	@Bean
	public LogProcessor logProcessor() {
		return new LogProcessor();
	}

	@Bean
	public MessageSender messageSender() {
		return new MessageSender();
	}

	@Override
	public Executor getAsyncExecutor() {
		return taskScheduler();
	}

}
