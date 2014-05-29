package net.madvirus.spring4.chap14.application;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import net.madvirus.spring4.chap14.domain.Employee;
import net.madvirus.spring4.chap14.domain.EmployeeRepository;
import net.madvirus.spring4.chap14.domain.EmployeeSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

public class SpecEmployeeListService implements EmployeeListService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	@Override
	public List<Employee> getEmployee(String keyword, Long teamId) {
		Specification<Employee> spec = null;
		if (hasValue(keyword) || hasValue(teamId)) {
			if (hasValue(keyword) && !hasValue(teamId)) {
				spec = Specifications.where(
						EmployeeSpec.nameEq(keyword)).or(EmployeeSpec.employeeNumberEq(keyword));
			} else if (!hasValue(keyword) && hasValue(teamId)) {
				spec = EmployeeSpec.teamIdEq(teamId);
			} else {
				Specifications<Employee> spec1 = Specifications.where(EmployeeSpec.nameEq(keyword)).
						or(EmployeeSpec.employeeNumberEq(keyword));
				spec = spec1.and(EmployeeSpec.teamIdEq(teamId));
			}
		} else {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -30);
			spec = EmployeeSpec.joinedDateGt(cal.getTime());
		}
		return employeeRepository.findAll(spec);
	}

	private boolean hasValue(Object value) {
		return value != null;
	}

	private boolean hasValue(String value) {
		return value != null && !value.trim().isEmpty();
	}
}
