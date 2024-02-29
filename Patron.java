
import java.util.ArrayList;

public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<BookCopy> borrowedBooks;

    // Constructors

    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<BookCopy> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<BookCopy> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    // Additional method for adding a borrowed book
    public void addBorrowedBook(BookCopy copy) {
        borrowedBooks.add(copy);
    }

    // Additional method for removing a borrowed book
    public void removeBorrowedBook(BookCopy copy) {
        borrowedBooks.remove(copy);
    }

    // Additional method for clearing all borrowed books
    public void clearBorrowedBooks() {
        borrowedBooks.clear();
    }

    // toString method

    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
