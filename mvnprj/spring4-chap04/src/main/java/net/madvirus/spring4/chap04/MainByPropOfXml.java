package net.madvirus.spring4.chap04;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MainByPropOfXml {

	public static void main(String[] args) throws IOException {
		usePropertyPlaceholder();
		useTwoPropertyPlaceholder();
	}

	private static void usePropertyPlaceholder() {
		System.out.println("------ 1개 PropertyPlaceholder 사용");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/db-config.xml");
		ConfigurableEnvironment env = ctx.getEnvironment();

		System.out.println(env.getProperty("java.version"));
		ctx.close();
	}

	private static void useTwoPropertyPlaceholder() {
		System.out.println("------ 2개 PropertyPlaceholder 사용");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:/app-config.xml",
				"classpath:/db-config.xml"
				);
		ChargeCalculator calculator = ctx.getBean(ChargeCalculator.class);
		calculator.calculate();
		ctx.close();
	}
}
