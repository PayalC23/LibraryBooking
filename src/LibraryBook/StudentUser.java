package LibraryBook;

public class StudentUser  extends User{
	private int borrowingLimit;
	public StudentUser(String name, int id, boolean membershipStatus) {
        super(name, id, membershipStatus, 5);
    }
    @Override
    public boolean isEligibleToBorrow(Book book) {
        return borrowedBooks.length < borrowingLimit && super.isEligibleToBorrow(book);
    }
}
