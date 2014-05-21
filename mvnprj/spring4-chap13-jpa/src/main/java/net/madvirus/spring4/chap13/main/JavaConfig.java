package net.madvirus.spring4.chap13.main;

import java.beans.PropertyVetoException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import net.madvirus.spring4.chap13.store.domain.ItemRepository;
import net.madvirus.spring4.chap13.store.domain.PaymentInfoRepository;
import net.madvirus.spring4.chap13.store.domain.PurchaseOrderRepository;
import net.madvirus.spring4.chap13.store.persistence.JpaItemRepository;
import net.madvirus.spring4.chap13.store.persistence.JpaPaymentInfoRepository;
import net.madvirus.spring4.chap13.store.persistence.JpaPurchaseOrderRepository;
import net.madvirus.spring4.chap13.store.service.PlaceOrderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class JavaConfig {

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

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setDataSource(dataSource());
		emfBean.setPersistenceUnitName("store");
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		emfBean.setJpaVendorAdapter(jpaVendorAdapter);
		return emfBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emFactory) {
		JpaTransactionManager txMgr = new JpaTransactionManager();
		txMgr.setEntityManagerFactory(emFactory);
		return txMgr;
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
	public ItemRepository itemRepository() {
		JpaItemRepository itemRepository = new JpaItemRepository();
		itemRepository.setEntityManagerFactory(emf().getObject());
		return itemRepository;
	}

	@Bean
	public PaymentInfoRepository paymentInfoRepository() {
		JpaPaymentInfoRepository paymentInfoRepository = new JpaPaymentInfoRepository();
		return paymentInfoRepository;
	}

	@Bean
	public PurchaseOrderRepository purchaseOrderRepository() {
		JpaPurchaseOrderRepository purchaseOrderRepository = new JpaPurchaseOrderRepository();
		return purchaseOrderRepository;
	}
}