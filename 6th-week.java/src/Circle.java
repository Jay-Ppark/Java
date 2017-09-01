

public class Circle extends TwoDimensionalShape
{
	private static final String CLASS_NAME = "Circle";
	
	public Circle()
	{
		super();
	}
	public Circle(String name, double radius)
	{
		super(name, radius, 2 * radius);
	}
	
	@Override
	// Return current class name
	public String getClassName()
	{
		return CLASS_NAME;
	}
	
	public double getRadius()
	{
		return super.getDimension1();
	}
	public void setRadius(double radius)
	{
		super.setDimension1(radius);
		super.setDimension2(2 * radius);
	}
	
	public double getDiameter()
	{
		return super.getDimension2();
	}
	public void setDiameter(double diameter)
	{
		super.setDimension1(diameter / 2);
		super.setDimension2(diameter);
	}
	
	@Override
	public double getArea()
	{
		return (Math.PI * super.getDimension1() * super.getDimension1());
	}
	
	@Override
	public void resize(double ratio)
	{
		setRadius(getRadius() * Math.sqrt(ratio));
	}
	
	@Override
	public String toString()
	{
		return String.format("%s is a [%s], and is a [%s]", super.getName(), getClassName(), super.getClassName());
	}
}
