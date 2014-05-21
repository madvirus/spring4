package net.madvirus.spring4.chap13.main;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import net.madvirus.spring4.chap13.store.model.PurchaseOrder;
import net.madvirus.spring4.chap13.store.service.PlaceOrderService;
import net.madvirus.spring4.chap13.store.service.PlaceOrderServiceImpl;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@MapperScan("net.madvirus.spring4.chap13.store.dao")
public class JavaScanConfig {

	@Bean
	public PersistenceExceptionTranslationPostProcessor postProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

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
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		Resource[] mapperLocations = new Resource[2];
		mapperLocations[0] = new ClassPathResource("/mybatis/itemdao.xml");
		mapperLocations[1] = new ClassPathResource("/mybatis/purchaseorderdao.xml");
		factoryBean.setMapperLocations(mapperLocations);
		factoryBean.setTypeAliases(new Class<?>[] { PurchaseOrder.class });
		return factoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory().getObject());
	}

	@Bean
	public PlaceOrderService placeOrderService() throws Exception {
		return new PlaceOrderServiceImpl();
	}
}
