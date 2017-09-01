public class Circle extends TwoDimensionalShape {

	static final String CLASS_NAME = "Circle";

	public Circle(String name, double radius) {
		super(name, radius, 0);
	}

	public double getRadius() {
		return super.getDimension1();
	}

	public void setRadius(double radius) {
		this.dimension1 = radius;
	}

	public double getDiameter() {
		return 2 * super.getDimension1();
	}

	public void setDiameter(double radius) {
		this.dimension1 = radius;
	}

	public double getArea() {
		return getRadius() * getRadius() * Math.PI;
	}
	
	public String toString()
	{
		return getName() + " is a [" + CLASS_NAME + "], and is a [" + super.getClassName() +"]";
	}
}
