package com.inflection.point.accounts.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.inflection.point.accounts.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@EntityScan("com.inflection.point.accounts")
@EnableJpaRepositories("com.inflection.point.accounts")
public class AccountsIntegrationTest {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	MockMvc mockMvc;
	
	@After
	public void tearDown(){
		accountRepository.deleteAll();
	}

	@Test
	public void findAccountById() throws Exception {
		mockMvc.perform(get("/accounts/1")).andDo(print());
	}
	
}
