package net.madvirus.spring4.chap13.store.model;

public class PaymentInfo {

	private Integer id;
	private int price;

	public PaymentInfo() {
	}

	public PaymentInfo(int price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
