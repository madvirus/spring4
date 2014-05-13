package net.madvirus.spring4.chap13.store.service;

import org.springframework.transaction.annotation.Transactional;

import net.madvirus.spring4.chap13.store.domain.Item;
import net.madvirus.spring4.chap13.store.domain.ItemRepository;
import net.madvirus.spring4.chap13.store.domain.ItemNotFoundException;
import net.madvirus.spring4.chap13.store.domain.PaymentInfo;
import net.madvirus.spring4.chap13.store.domain.PaymentInfoRepository;
import net.madvirus.spring4.chap13.store.domain.PurchaseOrder;
import net.madvirus.spring4.chap13.store.domain.PurchaseOrderRepository;

public class PlaceOrderServiceImpl implements PlaceOrderService {

	private ItemRepository itemRepository;
	private PaymentInfoRepository paymentInfoRepository;
	private PurchaseOrderRepository purchaseOrderRepository;

	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public void setPaymentInfoRepository(PaymentInfoRepository paymentInformationRepository) {
		this.paymentInfoRepository = paymentInformationRepository;
	}

	public void setPurchaseOrderRepository(PurchaseOrderRepository purchaseOrderRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
	}

	@Transactional
	@Override
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest)
			throws ItemNotFoundException {
		Item item = itemRepository.findById(orderRequest.getItemId());
		if (item == null)
			throw new ItemNotFoundException(orderRequest.getItemId());

		PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
		paymentInfoRepository.save(paymentInfo);

		PurchaseOrder order = new PurchaseOrder(item.getId(), orderRequest
				.getAddress(), paymentInfo.getId());
		purchaseOrderRepository.save(order);
		return new PurchaseOrderResult(item, paymentInfo, order);
	}

}
