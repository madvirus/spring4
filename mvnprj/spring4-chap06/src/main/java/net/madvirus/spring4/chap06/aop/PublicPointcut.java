package net.madvirus.spring4.chap06.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PublicPointcut {

	@Pointcut("execution(public * net.madvirus.spring4.chap06..*(..))")
	public void publicMethod() {
	}
}
