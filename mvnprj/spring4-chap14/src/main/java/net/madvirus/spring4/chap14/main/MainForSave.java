package net.madvirus.spring4.chap14.main;

import java.util.Date;

import net.madvirus.spring4.chap14.domain.Address;
import net.madvirus.spring4.chap14.domain.Employee;
import net.madvirus.spring4.chap14.domain.EmployeeRepository;
import net.madvirus.spring4.chap14.domain.Team;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSave {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:/springconf.xml");

		EmployeeRepository empRepository = ctx.getBean(EmployeeRepository.class);
		Employee emp = new Employee("1234567896", "이도", 
				new Address("서울시 종로구", "통인동", "110043"), 1996, 
				new Team(1L, "SW개발팀"), new Date());
		empRepository.save(emp);
		
		ctx.close();
	}
}
