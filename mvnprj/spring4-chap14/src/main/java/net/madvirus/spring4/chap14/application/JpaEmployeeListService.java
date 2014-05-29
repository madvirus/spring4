package net.madvirus.spring4.chap14.application;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import net.madvirus.spring4.chap14.domain.Employee;

public class JpaEmployeeListService implements EmployeeListService {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Transactional
	@Override
	public List<Employee> getEmployee(String keyword, Long teamId) {
		CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();

		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> employee = query.from(Employee.class);
		query.select(employee);

		if (hasValue(keyword) || hasValue(teamId)) {
			if (hasValue(keyword) && !hasValue(teamId)) {
				query.where(cb.or(
						cb.equal(employee.get("name"), keyword),
						cb.equal(employee.get("employeeNumber"), keyword)));
			} else if (!hasValue(keyword) && hasValue(teamId)) {
				query.where(cb.equal(employee.get("team").get("id"), teamId));
			} else {

				query.where(cb.and(
						cb.or(
								cb.equal(employee.get("name"), keyword),
								cb.equal(employee.get("employeeNumber"), keyword)),
						cb.equal(employee.get("team").get("id"), teamId)
						));
			}
		} else {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -30);
			query.where(cb.greaterThan(employee.<Date> get("joinedDate"), cal.getTime()));
		}

		TypedQuery<Employee> typedQuery = entityManagerFactory.createEntityManager().createQuery(query);
		List<Employee> result = typedQuery.getResultList();
		return result;
	}

	private boolean hasValue(Object value) {
		return value != null;
	}

	private boolean hasValue(String value) {
		return value != null && !value.trim().isEmpty();
	}
}
