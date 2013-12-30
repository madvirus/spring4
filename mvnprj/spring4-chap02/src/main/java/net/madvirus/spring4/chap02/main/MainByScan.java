package net.madvirus.spring4.chap02.main;

import net.madvirus.spring4.chap02.conf.ConfigScan;
import net.madvirus.spring4.chap02.shop.OrderInfo;
import net.madvirus.spring4.chap02.shop.OrderService;
import net.madvirus.spring4.chap02.shop.ProductInfo;
import net.madvirus.spring4.chap02.shop.ProductService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByScan {

	public static void main(String[] args) {
		useXmlWithScan();
		useJavaWithScan();
	}

	private static void useXmlWithScan() {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-with-scan.xml");
		useContext(ctx);
		ctx.close();
	}

	private static void useJavaWithScan() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(ConfigScan.class);
		useContext(ctx);
		ctx.close();

	}

	private static void useContext(ApplicationContext ctx) {
		ProductService productService = ctx.getBean("productService", ProductService.class);
		productService.createProduct(new ProductInfo());

		OrderService orderService = ctx.getBean("orderSvc", OrderService.class);
		orderService.order(new OrderInfo());
	}

}
