import java.util.ArrayList;

public class Library {
    private ArrayList<Author> authors;
    private ArrayList<BookID> bookIDs;
    private ArrayList<Patron> patrons;

    public Library() {
        this.authors = new ArrayList<>();
        this.bookIDs = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void addBook(Book book) {
        String title = book.getTitle();
        String author = book.getAuthor();
        String isbn = book.getIsbn();

        if (title != null && author != null && isbn != null) {
            bookIDs.add(new BookID(title, author, isbn));
            
            // Assume you also want to add authors if they are not already in the list
            Author authorObj = findAuthor(author);
            if (authorObj == null) {
                authorObj = new Author(author, null); // You might want to modify the Author constructor
                authors.add(authorObj);
            }
            authorObj.addWrittenBook(findBookID(title, author));
            
            // Add book to the library's collection
            // TODO: Implement the logic to add the book to the library
        }
        // Handle the case where title, author, or isbn is null
        else {
            System.out.println("Error: Unable to add book with null title, author, or isbn.");
        }
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // Implement methods to manage books, authors, and patrons

    // Helper methods to find authors, books, and bookIDs
    private Author findAuthor(String authorName) {
        for (Author author : authors) {
            if (author.getName().equals(authorName)) {
                return author;
            }
        }
        return null;
    }

    BookID findBookID(String title, String author) {
        for (BookID bookID : bookIDs) {
            if (bookID.getTitle().equals(title) && bookID.getAuthor().equals(author)) {
                return bookID;
            }
        }
        return null;
    }

    public ArrayList<BookCopy> getBorrowedBooks() {
        ArrayList<BookCopy> borrowedBooks = new ArrayList<>();
    
        for (Patron patron : patrons) {
            borrowedBooks.addAll(patron.getBorrowedBooks());
        }
    
        return borrowedBooks;
    }

    public ArrayList<BookCopy> getReturnedBooks() {
        // TODO: Implement the logic to get returned books
        return new ArrayList<>();
    }

    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    public BookCopy getAvailableCopy(String title) {
        // TODO: Implement the logic to get an available copy by title
        return null;
    }

    public void addToBorrowedBooks(BookCopy borrowedCopy, Patron patron) {
        // TODO: Implement the logic to add to borrowed books
    }

    public void addToReturnedBooks(BookCopy returnedCopy, Patron patron) {
        // TODO: Implement the logic to add to returned books
    }

    public void addToBorrowedBooks(BookCopy borrowedCopy, BookCopy patron) {
        // TODO: Implement the logic to add to borrowed books
    }

    public void addToReturnedBooks(BookCopy returnedCopy, BookCopy patron) {
        // TODO: Implement the logic to add to returned books
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Library Details:\n");
        
        result.append("Authors:\n");
        for (Author author : authors) {
            result.append(author.getName()).append("\n");
        }

        result.append("Books:\n");
        for (BookID bookID : bookIDs) {
            result.append(bookID.getTitle()).append("\n");
        }

        result.append("Patrons:\n");
        for (Patron patron : patrons) {
            result.append(patron).append("\n");
        }

        return result.toString();
    }
}
