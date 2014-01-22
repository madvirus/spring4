package net.madvirus.spring4.chap05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJava {

	public static void main(String[] args) {
		useConfig();
		useConfig2();
	}

	private static void useConfig() {
		System.out.println("========= Config.class를 이용");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		DataCollector collector1 = ctx.getBean("collector1", DataCollector.class);
		DataCollector collector2 = ctx.getBean("collector2", DataCollector.class);
		System.out.println("collector1.threshold = " + collector1.getThreshold());
		System.out.println("collector2.threshold = " + collector2.getThreshold());
		ctx.close();
	}

	private static void useConfig2() {
		System.out.println("========= Config2.class (+applicationContext2.xml)를 이용");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config2.class);
		DataCollector collector1 = ctx.getBean("collector1", DataCollector.class);
		DataCollector collector2 = ctx.getBean("collector2", DataCollector.class);
		System.out.println("collector1.threshold = " + collector1.getThreshold());
		System.out.println("collector2.threshold = " + collector2.getThreshold());
		ctx.close();
	}
}
