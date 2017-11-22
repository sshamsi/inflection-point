package com.inflection.point.accounts;

import java.util.logging.Logger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The accounts Spring configuration.
 * 
 * @author Paul Chapman
 */
@Configuration
@ComponentScan
public class AccountsConfiguration {

	protected Logger logger;

	public AccountsConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}


}
