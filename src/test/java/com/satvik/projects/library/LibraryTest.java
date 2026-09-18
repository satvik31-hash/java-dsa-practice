package com.satvik.projects.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private Book book;
    private Member member;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        book = new Book(1, "Starship", "Elon Musk");
        member = new Member(31, "Hussain Momin");
        transaction = new Transaction();
    }

    @Test
    @DisplayName("a new book starts available")
    void startsAvailable() {
        assertTrue(book.isAvailable());
    }

    @Test
    @DisplayName("borrowing marks the book as on loan")
    void borrowMarksUnavailable() throws Exception {
        transaction.borrow(book, member);
        assertFalse(book.isAvailable());
    }

    @Test
    @DisplayName("borrowing a book already on loan is refused")
    void doubleBorrowIsRefused() throws Exception {
        transaction.borrow(book, member);
        assertThrows(BookUnavailableException.class, () -> transaction.borrow(book, member));
    }

    @Test
    @DisplayName("returning makes the book borrowable again")
    void returnMakesAvailable() throws Exception {
        transaction.borrow(book, member);
        transaction.returnBook(book);
        assertTrue(book.isAvailable());
        transaction.borrow(book, member);
        assertFalse(book.isAvailable());
    }
}
