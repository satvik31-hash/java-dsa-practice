package com.satvik.projects.bank;

/**
 * Base account.
 *
 * <p>Interest is left abstract so each account type supplies its own rule — the
 * textbook use of an abstract class over an interface, since the balance handling is
 * shared state rather than pure behaviour.
 */
public abstract class BankAccount {

    private final String accountNumber;
    private final String accountHolderName;
    private double balance;

    protected BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    /** @throws InvalidAmountException if {@code amount} is negative */
    public void deposit(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Deposit amount cannot be negative");
        }
        balance += amount;
    }

    /**
     * @throws InvalidAmountException       if {@code amount} is negative
     * @throws InsufficientBalanceException if {@code amount} exceeds the balance
     */
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount < 0) {
            throw new InvalidAmountException("Withdrawal amount cannot be negative");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance. Current: %.2f".formatted(balance));
        }
        balance -= amount;
    }

    /** @return the interest this account earns on its current balance */
    public abstract double calculateInterest();

    @Override
    public String toString() {
        return "%s [%s] balance %.2f".formatted(accountHolderName, accountNumber, balance);
    }
}
