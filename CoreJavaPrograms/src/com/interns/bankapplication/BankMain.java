package com.interns.bankapplication;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankMain {
    public static void main(String[] args) {
        BankService service = new BankService();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Add Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Show Account Details");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume leftover newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear buffer
                continue;
            }

            switch (choice) {
                case 1 -> { // Add Account
                    try {
                        System.out.print("Customer ID: ");
                        long cid = sc.nextLong();
                        sc.nextLine(); // consume newline

                        System.out.print("Customer Name: ");
                        String cname = sc.nextLine();

                        System.out.print("Customer Email: ");
                        String email = sc.nextLine();

                        System.out.print("Customer Phone: ");
                        String phone = sc.nextLine();

                        System.out.print("Initial Balance: ");
                        double bal = sc.nextDouble();
                        sc.nextLine(); // consume newline

                        long accId = BankService.getNextAccountId();  // Get the next Account ID
                        Customer customer = new Customer(cid, cname, email, phone);
                        Account account = new Account(accId, bal, customer);

                        executor.submit(() -> {
                            service.addAccount(account);
                            System.out.println("Account created with ID: " + accId);
                        });
                    } catch (Exception e) {
                        System.out.println("Invalid input. Try again.");
                        sc.nextLine(); // clear buffer
                    }
                }

                // Other cases for Deposit, Withdraw, Check Balance, Transfer, Show Account Details, Exit

                case 7 -> { // Exit
                    executor.shutdown();
                    sc.close();
                    System.out.println("Thank you for using the Banking System.");
                    return;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
