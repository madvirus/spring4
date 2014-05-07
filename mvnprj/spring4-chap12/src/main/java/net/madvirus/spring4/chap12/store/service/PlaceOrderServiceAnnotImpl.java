package net.madvirus.spring4.chap12.store.service;

import net.madvirus.spring4.chap12.store.dao.ItemDao;
import net.madvirus.spring4.chap12.store.dao.PaymentInfoDao;
import net.madvirus.spring4.chap12.store.dao.PurchaseOrderDao;
import net.madvirus.spring4.chap12.store.domain.Item;
import net.madvirus.spring4.chap12.store.domain.ItemNotFoundException;
import net.madvirus.spring4.chap12.store.domain.PaymentInfo;
import net.madvirus.spring4.chap12.store.domain.PurchaseOrder;

import org.springframework.transaction.annotation.Transactional;

public class PlaceOrderServiceAnnotImpl implements PlaceOrderService {

	private ItemDao itemDao;
	private PaymentInfoDao paymentInfoDao;
	private PurchaseOrderDao purchaseOrderDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void setPaymentInfoDao(PaymentInfoDao paymentInformationDao) {
		this.paymentInfoDao = paymentInformationDao;
	}

	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	@Override
	@Transactional
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest)
			throws ItemNotFoundException {
		Item item = itemDao.findById(orderRequest.getItemId());
		if (item == null)
			throw new ItemNotFoundException(orderRequest.getItemId());

		PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
		paymentInfoDao.insert(paymentInfo);

		PurchaseOrder order = new PurchaseOrder(item.getId(), orderRequest
				.getAddress(), paymentInfo.getId());
		purchaseOrderDao.insert(order);

		return new PurchaseOrderResult(item, paymentInfo, order);
	}

}
