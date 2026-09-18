package com.satvik.projects.bank;

/** Raised when a withdrawal exceeds the available balance. */
public class InsufficientBalanceException extends Exception {

    private static final long serialVersionUID = 1L;

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
