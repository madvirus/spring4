package net.madvirus.spring4.chap15.hr.model;

import java.util.Date;

public class Employee {

	private Long id;
	private String number;
	private String name;
	private Address homeAddress;
	private int birtyYear;
	private Long teamId;
	private Date joinedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public int getBirtyYear() {
		return birtyYear;
	}

	public void setBirtyYear(int birtyYear) {
		this.birtyYear = birtyYear;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

}
