package net.madvirus.spring4.chap14.application;

import java.util.List;

import net.madvirus.spring4.chap14.domain.Employee;

public interface EmployeeListService {

	public List<Employee> getEmployee(String keyword, Long teamId);
}
