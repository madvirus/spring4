package net.madvirus.spring4.chap14.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "address1", column = @Column(name = "HOME_ADDR1")),
			@AttributeOverride(name = "address2", column = @Column(name = "HOME_ADDR2")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "HOME_ZIPCODE"))
	})
	private Address address;

	@Column(name = "BIRTH_YEAR")
	private int birthYear;

	@ManyToOne
	@Column(name = "TEAM_ID")
	private Team team;

	public Employee(Long id, String name, Address address, int birthYear, Team team) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthYear = birthYear;
		this.team = team;
	}

	protected Employee() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public Team getTeam() {
		return team;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void changeTeam(Team newTeam) {
		this.team = newTeam;
	}

}
