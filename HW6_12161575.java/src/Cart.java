import java.text.DecimalFormat;// print like this 1,000,000

public class Cart {

	private static final int MAX_ITEM = 100;
	private Item items[] = new Item[100];
	private int itemNum = 0;
	private String buyerName;

	//constructor
	public Cart() {

	}
	//constructor
	public Cart(String buyerName) {
		this.setBuyerName(buyerName);
	}
	//get buyer's name
	public String getBuyerName() {
		return buyerName;
	}
	//set buyer's name
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	//get item's number
	public int getNumberOfItems() {
		return itemNum;
	}
	//set item's number
	public void setNumberOfItems(int itemNum) {
		this.itemNum = itemNum;
	}
	//add Item if item's number is less than MAX_ITEM
	public boolean addItem(Item i) {
		if (getNumberOfItems() < MAX_ITEM) {
			items[itemNum] = i;
			itemNum = itemNum + 1;
			return true;
		} else {
			return false;
		}

	}
	//print receipt
	public void printReceipt() {
		int total = 0;
		System.out.println("Receipt:");
		System.out.println("Buyer: " + getBuyerName());
		System.out.println("------------------------------------");
		for (int i = 0; i < itemNum; i++) {
			total = total + items[i].getSalePrice();
			System.out.println(i + 1 + ". " + items[i].getInfo());
		}
		System.out.println("------------------------------------");
		DecimalFormat df = new DecimalFormat("###,###,###");
		String tempTotal = df.format(total);
		System.out.printf("Total:%27s W", tempTotal);
	}

}
