package net.madvirus.spring4.chap05;

public class Money {

	private int amount;
	private String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return amount + currency;
	}

}
