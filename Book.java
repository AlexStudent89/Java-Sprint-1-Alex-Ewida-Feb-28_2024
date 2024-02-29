
import java.util.ArrayList;

public class Book implements Borrowable {
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private int numberOfCopies;
    private ArrayList<BookCopy> copies;

    public Book(String title, String author, String isbn, String publisher, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.copies = new ArrayList<>();
        for (int i = 0; i < numberOfCopies; i++) {
            copies.add(new BookCopy(isbn, Status.AVAILABLE, null));
        }
    }

    // Implement methods from Borrowable interface
    @Override
    public void checkout() {
        // Implement checkout logic
    }

    @Override
    public void returnBook() {
        // Implement return logic
    }

    @Override
    public void setOverDue() {
        // Implement overdue logic
    }

    public ArrayList<BookCopy> getCopies() {
        return copies;
    }

    // Getters and setters

    @Override
    public String toString() {
        StringBuilder copiesStr = new StringBuilder("[");
        for (BookCopy copy : copies) {
            copiesStr.append(copy.toString()).append(", ");
        }
        if (!copies.isEmpty()) {
            copiesStr.delete(copiesStr.length() - 2, copiesStr.length()); // Remove the last comma and space
        }
        copiesStr.append("]");

        return "Book{" +
                "title='" + this.title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                ", copies=" + copiesStr +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}
