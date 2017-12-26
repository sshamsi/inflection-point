package com.inflection.point.accounts.tests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.inflection.point.accounts.Account;
import com.inflection.point.accounts.AccountRepository;
import com.inflection.point.accounts.AccountsController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AccountsController.class)
public class AccountControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AccountRepository accountRepository;
	
	@Test
	public void findAccountById() throws Exception{
		Account account = new Account("100", "Shamsi");
		account.setId(1);
		when(accountRepository.findOne(1L)).thenReturn(account);
		mockMvc.perform(get("/accounts/1")).andDo(print());
	}


}
