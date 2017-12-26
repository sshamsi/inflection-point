package com.inflection.point.accounts.tests;

import org.junit.After;
import org.junit.Test;
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
	
	@After
	public void tearDown(){
		accountRepository.deleteAll();
	}

	@Test
	public void saveAndFetchAccount() {
		Account account = new Account("101", "Shazeb");
		account.setId(2);
		accountRepository.save(account);
		
		System.out.println(" Number of accounts "+accountRepository.count());
	}
	
}
