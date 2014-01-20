package net.madvirus.spring4.chap04;

import net.madvirus.spring4.chap04.config.ApplicationConfig;
import net.madvirus.spring4.chap04.config.ApplicationContextConfig;
import net.madvirus.spring4.chap04.config.DataSourceDevConfig;
import net.madvirus.spring4.chap04.config.DataSourceProdConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByProfileOfJava {

	public static void main(String[] args) {
		useConfigurationProfile();
		useNestedConfigurationProfile();
	}

	private static void useConfigurationProfile() {
		System.out.println("===== @Configuration profile을 이용한 설정 ==== ");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		context.register(ApplicationConfig.class, DataSourceDevConfig.class, DataSourceProdConfig.class);
		context.refresh();

		ChargeCalculator cal = context.getBean(ChargeCalculator.class);
		cal.calculate();
		context.close();
	}

	private static void useNestedConfigurationProfile() {
		System.out.println("===== 중첩 @Configuation을 이용한 profile 설정 ==== ");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.getEnvironment().setActiveProfiles("prod");
		context.register(ApplicationContextConfig.class);
		context.refresh();

		ChargeCalculator cal = context.getBean(ChargeCalculator.class);
		cal.calculate();
		context.close();
	}
}
