package net.madvirus.spring4.chap12.store.service;

import net.madvirus.spring4.chap12.store.domain.ItemNotFoundException;

public interface PlaceOrderService {

	public PurchaseOrderResult order(PurchaseOrderRequest buyRequest) throws ItemNotFoundException;
}
