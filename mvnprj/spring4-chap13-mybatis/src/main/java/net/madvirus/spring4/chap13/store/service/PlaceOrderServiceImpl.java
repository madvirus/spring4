package net.madvirus.spring4.chap13.store.service;

import org.springframework.transaction.annotation.Transactional;

import net.madvirus.spring4.chap13.store.dao.ItemDao;
import net.madvirus.spring4.chap13.store.dao.PaymentInfoDao;
import net.madvirus.spring4.chap13.store.dao.PurchaseOrderDao;
import net.madvirus.spring4.chap13.store.model.Item;
import net.madvirus.spring4.chap13.store.model.ItemNotFoundException;
import net.madvirus.spring4.chap13.store.model.PaymentInfo;
import net.madvirus.spring4.chap13.store.model.PurchaseOrder;

public class PlaceOrderServiceImpl implements PlaceOrderService {

	private ItemDao itemDao;
	private PaymentInfoDao paymentInfoDao;
	private PurchaseOrderDao purchaseOrderDao;

	public void setItemDao(ItemDao itemRepository) {
		this.itemDao = itemRepository;
	}

	public void setPaymentInfoDao(PaymentInfoDao paymentInformationRepository) {
		this.paymentInfoDao = paymentInformationRepository;
	}

	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderRepository) {
		this.purchaseOrderDao = purchaseOrderRepository;
	}

	@Transactional
	@Override
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest)
			throws ItemNotFoundException {
		Item item = itemDao.findById(orderRequest.getItemId());
		if (item == null)
			throw new ItemNotFoundException(orderRequest.getItemId());

		PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
		paymentInfoDao.save(paymentInfo);

		PurchaseOrder order = new PurchaseOrder(item.getId(), orderRequest
				.getAddress(), paymentInfo.getId());
		purchaseOrderDao.save(order);
		return new PurchaseOrderResult(item, paymentInfo, order);
	}

}
