package org.reverside.bootcamp.ubereats.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"org.reverside.bootcamp.ubereats.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//These are the DBMS configuration variables, change relative to DBMS used
	private final static String DATABASE_URL ="jdbc:h2:tcp://localhost/~/test";
	private final static String DATABASE_DRIVER ="org.h2.Driver";
	private final static String DATABASE_DIALECT ="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME ="sa";
	private final static String DATABASE_PASSWORD =""; //I am not sure if i need a password as yet
	
	//dataSource bean
	@Bean
	public DataSource getDataSource() {
		
		//BasicDataSource comes from dbcp2 which we are using for connection pooling
		BasicDataSource dataSource = new BasicDataSource();
		
		//Providing database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		
		return dataSource;
	}
	
	//SessionFactory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		
		sessionBuilder.addProperties(getHibernateProperties());
		//to avoid writing code for every DTO class I want added here
		sessionBuilder.scanPackages("org.reverside.bootcamp.ubereats.dto");
	
		
		return	sessionBuilder.buildSessionFactory();
		
		
	}
	
	//This method returns all the hibernate properties
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		//"create" creates a table if non-existing and drops one and recreate it if it it exists
		// "update" if you want to update or create only
		properties.put("hibernate.hbm2ddl.auto", "update");
		//additional hibernate properties should go here..
		
		
		return properties;
	}
	
	//HibernateTransactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
		
	}
	
}
