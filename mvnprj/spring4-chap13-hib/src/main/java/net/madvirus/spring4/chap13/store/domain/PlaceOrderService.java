package net.madvirus.spring4.chap13.store.domain;

public interface PlaceOrderService {

	public PurchaseOrderResult order(PurchaseOrderRequest buyRequest) throws ItemNotFoundException;
}
