package net.madvirus.spring4.chap14.domain.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.madvirus.spring4.chap14.domain.Employee;
import net.madvirus.spring4.chap14.domain.EmployeeCustomRepository;
import net.madvirus.spring4.chap14.domain.Option;

public class EmployeeRepositoryImpl implements EmployeeCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Option<Employee> getOptionEmployee(Long id) {
		Employee emp = entityManager.find(Employee.class, id);
		return Option.value(emp);
	}

}
