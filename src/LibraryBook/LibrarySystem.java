package LibraryBook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class LibrarySystem {
	/*private static final int userIndex =0;
	Book[] books;
    User[] users;
    int numBooks;
    int numUsers;

   

	    public LibrarySystem() {
	        books = new Book[100]; // assume max 100 books
	        users = new User[100]; // assume max 100 users
	        for (int i = 0; i < 100; i++) {
	            users[i] = new User("", 0, false); // initialize with default values
	        }
	        users[userIndex].borrowedBooks = new Book[10]; // initialize borrowedBooks array
	        for (int j = 0; j < 10; j++) {
	            users[userIndex].borrowedBooks[j] = new Book("", "", "", "", true); // initialize Book object
	        }
	        numBooks = 0;
	        numUsers = 0;
	    }

	    public void run() {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("1. Add new book");
	            System.out.println("2. Remove book");
	            System.out.println("3. Update book information");
	            System.out.println("4. Display book details");
	            System.out.println("5. Register new user");
	            System.out.println("6. Login");
	            System.out.println("7. View borrowing history");
	            System.out.println("8. Borrow book");
	            System.out.println("9. Return book");
	            System.out.println("10. Search for book by title or author");
	            System.out.println("11. View available books");
	            System.out.println("12. Exit");

	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    addNewBook(scanner);
	                    break;
	                case 2:
	                    removeBook(scanner);
	                    break;
	                case 3:
	                    updateBookInformation(scanner);
	                    break;
	                case 4:
	                    displayBookDetails(scanner);
	                    break;
	                case 5:
	                    registerNewUser(scanner);
	                    break;
	                case 6:
	                    login(scanner);
	                    break;
	                case 7:
	                    viewBorrowingHistory(scanner);
	                    break;
	                case 8:
	                    borrowBook(scanner);
	                    break;
	                case 9:
	                    returnBook(scanner);
	                    break;
	                case 10:
	                    searchForBook(scanner);
	                    break;
	                case 11:
	                    viewAvailableBooks();
	                    break;
	                case 12:
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }

	    private void addNewBook(Scanner scanner) {
	        System.out.println("Enter title:");
	        String title = scanner.next();
	        System.out.println("Enter author:");
	        String author = scanner.next();
	        System.out.println("Enter ISBN:");
	        String isbn = scanner.next();
	        System.out.println("Enter genre:");
	        String genre = scanner.next();

	        Book book = new Book(title, author, isbn, genre, true);
	        books[numBooks++] = book;
	        System.out.println("Book added successfully!");
	    }

	    private void removeBook(Scanner scanner) {
	        System.out.println("Enter ISBN of book to remove:");
	        String isbn = scanner.next();

	        for (int i = 0; i < numBooks; i++) {
	            if (books[i].getIsbn().equals(isbn)) {
	                books[i] = null;
	                numBooks--;
	                System.out.println("Book removed successfully!");
	                return;
	            }
	        }

	        System.out.println("Book not found!");
	    }

	    private void updateBookInformation(Scanner scanner) {
	        System.out.println("Enter ISBN of book to update:");
	        String isbn = scanner.next();

	        for (int i = 0; i < numBooks; i++) {
	            if (books[i].getIsbn().equals(isbn)) {
	                System.out.println("Enter new title:");
	                String title = scanner.next();
	                System.out.println("Enter new author:");
	                String author = scanner.next();
	                System.out.println("Enter newgenre:");
	                String genre = scanner.next();

	                books[i] = new Book(title, author, isbn, genre, books[i].availability);
	                System.out.println("Book information updated successfully!");
	                return;
	            }
	        }

	        System.out.println("Book not found!");
	    }

	    private void displayBookDetails(Scanner scanner) {
	        System.out.println("Enter ISBN of book to display details:");
	        String isbn = scanner.next();

	        for (int i = 0; i < numBooks; i++) {
	            if (books[i].getIsbn().equals(isbn)) {
	                books[i].displayBookDetails();
	                return;
	            }
	        }

	        System.out.println("Book not found!");
	    }

	    private void registerNewUser(Scanner scanner) {
	        System.out.println("Enter name:");
	        String name = scanner.next();
	        System.out.println("Enter ID:");
	        int id = scanner.nextInt();
	        System.out.println("Enter membership status (true or false):");
	        boolean membershipStatus = scanner.nextBoolean();

	        User user = new User(name, id, membershipStatus);
	        user.borrowedBooks = new Book[10];
	 
	        for (int j = 0; j < 10; j++) {
	            user.borrowedBooks[j] = null; // initialize with null
	        users[numUsers++] = user;
	        System.out.println("User registered successfully!");
	    }
	    }
	    private void login(Scanner scanner) {
	        System.out.println("Enter ID:");
	        int id = scanner.nextInt();

	        for (int i = 0; i < numUsers; i++) {
	            if (users[i].getId() == id) {
	                System.out.println("Login successful!");
	                runUserSession(i);
	                return;
	            }
	        }

	        System.out.println("User not found!");
	    }

	    private void runUserSession(int userIndex) {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("1. View borrowing history");
	            System.out.println("2. Borrow book");
	            System.out.println("3. Return book");
	            System.out.println("4. Logout");

	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    viewBorrowingHistory(scanner);
	                    break;
	                case 2:
	                    borrowBook(scanner);
	                    break;
	                case 3:
	                    returnBook(scanner);
	                    break;
	                case 4:
	                    return;
	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }

	    private void viewBorrowingHistory(Scanner scanner) {
	        // Assuming we are currently in a user session, userIndex will be the index of the current user
	        System.out.println("Borrowing history:");
	        for (Book borrowedBook : users[userIndex].borrowedBooks) {
	            if (borrowedBook != null) {
	                borrowedBook.displayBookDetails();
	            }
	        }
	    }

	    private void borrowBook(Scanner scanner) {
	        System.out.println("Enter ISBN of book to borrow:");
	        String isbn = scanner.next();

	        for (int i = 0; i < numBooks; i++) {
	            if (books[i].getIsbn().equals(isbn) && books[i].availability) {
	                System.out.println("Book borrowed successfully!");
	                users[i].borrowedBooks[users[i].borrowedBooks.length - 1] = books[i];
	                books[i].availability = false;
	                return;
	            }
	        }

	        System.out.println("Book not found or not available!");
	    }

	    private void returnBook(Scanner scanner) {
	        System.out.println("Enter ISBN of book to return:");
	        String isbn = scanner.next();

	        for (int i = 0; i < numBooks; i++) {
	            if (books[i].isbn.equals(isbn) &&!books[i].availability) {
	                System.out.println("Book returned successfully!");
	                for (int j = 0; j < users[userIndex].borrowedBooks.length; j++) {
	                    if (users[userIndex].borrowedBooks[j]!= null && users[userIndex].borrowedBooks[j].isbn.equals(isbn)) {
	                        users[userIndex].borrowedBooks[j] = null;
	                        break;
	                    }
	                }
	                books[i].availability = true;
	                return;

	            }
	        }

	        System.out.println("Book not found or already available!");
	    }

	    private void searchForBook(Scanner scanner) {
	        System.out.println("Enter title or author to search for:");
	        String query = scanner.next();

	        for (int i = 0; i < numBooks; i++) {
	            if (books[i].getTitle().contains(query) || books[i].getAuthor().contains(query)) {
	                books[i].displayBookDetails();
	            }
	        }
	    }

	    private void viewAvailableBooks() {
	        System.out.println("Available books:");
	        for (int i = 0; i < numBooks; i++) {
	            if (books[i].availability) {
	                books[i].displayBookDetails();
	            }
	        }
	    }*/

	   
	Book[] books;
    User[] users;
    int numBooks;
    int numUsers;
	private int userIndex;

    public LibrarySystem() {
        books = new Book[100]; // assume max 100 books
        users = new User[100]; // assume max 100 users
        numBooks = 0;
        numUsers = 0;
    }

    public void run() throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        try {
            loadBooksFromFile();
            loadUsersFromFile();
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }

        while (true) {
            System.out.println("1. Add new book");
            System.out.println("2. Remove book");
            System.out.println("3. Update book information");
            System.out.println("4. Display book details");
            System.out.println("5. Register new user");
            System.out.println("6. Login");
            System.out.println("7. View borrowing history");
            System.out.println("8. Borrow book");
            System.out.println("9. Return book");
            System.out.println("10. Search for book by title or author");
            System.out.println("11. View available books");
            System.out.println("12. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    updateBookInformation(scanner);
                    break;
                case 4:
                    displayBookDetails(scanner);
                    break;
                case 5:
                    registerNewUser(scanner);
                    break;
                case 6:
                    login(scanner);
                    break;
                case 7:
                    viewBorrowingHistory(scanner);
                    break;
                case 8:
                    borrowBook(scanner);
                    break;
                case 9:
                    returnBook(scanner);
                    break;
                case 10:
                    searchForBook(scanner);
                    break;
                case 11:
                    viewAvailableBooks();
                    break;
                case 12:
                    try {
                        saveBooksToFile();
                        saveUsersToFile();
                    } catch (IOException e) {
                        System.out.println("Error saving data to file: " + e.getMessage());
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void addNewBook(Scanner scanner) {
        try {
            System.out.println("Enter title:");
            String title = scanner.next();
            System.out.println("Enter author:");
            String author = scanner.next();
            System.out.println("Enter ISBN:");
            String isbn = scanner.next();
            System.out.println("Enter genre:");
            String genre = scanner.next();

            Book book = new Book(title, author, isbn, genre, true);
            books[numBooks++] = book;
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    private void removeBook(Scanner scanner) {
        try {
            System.out.println("Enter ISBN of book to remove:");
            String isbn = scanner.next();

            for (int i = 0; i < numBooks; i++) {
                if (books[i].isbn.equals(isbn)) {
                    books[i] = null;
                    numBooks--;
                    System.out.println("Book removed successfully!");
                    return;
                }
            }

            System.out.println("Book not found!");
        } catch (Exception e) {
            System.out.println("Error removing book: " + e.getMessage());
        }
    }

    private void updateBookInformation(Scanner scanner) {
        try {
            System.out.println("Enter ISBN of book to update:");
            String isbn = scanner.next();

            for (int i = 0; i < numBooks; i++) {
                if (books[i].isbn.equals(isbn)) {
                    System.out.println("Enter new title:");
                    String title = scanner.next();
                    System.out.println("Enter new author:");
                    String author = scanner.next();
                    System.out.println("Enter new genre:");
                    String genre = scanner.next();

                    books[i] = new Book(title, author, isbn, genre, books[i].availability);
                    System.out.println("Book information updated successfully!");
                    return;
                }
            }

            System.out.println("Book not found!");
        } catch (Exception e) {
            System.out.println("Error updating book information: " + e.getMessage());
        }
    }

    private void displayBookDetails(Scanner scanner) {
        try {
            System.out.println("Enter ISBN of book to display details:");
            String isbn = scanner.next();

            for (int i = 0; i < numBooks; i++) {
                if (books[i].isbn.equals(isbn)) {
                    books[i].displayBookDetails();
                    return;
                }
            }

            System.out.println("Book not found!");
        } catch (Exception e) {
            System.out.println("Error displaying book details: " + e.getMessage());
        }
    }

    private void registerNewUser(Scanner scanner) {
        try {
            System.out.println("Enter name:");
            String name = scanner.next();
            System.out.println("Enter ID:");
            int id = scanner.nextInt();
            System.out.println("Enter membership status (true or false):");
            boolean membershipStatus = scanner.nextBoolean();

            User user = new User(name, id, membershipStatus, id);
            users[numUsers++] = user;
            System.out.println("User registered successfully!");
        } catch (Exception e) {
            System.out.println("Error registering new user: " + e.getMessage());
        }
    }

    private void login(Scanner scanner) {
        try {
            System.out.println("Enter ID:");
            int id = scanner.nextInt();

            for (int i = 0; i < numUsers; i++) {
                if (users[i].getId() == id) {
                    System.out.println("Login successful!");
                    runUserSession(i);
                    return;
                }
            }

            System.out.println("User not found!");
        } catch (Exception e) {
            System.out.println("Error logging in: " + e.getMessage());
        }
    }

    private void runUserSession(int userIndex) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View borrowing history");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewBorrowingHistory(scanner);
                    break;
                case 2:
                    borrowBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void viewBorrowingHistory(Scanner scanner) {
        try {
            // Assuming we are currently in a user session, userIndex will be the index of the current user
            System.out.println("Borrowing history:");
            for (Book borrowedBook : users[userIndex].borrowedBooks) {
                if (borrowedBook!= null) {
                    borrowedBook.displayBookDetails();
                }
            }
        } catch (Exception e) {
            System.out.println("Error viewing borrowing history: " + e.getMessage());
        }
    }

    private void borrowBook(Scanner scanner) {
        try {
            System.out.println("Enter ISBN of book to borrow:");
            String isbn = scanner.next();

            for (int i = 0; i < numBooks; i++) {
                if (books[i].isbn.equals(isbn) && books[i].availability) {
                    System.out.println("Book borrowed successfully!");
                    users[userIndex].borrowedBooks[users[userIndex].borrowedBooks.length - 1] = books[i];
                    books[i].availability = false;
                    return;
                }
            }

            System.out.println("Book not found or not available!");
        } catch (Exception e) {
            System.out.println("Error borrowing book: " + e.getMessage());
        }
    }

    private void returnBook(Scanner scanner) {
        try {
            System.out.println("Enter ISBN of book to return:");
            String isbn = scanner.next();

           for (int i = 0; i < numBooks; i++) {
                if (books[i].isbn.equals(isbn) && !books[i].availability) {
                    System.out.println("Book returned successfully!");
                    for (int j = 0; j < users[userIndex].borrowedBooks.length; j++) {
                        if (users[userIndex].borrowedBooks[j].isbn.equals(isbn)) {
                            users[userIndex].borrowedBooks[j] = null;
                            break;
                        }
                    }
                    books[i].availability = true;
                    return;
                }
            }
               //System.out.println("Book return succesfully");
        
            System.out.println("Book not found or already available!");
        } catch (Exception e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    
    }
    private void searchForBook(Scanner scanner) {
        try {
            System.out.println("Enter title or author to search for:");
            String query = scanner.next();

            for (int i = 0; i < numBooks; i++) {
                if (books[i].getTitle().contains(query) || books[i].getAuthor().contains(query)) {
                    books[i].displayBookDetails();
                }
            }
        } catch (Exception e) {
            System.out.println("Error searching for book: " + e.getMessage());
        }
    }

    private void viewAvailableBooks() {
        try {
            System.out.println("Available books:");
            for (int i = 0; i < numBooks; i++) {
                if (books[i].availability) {
                    books[i].displayBookDetails();
                }
            }
        } catch (Exception e) {
           // System.out.println("Error viewing available books: " + e.getMessage());
        }
    }

    private void saveBooksToFile() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("books.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(numBooks);
            for (int i = 0; i < numBooks; i++) {
                oos.writeObject(books[i]);
            }
        }
    }

    private void loadBooksFromFile() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("books.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            numBooks = ois.readInt();
            books = new Book[numBooks];
            for (int i = 0; i < numBooks; i++) {
                books[i] = (Book) ois.readObject();
            }
        }
    }

    private void saveUsersToFile() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("users.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(numUsers);
            for (int i = 0; i < numUsers; i++) {
                oos.writeObject(users[i]);
            }
        }
    }

    private void loadUsersFromFile() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("users.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            numUsers = ois.readInt();
            users = new User[numUsers];
            for (int i = 0; i < numUsers; i++) {
                users[i] = (User) ois.readObject();
            }
        }
    }

    

	public static void main(String[] args) throws ClassNotFoundException {
		  LibrarySystem library = new LibrarySystem();
	        library.run();
	}
}
