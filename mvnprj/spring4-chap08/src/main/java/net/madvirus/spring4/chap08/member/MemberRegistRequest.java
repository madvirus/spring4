package net.madvirus.spring4.chap08.member;

import java.util.Date;

import net.madvirus.spring4.chap08.common.Money;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberRegistRequest {

	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	private boolean allowNoti;
	private Address address;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date birthday;
	private String jobCode;
	private String[] favoriteOs;
	private String tool;
	private String etc;
	private Money allowance;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isAllowNoti() {
		return allowNoti;
	}

	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isSamePasswordConfirmPassword() {
		if (password == null || confirmPassword == null)
			return false;
		return password.equals(confirmPassword);
	}

	public boolean hasPassword() {
		return password != null && password.trim().length() > 0;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String[] getFavoriteOs() {
		return favoriteOs;
	}

	public void setFavoriteOs(String[] favoriteOs) {
		this.favoriteOs = favoriteOs;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public Money getAllowance() {
		return allowance;
	}

	public void setAllowance(Money allowance) {
		this.allowance = allowance;
	}

}
