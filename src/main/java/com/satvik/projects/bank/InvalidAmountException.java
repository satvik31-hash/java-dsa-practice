package com.satvik.projects.bank;

/** Raised when a deposit or withdrawal amount is negative. */
public class InvalidAmountException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidAmountException(String message) {
        super(message);
    }
}
