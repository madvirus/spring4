package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.application.UpdateEmployeeService;
import net.madvirus.spring4.chap14.application.UpdateRequest;
import net.madvirus.spring4.chap14.domain.Address;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForUpdate {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:/springconf.xml");

		UpdateEmployeeService updateEmpSvc =
				ctx.getBean(UpdateEmployeeService.class);
		updateEmpSvc.updateEmployee(
				new UpdateRequest(1L, new Address("서울시", "관악구", "123456")));

		ctx.close();
	}
}
