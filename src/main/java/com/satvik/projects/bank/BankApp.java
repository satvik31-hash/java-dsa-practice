package com.satvik.projects.bank;

import java.util.List;

/** Console walkthrough of the account hierarchy and its checked exceptions. */
public final class BankApp {

    private BankApp() {
    }

    public static void main(String[] args) {
        List<BankAccount> accounts = List.of(
                new SavingsAccount("SB-001", "Satvik", 10_000, 4.5),
                new CurrentAccount("CA-001", "Satvik", 25_000, 2.0));

        for (BankAccount account : accounts) {
            System.out.println(account);
            System.out.printf("  interest: %.2f%n", account.calculateInterest());
        }

        BankAccount savings = accounts.get(0);
        try {
            savings.deposit(2_500);
            System.out.println("After deposit: " + savings);

            savings.withdraw(1_000_000);
        } catch (InsufficientBalanceException | InvalidAmountException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
