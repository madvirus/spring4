package net.madvirus.spring4.chap14.domain;

public interface EmployeeCustomRepository {

	public Option<Employee> getOptionEmployee(Long id);

}
