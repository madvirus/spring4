package net.madvirus.spring4.chap05;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainPropertyEditor {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:propertyEditor.xml");
		RestClient restClient = ctx.getBean(RestClient.class);
		System.out.println(restClient.toString());
		ctx.close();
	}

}
