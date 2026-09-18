package com.satvik.projects.library;

/**
 * Borrowing and returning.
 *
 * <p>The methods change state and signal failure by exception rather than printing, so
 * the rules can be tested without capturing console output.
 */
public class Transaction {

    /** @throws BookUnavailableException if the book is already on loan */
    public void borrow(Book book, Member member) throws BookUnavailableException {
        if (!book.isAvailable()) {
            throw new BookUnavailableException(
                    "\"%s\" is already on loan".formatted(book.getTitle()));
        }
        book.markBorrowed();
    }

    public void returnBook(Book book) {
        book.markReturned();
    }
}
