import org.example.Library;
import org.example.Patron;
import org.example.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class LibraryTest {

    @Test
    void testLibraryManagement() {
        Library library = new Library();
        Patron patron = new Patron("John Doe", "123");
        Book book = new Book("The Great Gatsby", "001", "F. Scott Fitzgerald");

        library.registerPatron(patron);
        library.add(book);

        library.listAvailable();
        library.lendItem(patron, book);

        assertTrue(book.isBorrowed());
        assertEquals(1, patron.getBorrowedItems().size());

        library.listBorrowed();
        library.returnItem(patron, book);

        assertFalse(book.isBorrowed());
        assertEquals(0, patron.getBorrowedItems().size());
    }
}