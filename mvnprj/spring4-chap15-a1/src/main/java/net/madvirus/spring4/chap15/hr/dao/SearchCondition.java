package net.madvirus.spring4.chap15.hr.dao;

import java.util.Date;

public class SearchCondition {
	private Date fromJoinedDate;
	private Date toJoinedDate;
	private String nameKeyword;
	private String empNumber;

	public Date getFromJoinedDate() {
		return fromJoinedDate;
	}

	public void setFromJoinedDate(Date fromJoinedDate) {
		this.fromJoinedDate = fromJoinedDate;
	}

	public Date getToJoinedDate() {
		return toJoinedDate;
	}

	public void setToJoinedDate(Date toJoinedDate) {
		this.toJoinedDate = toJoinedDate;
	}

	public String getNameKeyword() {
		return nameKeyword;
	}

	public void setNameKeyword(String nameKeyword) {
		this.nameKeyword = nameKeyword;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public boolean hasNoCond() {
		return fromJoinedDate == null && toJoinedDate == null &&
				isEmpty(nameKeyword) && isEmpty(empNumber);
	}

	private boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}

	public boolean hasEmpNumber() {
		return empNumber != null && !empNumber.isEmpty();
	}

	public boolean hasNameKeyword() {
		return nameKeyword != null && !nameKeyword.trim().isEmpty();
	}

	public boolean hasFromJoinedDate() {
		return fromJoinedDate != null;
	}

	public boolean hasToJoinedDate() {
		return toJoinedDate != null;
	}

}
