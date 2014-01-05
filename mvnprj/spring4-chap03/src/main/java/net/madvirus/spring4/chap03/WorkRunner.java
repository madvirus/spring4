package net.madvirus.spring4.chap03;

import org.springframework.beans.factory.BeanNameAware;

public class WorkRunner implements BeanNameAware {

	private String beanId;

	@Override
	public void setBeanName(String name) {
		this.beanId = name;
	}

	public void execute(Work work) {
		System.out.printf("WorkRunner[%s] execute Work[%d]\n", beanId, work.getOrder());
		work.run();
	}

}
