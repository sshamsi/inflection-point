package com.inflection.point.accounts.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inflection.point.accounts.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@EntityScan("com.inflection.point.accounts")
@EnableJpaRepositories("com.inflection.point.accounts")
public class AccountsIntegrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void findAccountByNumber() throws Exception {
		mockMvc.perform(get("/accounts/101")).andDo(print());
	}
	
	@Test
	public void createAccount() throws Exception{
		Account account = new Account("101", new BigDecimal(1000));
		account.setId(1);
		
		mockMvc.perform(post("/accounts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(account))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
	
}
