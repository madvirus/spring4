package net.madvirus.spring4.chap14.domain;

import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface EmployeeRepository extends Repository<Employee, Long> {

}
