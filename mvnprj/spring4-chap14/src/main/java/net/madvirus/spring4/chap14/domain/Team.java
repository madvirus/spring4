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
}
