package net.madvirus.spring4.chap15.hr.service;

import org.springframework.transaction.annotation.Transactional;

import net.madvirus.spring4.chap15.hr.dao.EmployeeDao;
import net.madvirus.spring4.chap15.hr.model.Employee;

public class EmployeeRegistryServiceImpl implements EmployeeRegistryService {

	private EmployeeDao empDao;

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	@Transactional
	@Override
	public Long register(Employee emp) {
		Employee oldEmp = empDao.selectByEmployeeNumber(emp.getNumber());
		if (oldEmp != null)
			throw new DuplicateEmpNumberException();
		return empDao.insert(emp);
	}

}
