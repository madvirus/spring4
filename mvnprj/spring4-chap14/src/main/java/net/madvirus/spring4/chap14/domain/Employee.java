package net.madvirus.spring4.chap14.domain;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "EMPLOYEE_NUM")
	private String employeeNumber;

	@Column(name = "NAME")
	private String name;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "address1",
					column = @Column(name = "HOME_ADDR1")),
			@AttributeOverride(name = "address2",
					column = @Column(name = "HOME_ADDR2")),
			@AttributeOverride(name = "zipcode",
					column = @Column(name = "HOME_ZIPCODE"))
	})
	private Address address;

	@Column(name = "BIRTH_YEAR")
	private int birthYear;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	@Temporal(TemporalType.DATE)
	@Column(name = "JOINED_DATE")
	private Date joinedDate;

	public Employee(String employeeNum, String name, Address address, int birthYear,
			Team team, Date joinedDate) {
		this.employeeNumber = employeeNum;
		this.name = name;
		this.address = address;
		this.birthYear = birthYear;
		this.team = team;
		this.joinedDate = joinedDate;
	}

	protected Employee() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
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

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void changeTeam(Team newTeam) {
		this.team = newTeam;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeNumber=" + employeeNumber + ", name=" + name + ", address=" + address
				+ ", birthYear=" + birthYear + ", team=" + team + ", joinedDate=" + joinedDate + "]";
	}

}
