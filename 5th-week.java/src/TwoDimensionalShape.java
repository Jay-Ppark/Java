public class TwoDimensionalShape {

	private static final String CLASS_NAME = "2D shape";
	private String name;
	protected double dimension1;
	protected double dimension2;

	public TwoDimensionalShape(String name, double d1, double d2) {

		this.name = name;
		dimension1 = d1;
		dimension2 = d2;
	}

	public double getDimension1() {
		return dimension1;
	}

	public void setDimension1(double d1) {
		dimension1 = d1;
	}

	public double getDimension2() {
		return dimension2;
	}

	public void setDimension2(double d2) {
		this.dimension2 = d2;
	}

	public static String getClassName() {
		return CLASS_NAME;
	}

	public String getName() {
		return name;
	}

	public double getArea() {
		return this.dimension1 * this.dimension2;
	}

}
