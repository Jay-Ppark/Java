public class Square extends Rectangle {

	static final String CLASS_NAME = "Square";
	//constructor
	public Square(String name, double side) {
		super(name, side, side);
	}
	//get ClassName
	public static String getClassName() {
		return CLASS_NAME;
	}
	//get side
	public double getSide() {
		return this.dimension1;
	}
	//set side
	public void setSide(double side) {
		this.dimension1 = side;
	}
	//return print format
	public String toString()
	{
		return getName() + "is a [" + CLASS_NAME + "], and is a [" + super.getClassName() +"]";
	}
}
