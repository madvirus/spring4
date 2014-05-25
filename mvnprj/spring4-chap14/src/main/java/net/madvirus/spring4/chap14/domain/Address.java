package net.madvirus.spring4.chap14.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String address1;
	private String address2;
	private String zipcode;

	protected Address() {
	}

	public Address(String address1, String address2, String zipcode) {
		this.address1 = address1;
		this.address2 = address2;
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getZipcode() {
		return zipcode;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", zipcode=" + zipcode + "]";
	}

}
