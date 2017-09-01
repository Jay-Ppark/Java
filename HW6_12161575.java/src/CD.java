import java.text.DecimalFormat;// print like this 1,000,000

public class CD extends Item {

	private String cdTitle;
	private String cdArtist;
	private int pubYear;

	//constructor
	public CD() {
		super();
	}
	//constructor
	public CD(String id, String title, String artist, int pubYear,
			int importPrice) {
		super(id, importPrice);
		cdTitle = title;
		cdArtist = artist;
		this.pubYear = pubYear;
	}
	//get cd's title
	public String getTitle() {
		return cdTitle;
	}
	//get cd's artist
	public String getArtist() {
		return cdArtist;
	}
	//get published year
	public int getPublishYear() {
		return pubYear;
	}
	//calculate saleprice and get saleprice
	public int getSalePrice() {
		int salePrice = 0;
		salePrice = 2017 - this.getPublishYear();
		if (salePrice <= 1) {
			return (int) (super.getSalePrice() * 1.5);
		} else if (salePrice <= 2) {
			return super.getSalePrice();
		} else {
			return (int) (super.getSalePrice() * 0.7);
		}
	}
	//get CD's information
	public String getInfo() {
		DecimalFormat df = new DecimalFormat("###,###,###");
		String tempPrice = df.format(getSalePrice());
		String tempCD = getTitle() + " - " + getArtist();
		return String.format("%-20s%10s W", tempCD, tempPrice);
	}

}
