package com.inflection.point.accounts.tests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.inflection.point.accounts.AccountsConfiguration;

@SpringBootApplication
@Import(AccountsConfiguration.class)
public class AccountsMain {
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "accounts-server");
		SpringApplication.run(AccountsMain.class, args);
	}
}
