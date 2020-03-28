package com.multdatasrc.demo.dbConfig;




import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
 entityManagerFactoryRef="entityManagerFactory1",
 basePackages=("com.multdatasrc.demo.model.user.repo"),
 transactionManagerRef="userTransactionManager")
public class UserDBConfig {

	@Primary
	@Bean(name="datasource1")
	@ConfigurationProperties(prefix="spring.user.datasource")
	public DataSource datasource(){
	return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name="entityManagerFactory1")
	public LocalContainerEntityManagerFactoryBean localContainerEntityFactoryBean(
		EntityManagerFactoryBuilder builder,@Qualifier("datasource1")DataSource dataSource){
	
	Map<String,Object> properties=new HashMap<>();
	properties.put("hibernate.hbm2ddl.auto","update");
	properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
	
	return builder.dataSource(dataSource).properties(properties).
				packages("com.multdatasrc.demo.model.user").persistenceUnit("User").build(); 
 	}
	
	@Primary
	@Bean(name="userTransactionManager")
	public PlatformTransactionManager transctionManager(
			@Qualifier("entityManagerFactory1")EntityManagerFactory entityManagerFactory){
	
	return new JpaTransactionManager(entityManagerFactory);
	}
}
