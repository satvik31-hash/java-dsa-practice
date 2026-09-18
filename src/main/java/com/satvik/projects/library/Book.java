package com.satvik.projects.library;

import java.util.Objects;

/** A single title in the library catalogue. */
public class Book {

    private final int bookId;
    private final String title;
    private final String author;
    private boolean available = true;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = Objects.requireNonNull(title, "title");
        this.author = Objects.requireNonNull(author, "author");
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    void markBorrowed() {
        available = false;
    }

    void markReturned() {
        available = true;
    }

    @Override
    public String toString() {
        return "#%d %s by %s (%s)".formatted(
                bookId, title, author, available ? "available" : "on loan");
    }
}
