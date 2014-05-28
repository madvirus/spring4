package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.domain.EmployeeRepository;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForDelete {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:/springconf.xml");

		EmployeeRepository empRepository = ctx.getBean(EmployeeRepository.class);
		empRepository.delete(9L);
		ctx.close();
	}
}
