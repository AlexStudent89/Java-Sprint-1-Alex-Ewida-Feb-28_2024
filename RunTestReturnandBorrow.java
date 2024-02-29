
import java.util.ArrayList;

public class RunTestReturnandBorrow {
    public static void main(String[] args) {
        Library library = new Library();

        // Manually add books, authors, and patrons
        addBooksAndAuthors(library);
        addPatrons(library);

        // Simulate borrowing and returning books
        simulateBorrowingAndReturning(library);

        // Print the list of borrowed books and returned books
        System.out.println("List of Borrowed Books:");
        printBooks(library.getBorrowedBooks());

        System.out.println("\nList of Returned Books:");
        printBooks(library.getReturnedBooks());
    }

    private static void addBooksAndAuthors(Library library) {
        // Manually add books
        library.addBook(new Book("Magic Kingdom for Sale/Sold", "Terry Brooks", "ISBN_A", "Publisher_A", 5));
        
    }

    private static void addPatrons(Library library) {
        // Manually add patrons
        library.addPatron(new Patron("Oakley Lamb", "Address_A", "PhoneNumber_A"));
        
    }

    private static void simulateBorrowingAndReturning(Library library) {
        // Manually add books, authors, and patrons
        addBooksAndAuthors(library);
        addPatrons(library);
    
        // Borrowing and returning specific books for the patrons
        // Note: Adjust the book titles as needed
        BookCopy borrowedCopy = library.getAvailableCopy("Magic Kingdom for Sale/Sold");
        BookCopy returnedCopy = library.getAvailableCopy("A Spell for Chameleon");
    
        int numPatrons = library.getPatrons().size();
    
        for (int i = 0; i < 5 && i < numPatrons; i++) {
            Patron patron = library.getPatrons().get(i);
    
            // Borrowing
            if (borrowedCopy != null) {
                patron.addBorrowedBook(borrowedCopy);
                borrowedCopy.setStatus(Status.CHECKED_OUT);
                library.addToBorrowedBooks(borrowedCopy, patron);
            }
    
            // Returning after some time
            if (returnedCopy != null) {
                borrowedCopy.setStatus(Status.AVAILABLE);
                library.addToReturnedBooks(returnedCopy, patron);
                patron.removeBorrowedBook(returnedCopy);
            }
        }
    }

    private static void printBooks(ArrayList<BookCopy> books) {
        for (BookCopy bookCopy : books) {
            System.out.println(bookCopy);
        }
    }
}
