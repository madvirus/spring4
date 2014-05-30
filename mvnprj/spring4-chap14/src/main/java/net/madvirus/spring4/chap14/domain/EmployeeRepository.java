package net.madvirus.spring4.chap14.domain;

import java.util.List;

import net.madvirus.spring4.chap14.common.NameFindableRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends Repository<Employee, Long>, NameFindableRepository<Employee>, EmployeeCustomRepository {
	public Employee save(Employee emp);

	public Employee findOne(Long id);

	public Iterable<Employee> findByBirthYear(int year);

	public Iterable<Employee> findByNameLike(String name);

	public Iterable<Employee> findByNameStartingWith(String name);

	public Iterable<Employee> findByNameEndingWith(String name);

	public Iterable<Employee> findByNameContaining(String string);

	public List<Employee> findByNameStartingWithOrderByNameAsc(String name);

	public List<Employee> findByTeamIdOrderByIdDesc(Long teamId);

	public List<Employee> findByBirthYearOrderByTeamNameAscNameAsc(int year);

	public long count();

	public long countByTeamId(Long teamId);

	public List<Employee> findAll(Sort sort);

	public List<Employee> findByTeam(Team team, Sort sort);

	public List<Employee> findByBirthYearLessThan(int birthYear, Pageable pageable);

	public List<Employee> findByTeamId(Long teamId, Pageable pageable);

	public Page<Employee> findByTeam(Team team, Pageable pageable);

	@Query("from Employee e where e.employeeNumber = ?1 or e.name like %?2%")
	public Employee findByEmployeeNumberOrNameLike(String empNum, String name);

	public Employee findByBirthYearGreaterThan(int birthYear);

	public Iterable<Employee> findByTeamIdOrderByNameDesc(Long teamId, Sort sort);

	public void delete(Long id);

	@Query("from Employee e where e.birthYear < :year order by e.birthYear")
	public List<Employee> findEmployeeBornBefore(@Param("year") int year);

	@Query("from Employee e where e.birthYear < :year")
	public List<Employee> findEmployeeBornBefore(@Param("year") int year, Sort sort);

	@Query("from Employee e where e.birthYear < :year order by e.birthYear")
	public Page<Employee> findEmployeeBornBefore(@Param("year") int year, Pageable pageable);

	public List<Employee> findAll(Specification<Employee> spec);

	public Option<Employee> getOption(Long id);
}
