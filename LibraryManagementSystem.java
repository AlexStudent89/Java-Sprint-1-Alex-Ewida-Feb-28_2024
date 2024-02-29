import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Manually add 10 books, 10 authors, and 10 patrons
        addBooksAndAuthors(library);
        addPatrons(library);

        // Simulate borrowing and returning books
        simulateBorrowingAndReturning(library);

        // Print library details
        System.out.println("Library Details:");
        System.out.println(library);

        // Print the list of borrowed books and returned books
        System.out.println("\nList of Borrowed Books:");
        printBooks(library.getBorrowedBooks());

        System.out.println("\nList of Returned Books:");
        printBooks(library.getReturnedBooks());
    }

    private static void addBooksAndAuthors(Library library) {
        // Manually add 10 books
        library.addBook(new Book("Magic Kingdom for Sale/Sold", "Terry Brooks", "ISBN_A", "Publisher_A", 5));
        library.addBook(new Book("A Spell for Chameleon", "Piers Anthony", "ISBN_B", "Publisher_B", 3));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "ISBN_C", "Publisher_C", 7));
        library.addBook(new Book("Pirate's Prophecy", "Chris A. Jackson", "ISBN_D", "Publisher_D", 2));
        library.addBook(new Book("The Phoenix Unchained", "Mercedes Lackey", "ISBN_E", "Publisher_E", 6));
        library.addBook(new Book("Quag Keep", "Andre Norton", "ISBN_F", "Publisher_F", 4));
        library.addBook(new Book("Restaurant to Another World", "Junpei Inuzuka", "ISBN_G", "Publisher_G", 8));
        library.addBook(new Book("Dragon Mage", "M.L. Spencer", "ISBN_H", "Publisher_H", 1));
        library.addBook(new Book("The BFG", "Roald Dahl", "ISBN_I", "Publisher_I", 9));
        library.addBook(new Book("The Golden Compass", "Philip Pullman", "ISBN_J", "Publisher_J", 10));

        // Manually add 10 authors
        addAuthor(library, "Terry Brooks", "Jan_1, 1952");
        addAuthor(library, "Piers Anthony", "Feb_2, 1934");
        addAuthor(library, "J.R.R. Tolkien", "Mar_3, 1892");
        addAuthor(library, "Chris A. Jackson", "Apr_4, 1968");
        addAuthor(library, "Mercedes Lackey", "May_5, 1950");
        addAuthor(library, "Andre Norton", "Jun_6, 1912");
        addAuthor(library, "Junpei Inuzuka", "Jul_7, 1988");
        addAuthor(library, "M.L. Spencer", "Aug_8, 1974");
        addAuthor(library, "Roald Dahl", "Sep_9, 1916");
        addAuthor(library, "Philip Pullman", "Oct_10, 1946");
    }

    private static void addAuthor(Library library, String name, String dob) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM_d, yyyy", Locale.ENGLISH);
        Date birthdate;
        try {
            birthdate = dateFormat.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
            birthdate = new Date(); // Default to the current date
        }

        Author author = new Author(name, birthdate);
        library.addAuthor(author);
    }

    private static void addPatrons(Library library) {
        // Manually add 10 patrons
        library.addPatron(new Patron("Oakley Lamb", "Address_A", "PhoneNumber_A"));
        library.addPatron(new Patron("Amaia Peterson", "Address_B", "PhoneNumber_B"));
        library.addPatron(new Patron("Ariyah McGee", "Address_C", "PhoneNumber_C"));
        library.addPatron(new Patron("Liv Clarke", "Address_D", "PhoneNumber_D"));
        library.addPatron(new Patron("Davion Friedman", "Address_E", "PhoneNumber_E"));
        library.addPatron(new Patron("Jayda Esquivel", "Address_F", "PhoneNumber_F"));
        library.addPatron(new Patron("Mccoy Chen", "Address_G", "PhoneNumber_G"));
        library.addPatron(new Patron("Emmie Hopkins", "Address_H", "PhoneNumber_H"));
        library.addPatron(new Patron("Kobe Lloyd", "Address_I", "PhoneNumber_I"));
        library.addPatron(new Patron("Raya Hess", "Address_J", "PhoneNumber_J"));
    }

    private static void simulateBorrowingAndReturning(Library library) {
        // Borrowing and returning books for the patrons
        int numPatrons = library.getPatrons().size();

        for (int i = 0; i < 5 && i < numPatrons; i++) {
            Patron patron = library.getPatrons().get(i);
            BookCopy borrowedCopy = library.getAvailableCopy("Magic Kingdom for Sale/Sold"); // Adjust the book title as needed

            if (borrowedCopy != null) {
                patron.addBorrowedBook(borrowedCopy);
                borrowedCopy.setStatus(Status.CHECKED_OUT);
                library.addToBorrowedBooks(borrowedCopy, patron);

                // Simulate returning the book after some time
                borrowedCopy.setStatus(Status.AVAILABLE);
                library.addToReturnedBooks(borrowedCopy, patron);
                patron.removeBorrowedBook(borrowedCopy);
            }
        }
    }

    private static void printBooks(ArrayList<BookCopy> books) {
        for (BookCopy bookCopy : books) {
            System.out.println(bookCopy);
        }
    }
}