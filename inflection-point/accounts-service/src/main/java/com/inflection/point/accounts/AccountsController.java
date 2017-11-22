package com.inflection.point.accounts;

import java.util.logging.Logger;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A RESTFul controller for accessing account information.
 * 
 * @author Paul Chapman
 */
@RestController
public class AccountsController {

	protected Logger logger = Logger.getLogger(AccountsController.class.getName());


	/**
	 * Fetch an account with the specified account number.
	 * 
	 * @param accountNumber
	 *            A numeric, 9 digit account number.
	 * @return The account if found.
	 * @throws AccountNotFoundException
	 *             If the number is not recognised.
	 */
	@RequestMapping("/accounts/{accountNumber}")
	public Account byNumber(@PathVariable("accountNumber") String accountNumber) {

		logger.info("accounts-service byNumber() invoked: " + accountNumber);
		Account account = new Account("100", "Shazeb");
		account.setId(1);
		logger.info("accounts-service byNumber() found: " + account);
		return account;
	}


}
