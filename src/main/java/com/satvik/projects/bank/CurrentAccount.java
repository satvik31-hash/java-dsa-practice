package com.satvik.projects.bank;

/** Current account: interest accrues on the full balance at its own rate. */
public class CurrentAccount extends BankAccount {

    private final double interestRate;

    public CurrentAccount(String accountNumber, String accountHolderName,
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
