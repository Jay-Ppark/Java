

public class Rectangle extends TwoDimensionalShape
{
	private static final String CLASS_NAME = "Rectangle";
	
	public Rectangle()
	{
		super();
	}
	public Rectangle(String name, double width, double height)
	{
		// Store width in field dimension1, height in field dimension2
		super(name, width, height);
	}
	
	@Override
	public String getClassName()
	{
		return CLASS_NAME;
	}
	
	public double getWidth()
	{
		return super.getDimension1();
	}
	public void setWidth(double width)
	{
		super.setDimension1(width);
	}
	
	public double getHeight()
	{
		return super.getDimension2();
	}
	public void setHeight(double height)
	{
		super.setDimension2(height);
	}
	
	public void setSize(double width, double height)
	{
		super.setDimension1(width);
		super.setDimension2(height);
	}
	
	@Override
	public double getArea()
	{
		return super.getDimension1() * super.getDimension2();
	}
	
	@Override
	public void resize(double ratio)
	{
		setWidth(getWidth() * ratio);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s is a [%s], and is a [%s]", super.getName(), getClassName(), super.getClassName());
	}
}
