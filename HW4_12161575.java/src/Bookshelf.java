//
// class Bookshelf
// 24th March 2017 
// Created by Jaehyung Park
//

public class Bookshelf {
	private static final int bookCapacity = 10; // limit the number of books
	private int bookHave = 0;
	private Book[] books;
	private int numberOfBooks;

	//get the NumberOfBooks
	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	//set the NumberOfBooks
	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	// make constructor
	public Bookshelf(Book[] books) {
		// TODO Auto-generated constructor stub
		this.books = books;
		this.bookHave = books.length;
	}

	// get the number of books
	public int getBookHave() {
		return bookHave;
	}

	// set the number of books
	public void setBookHave(int bookHave) {
		this.bookHave = bookHave;
	}

	// get the book objects
	public Book[] getBooks() {
		return books;
	}

	// set the book objects
	public void setBooks(Book[] books) {
		this.books = books;
	}

	// find books that have keyword in title
	public Book[] searchByTitle(String keyword) {
		Book[] findBooks = new Book[bookHave];
		int count = 0;
		Book[] books = this.getBooks();
		for (int i = 0; i < bookHave; i++) {
			boolean found = books[i].getTitle().contains(keyword);
			if (found) {
				findBooks[count] = books[i];
				++count;
			}
		}
		this.numberOfBooks = count;
		return findBooks;
	}

	// find books that have keyword in author
	public Book[] searchByAuthor(String keyword) {
		Book[] findBooks = new Book[bookHave];
		int count = 0;
		Book[] books = this.getBooks();
		for (int i = 0; i < bookHave; i++) {
			for (int j = 0; j < books[i].getAuthors().length; j++) {
				boolean found = books[i].getAuthors()[j].contains(keyword);
				if (found) {
					findBooks[count] = books[i];
					++count;
				}
			}
		}

		this.numberOfBooks = count;
		return findBooks;
	}

	// find books that have keyword in title and author
	public Book[] searchByBoth(String keyword) {
		Book[] findBooks = new Book[10];
		int count = 0;
		Book[] books = this.getBooks();
		for (int i = 0; i < bookHave; i++) {
			for (int j = 0; j < books[i].getAuthors().length; j++) {
				boolean found = books[i].getAuthors()[j].contains(keyword);
				if (found) {
					findBooks[count] = books[i];
					++count;
				}
				
			}
			boolean found = books[i].getTitle().contains(keyword);
			if(found)
			{
				findBooks[count] = books[i];
				++count;
			}
		}
		this.numberOfBooks = count;
		return findBooks;
	}
}
