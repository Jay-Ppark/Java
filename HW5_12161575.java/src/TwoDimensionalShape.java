public class TwoDimensionalShape {

	private static final String CLASS_NAME = "2D shape";
	private String name;
	protected double dimension1;
	protected double dimension2;

	//constructor
	public TwoDimensionalShape(String name, double d1, double d2) {

		this.name = name;
		dimension1 = d1;
		dimension2 = d2;
	}
	
	//get Name
	public String getName()
	{
		return name;
	}
	
	//set Name
	public void setName(String name)
	{
		this.name = name;
	}

	//get dimension1
	public double getDimension1() {
		return dimension1;
	}

	//set dimension1
	public void setDimension1(double d1) {
		dimension1 = d1;
	}

	//get dimension2
	public double getDimension2() {
		return dimension2;
	}

	//set dimension2
	public void setDimension2(double d2) {
		this.dimension2 = d2;
	}

	//get CLASS_NAME
	public static String getClassName() {
		return CLASS_NAME;
	}

	//don'know shape so return 0
	public double getArea() {
		return 0;
	}

}
