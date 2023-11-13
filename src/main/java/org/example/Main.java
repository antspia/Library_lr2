package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Patron patron = new Patron("John Doe", "123");
        Book book = new Book("The Great Gatsby", "001", "F. Scott Fitzgerald");

        library.registerPatron(patron);
        library.add(book);

        library.listAvailable();
        library.lendItem(patron, book);

        System.out.println("Borrowed Items:");
        patron.getBorrowedItems().forEach(item -> System.out.println(item.getTitle()));

        library.listBorrowed();
        library.returnItem(patron, book);

        System.out.println("Available Items:");
        library.listAvailable();
    }
}
