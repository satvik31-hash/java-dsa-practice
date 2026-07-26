package Library;

class Book {

    int bookId;
    String title;
    String author;
    boolean available;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    void displayBook() {
        System.out.println(bookId + " " + title + " " + author + " Available: " + available);
    }

    boolean isAvailable() {
        return available;
    }

    void borrowBook() {
        available = false;
    }

    void returnBook() {
        available = true;
    }
}

class Member {

    int memberId;
    String name;

    Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    void displayMember() {
        System.out.println("Member ID: " + memberId + " Name: " + name);
    }
}
class Transaction {

    void borrow(Book book) {

        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book not available");
        }
    }

    void returnBook(Book book) {

        book.returnBook();
        System.out.println("Book returned successfully");
    }
}
public class Main {

    static void main(String[] args) {

        Book b1 = new Book(1, "SPaceX", " -By Elon Musk");
        Member m1 = new Member(31, "Hussain Momin");

        Transaction t = new Transaction();

        b1.displayBook();
        m1.displayMember();

        t.borrow(b1);
        b1.displayBook();

        t.returnBook(b1);
        b1.displayBook();
    }
}
