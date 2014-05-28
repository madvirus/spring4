package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.domain.Employee;
import net.madvirus.spring4.chap14.domain.EmployeeRepository;
import net.madvirus.spring4.chap14.domain.Team;
import net.madvirus.spring4.chap14.domain.TeamRepository;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class MainForQuery {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:/springconf.xml");

		TeamRepository teamRepo = ctx.getBean(TeamRepository.class);
		for (Team team : teamRepo.findAll()) {
			System.out.println(team.getName());
		}

		EmployeeRepository empRepo = ctx.getBean(EmployeeRepository.class);
		printEmployees("findByBirthYear", empRepo.findByBirthYear(1977));
		printEmployees("findByNameLike", empRepo.findByNameLike("%범%"));
		printEmployees("findByNameStartingWith", empRepo.findByNameStartingWith("범균"));
		printEmployees("findByNameContaining", empRepo.findByNameContaining("범"));
		printEmployees("findByNameStartingWithOrderByNameAsc", empRepo.findByNameStartingWithOrderByNameAsc("제임스"));
		printEmployees("findByTeamIdOrderByIdDesc", empRepo.findByTeamIdOrderByIdDesc(1L));
		printEmployees("findByBirthYearOrderByTeamNameAscNameAsc",
				empRepo.findByBirthYearOrderByTeamNameAscNameAsc(1977));
		
		printTitle("Employee findByName(String name)");
		Employee emp = empRepo.findByEmployeeNumber("최범균");
		System.out.println(emp);
		System.out.println(empRepo.findByName("정도전"));
		// birthYear 프로퍼티 값이 1970보다 큰 엔티티가 두 개 이상이면 아래 코드는 익셉션을 발생시킨다. 
		// Employee emp2 = empRepo.findByBirthYearGreaterThan(1970);
		
		printTitle("long count() = " + empRepo.count());
		printTitle("long countByTeamId(1L) = " + empRepo.countByTeamId(2L));
		
		Sort sort = new Sort(
				new Order(Direction.DESC, "team.id"),
				new Order(Direction.ASC, "name")
				);
		printEmployees("findAll(Sort by team.id desc, name)", empRepo.findAll(sort));
		
		sort = new Sort("team.id", "birthYear");
		printEmployees("findAll(Sort by team.id, birthYear)", empRepo.findAll(sort));
		
		Team team = ctx.getBean(TeamRepository.class).findOne(1L);
		sort = new Sort("team.id", "id");
		printEmployees("findByTeam(team, Sort by team.id, id)", empRepo.findByTeam(team, sort));
		
		Pageable pageable = new PageRequest(2, 2, new Sort("birthYear"));
		
		printEmployees("findByBirthYearLessThan", empRepo.findByBirthYearLessThan(2000, pageable));
		
		pageable = new PageRequest(1, 4, new Sort("birthYear"));
		printEmployees("List<Employee> findByTeamId", empRepo.findByTeamId(1L, pageable));
		
		Page<Employee> empPage = empRepo.findByTeam(team, pageable);
		printPageEmployees("Page<Employee> findByTeam(team, pageable)",  empPage);
		ctx.close();
	}

	private static void printPageEmployees(String title, Page<Employee> empPage) {
		printTitle(title);
		System.out.printf("현재 페이지/전체 페이지 = %d/%d\n", empPage.getNumber(), empPage.getTotalPages());
		System.out.printf("현재 페이지 엘리먼트 개수/전체 개수/페이지 크기 = %d/%d/%d\n", 
				empPage.getNumberOfElements(), empPage.getTotalElements(), empPage.getSize());
		System.out.printf("isFirst() = %s, isLast() = %s, hasNext() = %s, hasPrevious() = %s\n",
				empPage.isFirst(), empPage.isLast(), empPage.hasNext(), empPage.hasPrevious());
		for (Employee emp : empPage) {
			System.out.println(emp.toString());
		}
	}

	private static void printEmployees(String title, Iterable<Employee> employees) {
		printTitle(title);
		for (Employee emp : employees) {
			System.out.println(emp.toString());
		}
	}

	private static void printTitle(String title) {
		System.out.println("============= " + title);
	}

}
