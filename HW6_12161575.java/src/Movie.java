import java.text.DecimalFormat;// print like this 1,000,000

public class Movie extends Item {

	private String cdTitle;
	private int pubYear;

	//constructor
	public Movie() {
		super();
	}
	//constructor
	public Movie(String id, String title, int pubYear, int importPrice) {
		super(id, importPrice);
		cdTitle = title;
		this.pubYear = pubYear;
	}
	//get movie's title
	public String getTitle() {
		return cdTitle;
	}
	//get movie's published year
	public int getPublishYear() {
		return pubYear;
	}
	//calculate saleprice and get saleprice
	public int getSalePrice() {
		int salePrice = 0;
		salePrice = 2017 - this.getPublishYear();
		if (salePrice <= 1) {
			return (int) (super.getSalePrice() * 2.0);
		} else {
			return (int) (super.getSalePrice() * 0.5);
		}
	}
	//get movie's information
	public String getInfo() {
		DecimalFormat df = new DecimalFormat("###,###,###");
		String tempPrice = df.format(getSalePrice());
		return String.format("%-20s%10s W", getTitle(), tempPrice);
	}

}
