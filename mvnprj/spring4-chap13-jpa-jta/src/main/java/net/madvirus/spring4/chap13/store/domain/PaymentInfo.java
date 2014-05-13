package net.madvirus.spring4.chap13.store.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYMENT_INFO_ID")
	private Integer id;
	
	@Column(name = "PRICE")
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
