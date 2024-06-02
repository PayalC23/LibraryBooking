package LibraryBook;

public class FacultyUser extends User{
	 private int borrowingLimit;
		public FacultyUser(String name, int id, boolean membershipStatus) {
		        super(name, id, membershipStatus, 10);
		    }
	    @Override
	    public boolean isEligibleToBorrow(Book book) {
	        return borrowedBooks.length < borrowingLimit && super.isEligibleToBorrow(book);
	    }
}
