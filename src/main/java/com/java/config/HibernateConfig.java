package com.java.config;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Oracle12cDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.java.dto.Account;

@Configuration
// proxyTargetClass:  Repository interface exist, then set to false.
@EnableTransactionManagement(proxyTargetClass = false)
public class HibernateConfig {

	@Bean
	public HibernateTemplate template() throws IOException {
		HibernateTemplate template = new HibernateTemplate();
		template.setSessionFactory(sessionFactory());
		return template;
	}

	@Bean
	public SessionFactory sessionFactory() throws IOException {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setAnnotatedClasses(Account.class);
		factoryBean.setDataSource(datasource());
		Properties p = new Properties();
		p.setProperty(Environment.SHOW_SQL, "true");
//		p.setProperty(Environment.HBM2DDL_AUTO, "create");
		// SPECIFY DIALECT
		p.setProperty(Environment.DIALECT, Oracle12cDialect.class.getName());
		factoryBean.setHibernateProperties(p);
		factoryBean.afterPropertiesSet(); // create ur session factory obj
		return factoryBean.getObject();
	}

	@Bean
	public HibernateTransactionManager transactionManager() throws IOException {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setDataSource(datasource());
		manager.setSessionFactory(sessionFactory());
		return manager;
	}

	@Bean
	public DriverManagerDataSource datasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl2");
		ds.setUsername("sys as sysdba");
		ds.setPassword("Purple2424");
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		return ds;
	}
}
