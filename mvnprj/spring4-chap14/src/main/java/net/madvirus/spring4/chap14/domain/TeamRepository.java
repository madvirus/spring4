package net.madvirus.spring4.chap14.domain;

import java.util.List;

import net.madvirus.spring4.chap14.common.NameFindableRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface TeamRepository extends Repository<Team, Long>, NameFindableRepository<Team> {

	Iterable<Team> findAll();

	Team findOne(Long id);

	@Query(value = "select * from TEAM where NAME like ?1%", nativeQuery = true)
	List<Team> findByNameLike(String name);

	public Option<Team> getOption(Long id);

	@Modifying(clearAutomatically = true)
	@Query("update Team t set t.name = ?2 where t.id = ?1")
	public int updateName(Long id, String newName);

}
