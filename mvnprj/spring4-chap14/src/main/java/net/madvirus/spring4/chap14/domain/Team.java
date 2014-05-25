package net.madvirus.spring4.chap14.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team {

	@Id
	@Column(name = "TEAM_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	protected Team() {
	}

	public Team(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}

}
