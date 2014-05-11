package net.madvirus.spring4.chap13.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import net.madvirus.spring4.chap13.store.service.PlaceOrderService;
import net.madvirus.spring4.chap13.store.service.PurchaseOrderRequest;
import net.madvirus.spring4.chap13.store.service.PurchaseOrderResult;

public class MainByXmlConfigJta {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:/store-jta.xml");

		PlaceOrderService orderService = ctx.getBean(PlaceOrderService.class);
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("주소");

		PurchaseOrderResult orderResult = orderService.order(orderRequest);
		System.out.println(orderResult.getOrder().getId());

		ctx.close();
	}

}
