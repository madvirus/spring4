package net.madvirus.spring4.chap06;

import net.madvirus.spring4.chap06.board.NewArticleRequest;
import net.madvirus.spring4.chap06.board.ReadArticleService;
import net.madvirus.spring4.chap06.board.WriteArticleService;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainDesignatorTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:designatorTest.xml");
		WriteArticleService writeSvc = ctx.getBean("writeArticleService", WriteArticleService.class);
		writeSvc.write(new NewArticleRequest("writer", "title", "content"));

		ReadArticleService readSvc = ctx.getBean("readArticleService", ReadArticleService.class);
		System.out.println("----- 첫 번째 readSvc.read(1)");
		readSvc.read(1);
		System.out.println("----- 두 번째 readSvc.read(1)");
		readSvc.read(1);

		ctx.close();
	}
}
