package com.interns.bankapplication;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class BankService implements ITransactionService {

	private static long accountIdCounter = 20250401; // Initialize account ID counter

	@Override
	public void addAccount(Account account) {
		acc.put(account.getAccountId(), account);
		System.out.println("Account successfully added for: " + account.getCustomer().getName());
	}

	@Override
	public void deposit(long accountId, double amount) {
		acc.computeIfPresent(accountId, (id, a) -> {
			a.setBalance(a.getBalance() + amount);
			System.out.println(amount + " deposited to account ID: " + accountId);
			return a;
		});
	}

	@Override
	public void withdraw(long accountId, double amount) {
		acc.computeIfPresent(accountId, (id, a) -> {
			if (a.getBalance() >= amount) {
				a.setBalance(a.getBalance() - amount);
				System.out.println(amount + " withdrawn from account ID: " + accountId);
			} else {
				System.out.println("Insufficient balance for account ID: " + accountId);
			}
			return a;
		});
	}

	@Override
	public double checkBalance(long accountId) {
		Account a = acc.get(accountId);
		return a != null ? a.getBalance() : 0.0;
	}

	@Override
	public void showAccountDetails(long accountId) {
		Account a = acc.get(accountId);
		if (a != null) {
			System.out.println(a);
		} else {
			System.out.println("Account not found: " + accountId);
		}
	}

	@Override
	public CompletableFuture<Void> transfer(long fromId, long toId, double amount) {
		return CompletableFuture.runAsync(() -> {
			synchronized (this) {
				if (acc.containsKey(fromId) && acc.containsKey(toId)) {
					withdraw(fromId, amount);
					deposit(toId, amount);
					System.out.println("Transaction Successful: From " + fromId + " to " + toId);
				} else {
					System.out.println("Transaction failed: Invalid account(s).");
				}
			}
		});
	}

	// Method to get next Account ID
	public static long getNextAccountId() {
		return accountIdCounter++;
	}
}
