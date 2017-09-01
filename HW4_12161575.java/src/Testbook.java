import java.util.Scanner;

public class Testbook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int inputNum;
		String keyword;     
		Book book1 = new Book("Harry Porter", new String[] { "Kim", "Park" },
				424, 1945);                                                     //make Book object1
		Book book2 = new Book("Harry and Emma", new String[] { "Ahn", "Kim",
				"Dave" }, 567, 2002);                                           //make Book object2
		Book book3 = new Book("Spider Woman", new String[] { "Amy", "Dave" },
				574, 2013);                                                     //make Book object3

		Book[] books = new Book[3];
		books[0] = book1;
		books[1] = book2;
		books[2] = book3;
		Bookshelf bookshelf = new Bookshelf(books);                            //make Bookshelf object

		System.out.println("Choose 1 option to search:");
		System.out.println("1. Search by title.");
		System.out.println("2. Search by author.");
		System.out.println("3. Search by both.");
		System.out.print("User input: ");

		inputNum = input.nextInt();
		input.nextLine();

		if (inputNum == 1) {                                       //if input 1 search by title
			System.out.print("Insert title keyword: ");
			keyword = input.nextLine();
			Book[] foundBooks = bookshelf.searchByTitle(keyword);
			if (foundBooks != null) {

				System.out.println("Found " + bookshelf.getNumberOfBooks()
						+ " book(s)");
				for (int i = 0; i < bookshelf.getNumberOfBooks(); i++) {
					System.out.println(i + 1 + ". "
							+ bookshelf.searchByTitle(keyword)[i].toString()
							+ " -"
							+ bookshelf.searchByTitle(keyword)[i].getPage()
							+ "pages -"
							+ bookshelf.searchByTitle(keyword)[i].getPubYear()
							+ ".");
				}
			} else {
				System.out.println("cannot find books");

			}
		}

		else if (inputNum == 2) {                                //if input 2 search by author
			System.out.print("Insert author keyword: ");
			keyword = input.nextLine();
			Book[] foundBooks = bookshelf.searchByAuthor(keyword);
			if (foundBooks != null) {

				System.out.println("Found " + bookshelf.getNumberOfBooks()
						+ " book(s)");
				for (int i = 0; i < bookshelf.getNumberOfBooks(); i++) {
					System.out.println(i + 1 + ". "
							+ bookshelf.searchByAuthor(keyword)[i].toString()
							+ " -"
							+ bookshelf.searchByAuthor(keyword)[i].getPage()
							+ "pages -"
							+ bookshelf.searchByAuthor(keyword)[i].getPubYear()
							+ ".");
				}
			} else {
				System.out.println("cannot find books");

			}

		} else {                                                      //if input 3 search by both(title and author)
			System.out.print("Insert keyword: ");
			keyword = input.nextLine();
			Book[] foundBooks = bookshelf.searchByBoth(keyword);
			if (foundBooks != null) {

				System.out.println("Found " + bookshelf.getNumberOfBooks()
						+ " book(s)");
				for (int i = 0; i < bookshelf.getNumberOfBooks(); i++) {
					System.out.println(i + 1 + ". "
							+ bookshelf.searchByBoth(keyword)[i].toString()
							+ " -"
							+ bookshelf.searchByBoth(keyword)[i].getPage()
							+ "pages -"
							+ bookshelf.searchByBoth(keyword)[i].getPubYear()
							+ ".");
				}
			} else {
				System.out.println("cannot find books");

			}
		}

	}
}
