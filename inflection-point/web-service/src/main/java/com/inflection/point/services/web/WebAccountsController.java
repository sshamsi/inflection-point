package com.inflection.point.services.web;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Client controller, fetches Account info from the microservice via
 * {@link WebAccountsService}.
 * 
 * @author Shazeb Shamsi
 */
@Controller
public class WebAccountsController {

	@Autowired
	protected WebAccountsService accountsService;

	protected Logger logger = Logger.getLogger(WebAccountsController.class
			.getName());

	public WebAccountsController(WebAccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("accountNumber", "searchText");
	}

	@RequestMapping("/accounts")
	public String goHome() {
		return "index";
	}

	@RequestMapping("/accounts/{accountNumber}")
	public String byNumber(Model model,
			@PathVariable("accountNumber") String accountNumber) {

		logger.info("web-service byNumber() invoked: " + accountNumber);

		Account account = accountsService.findByNumber(accountNumber);
		logger.info("web-service byNumber() found: " + account);
		model.addAttribute("account", account);
		return "account";
	}


	
}
