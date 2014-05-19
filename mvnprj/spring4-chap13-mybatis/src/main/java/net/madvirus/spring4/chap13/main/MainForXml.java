package net.madvirus.spring4.chap13.main;

import net.madvirus.spring4.chap13.store.service.PlaceOrderService;
import net.madvirus.spring4.chap13.store.service.PurchaseOrderRequest;
import net.madvirus.spring4.chap13.store.service.PurchaseOrderResult;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/store.xml");

		PlaceOrderService orderService = ctx.getBean(PlaceOrderService.class);
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("주소");

		PurchaseOrderResult orderResult = orderService.order(orderRequest);
		System.out.println(orderResult.getOrder().getId());

		ctx.close();
	}

}
