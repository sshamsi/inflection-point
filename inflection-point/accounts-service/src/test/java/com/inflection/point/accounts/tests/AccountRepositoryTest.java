package com.inflection.point.accounts.tests;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.inflection.point.accounts.Account;
import com.inflection.point.accounts.AccountRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@EntityScan("com.inflection.point.accounts")
@EnableJpaRepositories("com.inflection.point.accounts")
public class AccountRepositoryTest {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Before
	public void setUp(){
		// create account
		Account account = new Account("101", new BigDecimal(1000));
		account.setId(1);
		account = accountRepository.save(account);
	}
	
	@Test
	public void createAccount() {
		Account account = new Account("102", new BigDecimal(2000));
		account.setId(2);
		account = accountRepository.save(account);
		
		System.out.println(" Number of accounts "+accountRepository.count());
	}
	
	@Test
	public void fetchAccount(){
		Account account = accountRepository.findByNumber("101");
		assertThat(account.getNumber(), is("101"));
	}
	
}
