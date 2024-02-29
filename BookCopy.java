
import java.util.Date;

public class BookCopy {
    private String isbn;
    private Status status;
    private Patron borrower;

    public BookCopy(String isbn, Status status, Patron borrower) {
        this.isbn = isbn;
        this.status = status;
        this.borrower = borrower;
    }

    public BookCopy(Book book) {
        //TODO Auto-generated constructor stub
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Additional methods

    @Override
    public String toString() {
        return "BookCopy{" +
                "isbn='" + isbn + '\'' +
                ", status=" + status +
                ", borrower=" + borrower +
                '}';
    }

    public void addBorrowedBook(BookCopy borrowedCopy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBorrowedBook'");
    }

    public void removeBorrowedBook(BookCopy borrowedCopy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeBorrowedBook'");
    }

    public BookID getBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBook'");
    }
}
