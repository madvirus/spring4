package net.madvirus.spring4.chap15.hr.dao;

import java.util.List;

import net.madvirus.spring4.chap15.hr.model.Employee;

public interface EmployeeDao {
	public Long insert(Employee emp);

	public Employee selectOne(Long id);

	public List<Employee> selectList(SearchCondition cond);

	public Employee selectByEmployeeNumber(String number);
}
