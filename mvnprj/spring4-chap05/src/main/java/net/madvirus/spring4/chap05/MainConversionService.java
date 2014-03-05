package net.madvirus.spring4.chap05;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainConversionService {

	public static void main(String[] args) {
		run("classpath:conversionService.xml");
		run("classpath:conversionService2.xml");
	}

	private static void run(String configPath) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(configPath);
		RestClient restClient = ctx.getBean(RestClient.class);
		System.out.println(restClient.toString());
		ctx.close();
	}

}
