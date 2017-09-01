public class Rectangle extends TwoDimensionalShape {

	static final String CLASS_NAME = "Rectangle";

	public Rectangle(String name, double width, double height) {
		super(name, width, height);
	}

	public double getWidth() {
		return super.dimension1;
	}

	public void setWidth(double width) {
		this.dimension1 = width;
	}

	public double getHeight() {
		return super.dimension2;
	}

	public void setHeight(double height) {
		this.dimension2 = height;
	}

	public double getArea() {
		return getWidth() * getHeight();
	}
	
	public String toString()
	{
		return getName() + "is a [" + CLASS_NAME + "], and is a [" + super.getClassName() +"]";
	}
}
