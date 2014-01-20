package net.madvirus.spring4.chap04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByProfileOfXml {

	public static void main(String[] args) {
		useBeansProfileXml();
		useNestedBeansProfile();
	}

	private static void useBeansProfileXml() {
		System.out.println("===== <beans> profile을 이용한 설정 ==== ");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		context.load(
				"classpath:/confprofile/prop-config.xml",
				"classpath:/confprofile/app-config.xml",
				"classpath:/confprofile/datasource-dev.xml",
				"classpath:/confprofile/datasource-prod.xml"
				);
		context.refresh();

		ChargeCalculator cal = context.getBean(ChargeCalculator.class);
		cal.calculate();
		context.close();
	}

	private static void useNestedBeansProfile() {
		System.out.println("===== 중첩 <beans> 태그를 이용한 profile 설정 ==== ");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		context.load("classpath:/confprofile/applicationContext.xml");
		context.refresh();

		ChargeCalculator cal = context.getBean(ChargeCalculator.class);
		cal.calculate();
		context.close();
	}
}
