package com.inflection.point.accounts;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 
 * @author Shazeb Shamsi
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
	/**
	 * Find an account with the specified account number.
	 *
	 * @param accountNumber
	 * @return The account if found, null otherwise.
	 */
	public Account findByNumber(String accountNumber);

	/**
	 * Fetch the number of accounts known to the system.
	 * 
	 * @return The number of accounts.
	 */
	@Query("SELECT count(*) from Account")
	public int countAccounts();
}
