package Practice;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String message) {
        super(message);
    }
}

abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) throws InvalidAmountException {
        if (amount < 0) throw new InvalidAmountException("Deposit amount cannot be negative.");
        balance += amount;
        System.out.println("Successfully deposited $" + amount + ". New balance: $" + balance);
    }

    void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if (amount < 0) throw new InvalidAmountException("Withdrawal amount cannot be negative.");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance. Current: $" + balance);
        balance -= amount;
        System.out.println("Successfully withdrew $" + amount + ". New balance: $" + balance);
    }

    double getBalance() { return balance; }

    abstract void calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println(accountHolderName + "'s Savings Account Interest: $" + interest);
    }
}

class CurrentAccount extends BankAccount {
    private double interestRate;

    CurrentAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println(accountHolderName + "'s Current Account Interest: $" + interest);
    }
}