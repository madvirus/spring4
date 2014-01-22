package net.madvirus.spring4.chap05;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ThresholdRequiedBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private int defaultThreshold;

	public void setDefaultThreshold(int defaultThreshold) {
		this.defaultThreshold = defaultThreshold;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (String name : beanNames) {
			BeanDefinition beanDef = beanFactory.getBeanDefinition(name);
			Class<?> beanClass = getClassFromBeanDef(beanDef);
			if (beanClass != null && ThresholdRequired.class.isAssignableFrom(beanClass)) {
				MutablePropertyValues prop = beanDef.getPropertyValues();
				if (!prop.contains("threshold")) {
					prop.add("threshold", defaultThreshold);
				}
			}
		}
	}

	private Class<?> getClassFromBeanDef(BeanDefinition beanDef) {
		System.out.println(beanDef.toString());
		if (beanDef.getBeanClassName() == null)
			return null;
		try {
			return Class.forName(beanDef.getBeanClassName());
		} catch (ClassNotFoundException e) {
			throw new FatalBeanException(e.getMessage(), e);
		}
	}

}
