package LibraryBook;

public class Book {
	private String title;
	   private String author;
	   String isbn;
	    private String genre;
	   boolean availability;

	    public Book(String title, String author, String isbn, String genre, boolean availability) {
	        this.title = title;
	        this.author = author;
	        this.isbn = isbn;
	        this.genre = genre;
	        this.availability = availability;
	    }

	    public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public boolean isAvailability() {
			return availability;
		}

		public void setAvailability(boolean availability) {
			this.availability = availability;
		}

		public void displayBookDetails() {
	        System.out.println("Title: " + title);
	        System.out.println("Author: " + author);
	        System.out.println("ISBN: " + isbn);
	        System.out.println("Genre: " + genre);
	        System.out.println("Availability: " + (availability? "Available" : "Not Available"));
	    }
}
