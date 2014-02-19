package net.madvirus.spring4.chap07.member;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {

	@NotEmpty
	private String address1;
	@NotEmpty
	private String address2;
	private String zipcode;

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
