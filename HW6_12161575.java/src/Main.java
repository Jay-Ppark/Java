public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create an object
		Item[] myItems = new Item[8];
		myItems[0] = new CD("CD", "Alive", "Big Bang", 2012, 50000);
		myItems[1] = new Movie("Movie", "Lord of the Ring2", 2002, 70000);
		myItems[2] = new CD("CD", "To Anyone", "2NE1", 2010, 55000);
		myItems[3] = new Movie("Movie", "La La Land", 2016, 90000);
		myItems[4] = new CD("CD", "Memory", "Mamamoo", 2016, 60000);
		myItems[5] = new Movie("Movie", "Insidious", 2010, 80000);
		myItems[6] = new CD("CD", "Crayon", "G-Dragon", 2012, 75000);
		myItems[7] = new Movie("Movie", "Beauty and the Beast", 2017, 100000);
		
		Cart myCart = new Cart("Jaehyung");
		
		for (int i = 0; i < 8; i++) {
			//if item's number is more than 100 print error! and stop add items
			if (!myCart.addItem(myItems[i])) {
				System.out.println("Error!");
				break;
			}
		}
		//print
		myCart.printReceipt();
	}

}
