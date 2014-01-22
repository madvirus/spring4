package net.madvirus.spring4.chap05;

import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainStockReader {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:stockreader.xml");
		StockReader stockReader = ctx.getBean("stockReader", StockReader.class);
		Date date = new Date();
		printClosePrice(stockReader, date, "0000");
		printClosePrice(stockReader, date, "0000");

		ctx.close();
	}

	private static void printClosePrice(StockReader stockReader, Date date, String string) {
		long before = System.currentTimeMillis();
		int stockPrice = stockReader.getClosePrice(new Date(), "0000");
		long after = System.currentTimeMillis();
		System.out.println("읽어온 값 = " + stockPrice + ", 실행 시간 = " + (after - before));
	}
}
