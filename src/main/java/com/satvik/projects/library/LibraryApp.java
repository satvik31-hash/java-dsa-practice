package com.satvik.projects.library;

/** Console walkthrough of the library model. */
public final class LibraryApp {

    private LibraryApp() {
    }

    public static void main(String[] args) {
        Book book = new Book(1, "Starship", "Elon Musk");
        Member member = new Member(31, "Hussain Momin");
        Transaction transaction = new Transaction();

        System.out.println(book);
        System.out.println(member);

        try {
            transaction.borrow(book, member);
            System.out.println("Borrowed. " + book);

            transaction.borrow(book, member);
        } catch (BookUnavailableException e) {
            System.out.println("Could not borrow: " + e.getMessage());
        }

        transaction.returnBook(book);
        System.out.println("Returned. " + book);
    }
}
