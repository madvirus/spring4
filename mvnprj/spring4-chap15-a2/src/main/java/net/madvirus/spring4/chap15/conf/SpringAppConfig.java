package net.madvirus.spring4.chap15.conf;

import java.beans.PropertyVetoException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import net.madvirus.spring4.chap15.member.application.ChangePasswordService;
import net.madvirus.spring4.chap15.member.application.ChangePasswordServiceImpl;
import net.madvirus.spring4.chap15.member.application.NewMemberRegService;
import net.madvirus.spring4.chap15.member.application.NewMemberRegServiceImpl;
import net.madvirus.spring4.chap15.member.web.DataLoader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "net.madvirus.spring4.chap15.member.domain")
public class SpringAppConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		ds.setJdbcUrl("jdbc:mysql://localhost/memberdb?characterEncoding=utf8");
		ds.setUser("spring4");
		ds.setPassword("spring4");
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(emf);
		return tm;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("net.madvirus.spring4.chap15.member.domain");
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		emf.setJpaVendorAdapter(adapter);
		return emf;
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordServiceImpl service = new ChangePasswordServiceImpl();
		return service;
	}

	@Bean
	public NewMemberRegService newMemberRegService() {
		return new NewMemberRegServiceImpl();
	}

	@Bean
	public DataLoader dataLoader() {
		DataLoader dataLoader = new DataLoader();
		return dataLoader;
	}

}
