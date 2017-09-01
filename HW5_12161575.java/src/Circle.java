public class Circle extends TwoDimensionalShape {

	static final String CLASS_NAME = "Circle";

	//constructor
	public Circle(String name, double radius) {
		super(name, radius, 0);
	}
	// get CLASS_NAME
	public static String getClassName() {
		return CLASS_NAME;
	}
	//get Dimension1
	public double getRadius() {
		return super.getDimension1();
	}
	//set radius
	public void setRadius(double radius) {
		this.dimension1 = radius;
	}
	//get diameter
	public double getDiameter() {
		return 2 * super.getDimension1();
	}
	//set diameter
	public void setDiameter(double radius) {
		this.dimension1 = radius;
	}
	//get Area
	public double getArea() {
		return getRadius() * getRadius() * Math.PI;
	}
	//return print format
	public String toString()
	{
		return getName() + " is a [" + CLASS_NAME + "], and is a [" + super.getClassName() +"]";
	}
}
