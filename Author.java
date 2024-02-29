
import java.util.ArrayList;
import java.util.Date;

public class Author {
    private String name;
    private Date birthdate;
    private ArrayList<BookID> writtenBooks;

    // Constructors, getters, setters, and toString methods

    public Author(String name, Date birthdate, ArrayList<BookID> writtenBooks) {
        this.name = name;
        this.birthdate = birthdate;
        this.writtenBooks = writtenBooks;
    }

    public Author(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.writtenBooks = new ArrayList<>();
    }

    // Additional methods for manipulating writtenBooks
    public void addWrittenBook(BookID bookID) {
        writtenBooks.add(bookID);
    }

    public void removeWrittenBook(BookID bookID) {
        writtenBooks.remove(bookID);
    }

    public ArrayList<BookID> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(ArrayList<BookID> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }

    public String getName() {
        return name;
    }
}
