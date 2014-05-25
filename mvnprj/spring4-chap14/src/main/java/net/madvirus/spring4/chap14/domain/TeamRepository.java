package net.madvirus.spring4.chap14.domain;

import org.springframework.data.repository.Repository;

public interface TeamRepository extends Repository<Team, Long> {

	Iterable<Team> findAll();

	Team findOne(Long id);

}
