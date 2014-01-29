package net.madvirus.spring4.chap06.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import net.madvirus.spring4.chap06.board.Article;

@Aspect
public class ArticleCacheAspect {

	private Map<Integer, Article> cache = new HashMap<Integer, Article>();

	@Around("execution(public * *..ReadArticleService.*(..))")
	public Article cache(ProceedingJoinPoint joinPoint) throws Throwable {
		Integer id = (Integer) joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if (article != null) {
			System.out.println("[ACA] 캐시에서 Article[" + id + "] 구함");
			return article;
		}
		Article ret = (Article) joinPoint.proceed();
		if (ret != null) {
			cache.put(id, ret);
			System.out.println("[ACA] 캐시에 Article[" + id + "] 추가함");
		}
		return ret;
	}
}
