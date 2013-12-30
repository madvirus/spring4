package net.madvirus.spring4.chap02.main;

import net.madvirus.spring4.chap02.conf.ConfigShop;
import net.madvirus.spring4.chap02.search.SearchClientFactory;
import net.madvirus.spring4.chap02.search.SearchServiceHealthChecker;
import net.madvirus.spring4.chap02.shop.OrderInfo;
import net.madvirus.spring4.chap02.shop.OrderService;
import net.madvirus.spring4.chap02.shop.ProductInfo;
import net.madvirus.spring4.chap02.shop.ProductService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForShop {

	public static void main(String[] args) {
		runByUsingXmlConfig();
		runByUsingJavaConfig();
	}

	private static void runByUsingXmlConfig() {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-shop.xml");
		useBean(ctx);
		ctx.close();
	}

	private static void useBean(ApplicationContext ctx) {
		ProductService productService = ctx.getBean(ProductService.class);
		productService.createProduct(new ProductInfo());

		OrderService orderService = ctx.getBean(OrderService.class);
		orderService.order(new OrderInfo());

		SearchClientFactory orderSearchClientFactory = ctx.getBean("orderSearchClientFactory", SearchClientFactory.class);
		System.out.println(orderSearchClientFactory);
		
		SearchServiceHealthChecker healthChecker = ctx.getBean("searchServiceHealthChecker", SearchServiceHealthChecker.class);
		healthChecker.check();
	}

	private static void runByUsingJavaConfig() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(ConfigShop.class);
		useBean(ctx);
		ctx.close();
	}

}
