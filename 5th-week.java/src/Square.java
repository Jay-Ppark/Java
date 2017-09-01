public class Square extends Rectangle {

	static final String CLASS_NAME = "Square";

	public Square(String name, double side) {
		super(name, side, side);
	}

	public double getSide() {
		return this.dimension1;
	}

	public void setSide(double side) {
		this.dimension1 = side;
	}
	
	public String toString()
	{
		return getName() + "is a [" + CLASS_NAME + "], and is a [" + super.getClassName() +"]";
	}
}
