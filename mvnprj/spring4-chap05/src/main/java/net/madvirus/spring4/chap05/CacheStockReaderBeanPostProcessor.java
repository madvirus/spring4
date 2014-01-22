package net.madvirus.spring4.chap05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CacheStockReaderBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (StockReader.class.isAssignableFrom(bean.getClass()))
			return new CacheStockReader((StockReader) bean);
		else
			return bean;
	}

}
