package net.madvirus.spring4.chap12.store.service;

public class PurchaseOrderRequest {

	private Integer itemId;
	private String address;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
