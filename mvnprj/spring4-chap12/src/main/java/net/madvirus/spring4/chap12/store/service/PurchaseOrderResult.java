package net.madvirus.spring4.chap12.store.service;

import net.madvirus.spring4.chap12.store.domain.Item;
import net.madvirus.spring4.chap12.store.domain.PaymentInfo;
import net.madvirus.spring4.chap12.store.domain.PurchaseOrder;

public class PurchaseOrderResult {
	private Item item;
	private PaymentInfo paymentInfo;
	private PurchaseOrder order;

	public PurchaseOrderResult(Item item, PaymentInfo paymentInfo,
			PurchaseOrder order) {
		this.item = item;
		this.paymentInfo = paymentInfo;
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public PurchaseOrder getOrder() {
		return order;
	}

}
