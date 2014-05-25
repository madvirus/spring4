package net.madvirus.spring4.chap14.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.madvirus.spring4.chap14.domain.Employee;
import net.madvirus.spring4.chap14.domain.EmployeeRepository;

public class UpdateEmployeeServiceImpl implements UpdateEmployeeService {

	@Autowired
	private EmployeeRepository emploeeRepository;

	@Transactional
	@Override
	public void updateEmployee(UpdateRequest updateReq) {
		Employee employee = emploeeRepository.findOne(updateReq.getEmployeeId());
		if (employee == null)
			throw new EmployeeNotFoundException();

		employee.setAddress(updateReq.getNewAddress());
	}

}
