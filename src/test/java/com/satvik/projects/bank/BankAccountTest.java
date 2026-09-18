package com.satvik.projects.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    private static final double EPSILON = 1e-9;

    @Test
    @DisplayName("deposits and withdrawals move the balance")
    void updatesBalance() throws Exception {
        BankAccount account = new SavingsAccount("SB-1", "Satvik", 1_000, 5);
        account.deposit(500);
        assertEquals(1_500, account.getBalance(), EPSILON);

        account.withdraw(200);
        assertEquals(1_300, account.getBalance(), EPSILON);
    }

    @Test
    @DisplayName("an overdraw is refused and leaves the balance untouched")
    void refusesOverdraw() {
        BankAccount account = new CurrentAccount("CA-1", "Satvik", 100, 2);
        assertThrows(InsufficientBalanceException.class, () -> account.withdraw(101));
        assertEquals(100, account.getBalance(), EPSILON);
    }

    @Test
    @DisplayName("negative amounts are refused on both operations")
    void refusesNegativeAmounts() {
        BankAccount account = new SavingsAccount("SB-2", "Satvik", 100, 2);
        assertThrows(InvalidAmountException.class, () -> account.deposit(-1));
        assertThrows(InvalidAmountException.class, () -> account.withdraw(-1));
        assertEquals(100, account.getBalance(), EPSILON);
    }

    @Test
    @DisplayName("withdrawing the exact balance is allowed")
    void allowsExactWithdrawal() throws Exception {
        BankAccount account = new SavingsAccount("SB-3", "Satvik", 250, 2);
        account.withdraw(250);
        assertEquals(0, account.getBalance(), EPSILON);
    }

    @Test
    @DisplayName("each subclass applies its own interest rate")
    void calculatesInterestPerSubclass() {
        assertEquals(450, new SavingsAccount("SB-4", "Satvik", 10_000, 4.5).calculateInterest(), EPSILON);
        assertEquals(500, new CurrentAccount("CA-4", "Satvik", 25_000, 2.0).calculateInterest(), EPSILON);
    }
}
