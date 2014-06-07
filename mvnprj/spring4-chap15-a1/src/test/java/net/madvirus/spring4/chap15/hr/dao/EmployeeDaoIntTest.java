package net.madvirus.spring4.chap15.hr.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
@DatabaseSetup("Employee.xml")
public class EmployeeDaoIntTest {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	public void insert() throws Exception {
		Employee emp = new Employee();
		emp.setNumber("2345678901");
		emp.setName("유종필");
		emp.setBirtyYear(1978);
		emp.setJoinedDate(createDate("2014-06-04"));
		Long newId = employeeDao.insert(emp);
		assertThat(newId, notNullValue());
		assertThat(newId, greaterThan(6L));
	}
	
	@Test
	public void givenExistingEmployeeNumber_then_SelectByEmployeeNumber_Return_MatchingEmployee() {
		Employee emp = employeeDao.selectByEmployeeNumber("1234567891");
		assertThat(emp, notNullValue());
	}

	@Test
	public void givenNoneExistingEmployeeNumber_then_SelectByEmployeeNumber_Return_MatchingEmployee() {
		Employee emp = employeeDao.selectByEmployeeNumber("9999999999");
		assertThat(emp, nullValue());
	}

	@Test
	public void givenNoCcondition_then_returnAll() throws Exception {
		SearchCondition cond = new SearchCondition();
		List<Employee> list = employeeDao.selectList(cond);
		assertThat(list, hasSize(6));
	}

	@Test
	public void givenNameLike_then_returnMatching() throws Exception {
		SearchCondition cond = new SearchCondition();
		cond.setNameKeyword("범");
		List<Employee> list = employeeDao.selectList(cond);
		assertThat(list, hasSize(1));
		Employee emp = list.get(0);
		assertThat(emp.getName(), equalTo("최범균"));
	}

	@Test
	public void givenEmpNumber_then_returnMatching() throws Exception {
		SearchCondition cond = new SearchCondition();
		cond.setEmpNumber("1234567891");
		List<Employee> list = employeeDao.selectList(cond);
		assertThat(list, hasSize(1));
		Employee emp = list.get(0);
		assertThat(emp.getName(), equalTo("홍길동"));
	}

	@Test
	public void givenFromJoinedDate_then_returnMatching() throws Exception {
		SearchCondition cond = new SearchCondition();
		cond.setFromJoinedDate(createDate("2013-01-01"));
		List<Employee> list = employeeDao.selectList(cond);
		assertThat(list, hasSize(5));
	}

	@Test
	public void givenToJoinedDate_then_returnMatching() throws Exception {
		SearchCondition cond = new SearchCondition();
		cond.setFromJoinedDate(createDate("2013-12-31"));
		List<Employee> list = employeeDao.selectList(cond);
		assertThat(list, hasSize(3));
	}

	@Test
	public void givenFromTo_then_returnMathcing() throws Exception {
		SearchCondition cond = new SearchCondition();
		cond.setFromJoinedDate(createDate("2013-01-01"));
		cond.setToJoinedDate(createDate("2013-12-31"));
		List<Employee> list = employeeDao.selectList(cond);
		assertThat(list, hasSize(2));
	}

	private Date createDate(String dateString) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(dateString);
	}
}
