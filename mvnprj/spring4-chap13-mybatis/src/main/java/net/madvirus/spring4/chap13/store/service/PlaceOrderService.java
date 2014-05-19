package net.madvirus.spring4.chap13.store.service;

import net.madvirus.spring4.chap13.store.model.ItemNotFoundException;

public interface PlaceOrderService {

	public PurchaseOrderResult order(PurchaseOrderRequest buyRequest) throws ItemNotFoundException;
}
