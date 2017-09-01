
public class Item implements ForSale, ItemInfo {

	private String itemID;
	private int importPrice;

	//constructor
	public Item() {

	}

	//constructor
	public Item(String id, int price) {
		setItemID(id);
		importPrice = price;
	}
	//get itemID
	public String getItemID() {
		return itemID;
	}
	//set itemID
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	//get item's SalePrice
	@Override
	public int getSalePrice() {
		return this.importPrice;
	}
	//get item's information
	@Override
	public String getInfo() {
		return null;
	}

}
