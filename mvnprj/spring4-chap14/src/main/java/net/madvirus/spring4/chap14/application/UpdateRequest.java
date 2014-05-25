package net.madvirus.spring4.chap14.application;

import net.madvirus.spring4.chap14.domain.Address;

public class UpdateRequest {

	private Long employeeId;
	private Address newAddress;

	public UpdateRequest(Long employeeId, Address newAddress) {
		this.employeeId = employeeId;
		this.newAddress = newAddress;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Address getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(Address newAddress) {
		this.newAddress = newAddress;
	}

}
