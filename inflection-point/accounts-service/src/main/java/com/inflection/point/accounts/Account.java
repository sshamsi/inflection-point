package com.inflection.point.accounts;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Persistent account entity with JPA markup. Accounts are stored in MySQL
 * relational database.
 * 
 * @author Shazeb Shamsi
 */
@Entity
@Table(name = "ip_accounts")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="account_id")
	private Long id;
    
	@Column(name="account_number")
	private String number;

	@Transient
	protected String owner;

	private BigDecimal balance;

	/**
	 * Default constructor for JPA only.
	 */
	protected Account() {
		balance = BigDecimal.ZERO;
	}

	public Account(String number, String owner) {
		this.number = number;
		this.owner = owner;
		balance = BigDecimal.ZERO;
	}

	public long getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	protected void setNumber(String accountNumber) {
		this.number = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	protected void setOwner(String owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void withdraw(BigDecimal amount) {
		balance.subtract(amount);
	}

	public void deposit(BigDecimal amount) {
		balance.add(amount);
	}
	
	@Override
	public String toString() {
		return number + " [" + owner + "]: $" + balance;
	}

}
