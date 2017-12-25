package com.inflection.point.accounts;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The accounts Spring configuration.
 * 
 * @author Shazeb Shamsi
 */
@Configuration
@ComponentScan
@EntityScan("com.inflection.point.accounts")
@EnableJpaRepositories("com.inflection.point.accounts")
public class AccountsConfiguration {

	protected Logger logger;

	public AccountsConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}
	
	@Bean(name="mysqlDataSource")
	public DataSource mySQLDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername("ipuser");
		dataSource.setPassword("ippass");
		dataSource.setUrl("jdbc:mysql://localhost/accounts");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}


}
