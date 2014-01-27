package net.madvirus.spring4.chap06;

import net.madvirus.spring4.chap06.board.NewArticleRequest;
import net.madvirus.spring4.chap06.board.ReadArticleService;
import net.madvirus.spring4.chap06.board.WriteArticleService;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainQuickStart {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:acQuickStart.xml");
		WriteArticleService writeArticleService = ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest());

		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		readArticleService.read(1);
		readArticleService.read(1);

		ctx.close();
	}
}
