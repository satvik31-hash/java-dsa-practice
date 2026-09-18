package com.satvik.projects.bank;

/** Savings account: interest accrues on the full balance. */
public class SavingsAccount extends BankAccount {

    private final double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName,
                          double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }
}
