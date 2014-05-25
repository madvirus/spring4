package net.madvirus.spring4.chap14.main;

import java.util.List;

import net.madvirus.spring4.chap14.domain.Employee;
import net.madvirus.spring4.chap14.domain.EmployeeRepository;
import net.madvirus.spring4.chap14.domain.Team;
import net.madvirus.spring4.chap14.domain.TeamRepository;

import org.springframework.context.support.GenericXmlApplicationContext;
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
		
		Sort sort = new Sort(
				new Order(Direction.ASC, "team.id"),
				new Order(Direction.ASC, "name")
				);
		printEmployees("findAll(Sort)", empRepo.findAll(sort));
		Team team = ctx.getBean(TeamRepository.class).findOne(1L);
		
		sort = new Sort("team.id", "id");
		printEmployees("findByTeam()", empRepo.findByTeam(team, sort));
		
		ctx.close();
	}

	private static void printEmployees(String title, Iterable<Employee> employees) {
		System.out.println("=============");
		System.out.println(title);
		for (Employee emp : employees) {
			System.out.println(emp.toString());
		}
	}

}
