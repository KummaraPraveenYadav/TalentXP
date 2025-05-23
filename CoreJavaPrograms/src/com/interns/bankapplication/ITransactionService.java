package com.interns.bankapplication;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public interface ITransactionService {
	void addAccount(Account account);
	void deposit(long accountId, double amount);

	void withdraw(long accountId, double amount);

	double checkBalance(long accountId);

	void showAccountDetails(long accountId);

	CompletableFuture<Void> transfer(long fromId, long toId, double amount);
	final Map<Long, Account> acc = new ConcurrentHashMap<>();


	default void normalmsg() {
		System.out
				.println("Welcome User......\n" + "SAFETY FIRST BANKING NEXT.......!\n" + "BANKING IN YOUR POCKET...!!!");
	}

	
}
