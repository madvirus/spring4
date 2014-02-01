package net.madvirus.spring4.chap06.config;

import net.madvirus.spring4.chap06.aop.ArticleCacheAspect;
import net.madvirus.spring4.chap06.aop.ProfilingAspect;
import net.madvirus.spring4.chap06.aop.UpdateMemberInfoTraceAspect;
import net.madvirus.spring4.chap06.board.ArticleDao;
import net.madvirus.spring4.chap06.board.MemoryArticleDao;
import net.madvirus.spring4.chap06.board.ReadArticleServiceImpl;
import net.madvirus.spring4.chap06.board.WriteArticleServiceImpl;
import net.madvirus.spring4.chap06.member.MemberServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class QuickStartConfig {

	@Bean
	public ProfilingAspect performanceTraceAspect() {
		return new ProfilingAspect();
	}

	@Bean
	public UpdateMemberInfoTraceAspect memberInfoTraceAspect() {
		return new UpdateMemberInfoTraceAspect();
	}

	@Bean
	public ArticleDao articleDao() {
		return new MemoryArticleDao();
	}

	@Bean
	public WriteArticleServiceImpl writeArticleService() {
		return new WriteArticleServiceImpl(articleDao());
	}

	@Bean
	public MemberServiceImpl memberService() {
		return new MemberServiceImpl();
	}

	@Bean
	public ArticleCacheAspect cache() {
		return new ArticleCacheAspect();
	}

	@Bean
	public ReadArticleServiceImpl readArticleService() {
		ReadArticleServiceImpl svc = new ReadArticleServiceImpl();
		svc.setArticleDao(articleDao());
		return svc;
	}
}
