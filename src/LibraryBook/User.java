package LibraryBook;

public class User {
	 private String name;
	   private int id;
	  private  boolean membershipStatus;
	    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(boolean membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public Book[] getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(Book[] borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

		Book[] borrowedBooks;
		private String address;
		private String email;
		private String phone;
		private int borrowingLimit;

	    public User(String name, int id, boolean membershipStatus, int i) {
	        this.name = name;
	        this.id = id;
	        this.membershipStatus = membershipStatus;
	        this.borrowedBooks = new Book[10]; // assume max 10 books can be borrowed
	    }
		/*
		 * public User(String name2, String address, String email, String phone) {
		 * this.name = name2; this.address = address; this.email = email; this.phone =
		 * phone; printUserDetails(); } private void printUserDetails() {
		 * System.out.println("Name: " + name); System.out.println("Address: " +
		 * address); System.out.println("Email: " + email); System.out.println("Phone: "
		 * + phone); }
		 */


		public void displayBorrowingHistory() {
	        System.out.println("Borrowing History:");
	        for (Book book : borrowedBooks) {
	            if (book!= null) {
	                book.displayBookDetails();
	            }
	        }
	    }
	    //Adding this newly
	     /*   public  boolean isEligibleToBorrow(Book book) {
	            if (this instanceof StudentUser) {
	                return this.borrowedBooks.length < 5;
	            } else if (this instanceof FacultyUser) {
	                return this.borrowedBooks.length < 10;
	            }
	            return false;
	        
	    }
	}*/
		public boolean isEligibleToBorrow(Book book) {
	        return borrowedBooks.length < borrowingLimit;
	    }
}
