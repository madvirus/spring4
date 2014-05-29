package net.madvirus.spring4.chap14.domain;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpec {

	public static Specification<Employee> nameEq(final String name) {
		return new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(Employee_.name), name);
			}
		};
	}

	public static Specification<Employee> employeeNumberEq(final String num) {
		return new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(Employee_.employeeNumber), num);
			}
		};
	}

	public static Specification<Employee> teamIdEq(final Long teamId) {
		return new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(Employee_.team).get(Team_.id), teamId);
			}
		};
	}

	public static Specification<Employee> joinedDateGt(final Date date) {
		return new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.greaterThan(root.get(Employee_.joinedDate), date);
			}
		};
	}
}
