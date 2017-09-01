public class Rectangle extends TwoDimensionalShape {

	static final String CLASS_NAME = "Rectangle";

	//constructor
	public Rectangle(String name, double width, double height) {
		
		super(name, width, height);
	}
	// get ClassName
	public static String getClassName() {
		return CLASS_NAME;
	}
	//get width
	public double getWidth() {
		return super.dimension1;
	}
	//set width
	public void setWidth(double width) {
		this.dimension1 = width;
	}
	//get height
	public double getHeight() {
		return super.dimension2;
	}
	//set height
	public void setHeight(double height) {
		this.dimension2 = height;
	}
	//calculate area
	public double getArea() {
		return getWidth() * getHeight();
	}
	//return print format
	public String toString()
	{
		return getName() + "is a [" + CLASS_NAME + "], and is a [" + super.getClassName() +"]";
	}
}
