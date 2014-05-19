package net.madvirus.spring4.chap13.main;

import net.madvirus.spring4.chap13.store.domain.Item;
import net.madvirus.spring4.chap13.store.domain.ItemRepository;
import net.madvirus.spring4.chap13.store.domain.PaymentInfo;
import net.madvirus.spring4.chap13.store.domain.PaymentInfoRepository;
import net.madvirus.spring4.chap13.store.domain.PurchaseOrder;
import net.madvirus.spring4.chap13.store.domain.PurchaseOrderRepository;
import net.madvirus.spring4.chap13.store.service.PlaceOrderService;
import net.madvirus.spring4.chap13.store.service.PurchaseOrderRequest;
import net.madvirus.spring4.chap13.store.service.PurchaseOrderResult;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/store.xml");

		PaymentInfoRepository piDao = ctx.getBean(PaymentInfoRepository.class);
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setPrice(1000);
		piDao.save(paymentInfo);
		System.out.println(paymentInfo.getId());
//		PurchaseOrderRepository poDao = ctx.getBean(PurchaseOrderRepository.class);
//		PurchaseOrder order = new PurchaseOrder();
//		order.setAddress("주소");
//		order.setItemId(1);
//		order.setPaymentInfoId(10);
//		poDao.save(order);
//		System.out.println(order.getId());
//		PlaceOrderService orderService = ctx.getBean(PlaceOrderService.class);
//		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
//		orderRequest.setItemId(1);
//		orderRequest.setAddress("주소");
//
//		PurchaseOrderResult orderResult = orderService.order(orderRequest);
//		System.out.println(orderResult.getOrder().getId());

		ctx.close();
	}

}

