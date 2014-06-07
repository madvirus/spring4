package net.madvirus.spring4.chap15.conf;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import net.madvirus.spring4.chap15.hr.dao.EmployeeDao;
import net.madvirus.spring4.chap15.hr.dao.JdbcEmployeeDao;
import net.madvirus.spring4.chap15.hr.service.EmployeeRegistryService;
import net.madvirus.spring4.chap15.hr.service.EmployeeRegistryServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class SpringAppConfig {

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
		ds.setJdbcUrl("jdbc:mysql://localhost/hrdb?characterEncoding=utf8");
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
	public EmployeeDao employeeDao() {
		return new JdbcEmployeeDao(dataSource());
	}

	@Bean
	public EmployeeRegistryService employeeRegistryService() {
		EmployeeRegistryServiceImpl regService = new EmployeeRegistryServiceImpl();
		regService.setEmpDao(employeeDao());
		return regService;
	}

}
