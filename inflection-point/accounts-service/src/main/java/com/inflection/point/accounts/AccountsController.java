package com.inflection.point.accounts;

import java.util.logging.Logger;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * A RESTFul controller for accessing account information.
 * 
 * @author Shazeb Shamsi
 */
@RestController
public class AccountsController {

	protected Logger logger = Logger.getLogger(AccountsController.class
			.getName());
	
	protected AccountRepository accountRepository;
	
	/**
	 * Create an instance plugging in the repository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public AccountsController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;

		logger.info("AccountRepository says system has "
				+ accountRepository.countAccounts() + " accounts");
	}


	/**
	 * Fetch an account with the specified account number.
	 * 
	 * @param accountNumber
	 *            A numeric, 9 digit account number.
	 * @return The account if found.
	 * @throws AccountNotFoundException
	 *             If the number is not recognised.
	 */
	@RequestMapping("/accounts/{Number}")
	public Account byNumber(@PathVariable("Number") String accountNumber) {

		logger.info("accounts-service byNumber() invoked: " + accountNumber);
		Account account = accountRepository.findByNumber(accountNumber);
		logger.info("accounts-service byNumber() found: " + account);
		return account;
	}
	
	@RequestMapping(method = RequestMethod.POST, headers="Accept=application/json")
	public void create(@RequestBody Account account){
		logger.info("Creating account");
		accountRepository.save(account);
		logger.info("Created account");
	}
	
	


}
