package net.madvirus.spring4.chap14.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface TeamRepository extends Repository<Team, Long> {

	Iterable<Team> findAll();

	Team findOne(Long id);

	@Query(value = "select * from TEAM where NAME like ?1%", nativeQuery = true)
	List<Team> findByName(String name);
}
