package net.madvirus.spring4.chap13.main;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import net.madvirus.spring4.chap13.store.domain.Item;
import net.madvirus.spring4.chap13.store.domain.PaymentInfo;
import net.madvirus.spring4.chap13.store.domain.PurchaseOrder;
import net.madvirus.spring4.chap13.store.persistence.HibernateItemRepository;
import net.madvirus.spring4.chap13.store.persistence.HibernatePaymentInfoRepository;
import net.madvirus.spring4.chap13.store.persistence.HibernatePurchaseOrderRepository;
import net.madvirus.spring4.chap13.store.service.PlaceOrderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class JavaConfigAnnotationMapping implements TransactionManagementConfigurer {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		ds.setJdbcUrl("jdbc:mysql://localhost/shop?characterEncoding=utf8");
		ds.setUser("spring4");
		ds.setPassword("spring4");
		return ds;
	}

	@Override
	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(sessionFactoryBean().getObject());
		return txMgr;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setAnnotatedClasses(Item.class, PaymentInfo.class, PurchaseOrder.class);
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		sessionFactoryBean.setHibernateProperties(prop);
		return sessionFactoryBean;
	}

	@Bean
	public PlaceOrderServiceImpl placeOrderService() {
		PlaceOrderServiceImpl service = new PlaceOrderServiceImpl();
		service.setItemRepository(itemRepository());
		service.setPaymentInfoRepository(paymentInfoRepository());
		service.setPurchaseOrderRepository(purchaseOrderRepository());
		return service;
	}

	@Bean
	public HibernateItemRepository itemRepository() {
		HibernateItemRepository itemRepository = new HibernateItemRepository();
		itemRepository.setSessionFactory(sessionFactoryBean().getObject());
		return itemRepository;
	}

	@Bean
	public HibernatePaymentInfoRepository paymentInfoRepository() {
		HibernatePaymentInfoRepository paymentInfoRepository = new HibernatePaymentInfoRepository();
		paymentInfoRepository.setSessionFactory(sessionFactoryBean().getObject());
		return paymentInfoRepository;
	}

	@Bean
	public HibernatePurchaseOrderRepository purchaseOrderRepository() {
		HibernatePurchaseOrderRepository purchaseOrderRepository = new HibernatePurchaseOrderRepository();
		purchaseOrderRepository.setSessionFactory(sessionFactoryBean().getObject());
		return purchaseOrderRepository;
	}
}