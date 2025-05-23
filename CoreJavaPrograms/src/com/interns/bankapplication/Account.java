package com.interns.bankapplication;

public class Account {
	private long accountId;
	private double balance;
	private Customer customer;  

	public Account(long accountId, double balance, Customer customer) {
		this.accountId = accountId;
		this.balance = balance;
		this.customer = customer;
	}

	public long getAccountId() {
		return accountId;
	}

	public double getBalance() {
		return balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account{" + "ID=" + accountId + ", Balance=" + balance + ", Customer=" + customer + '}';
	}
}
