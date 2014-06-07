package net.madvirus.spring4.chap15.hr.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.madvirus.spring4.chap15.conf.SpringAppConfig;
import net.madvirus.spring4.chap15.hr.model.Employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@ContextConfiguration(classes = SpringAppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("../dao/Employee.xml")
public class EmployeeRegistryServiceIntTest {

	@Autowired
	private EmployeeRegistryService regService;

	@Test
	public void giveNoDupEmpNumber_shouldInserted() throws Exception {
		Employee emp = new Employee();
		emp.setNumber("2345678901");
		emp.setName("시장님");
		emp.setBirtyYear(1978);
		emp.setJoinedDate(createDate("2014-06-04"));

		Long newId = regService.register(emp);
		assertThat(newId, notNullValue());
		assertThat(newId, greaterThan(6L));
	}

	@Test(expected = DuplicateEmpNumberException.class)
	public void giveDupEmpNumber_shouldThrow() throws Exception {
		Employee emp = new Employee();
		emp.setNumber("1234567890");
		emp.setName("회장님");
		emp.setBirtyYear(1978);
		emp.setJoinedDate(createDate("2014-06-04"));

		regService.register(emp);
	}

	private Date createDate(String dateString) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(dateString);
	}
}
