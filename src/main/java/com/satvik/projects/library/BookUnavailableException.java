package com.satvik.projects.library;

/** Raised when a book that is already on loan is borrowed again. */
public class BookUnavailableException extends Exception {

    private static final long serialVersionUID = 1L;

    public BookUnavailableException(String message) {
        super(message);
    }
}
