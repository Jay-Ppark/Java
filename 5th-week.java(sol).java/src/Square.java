
public class Square extends Rectangle
{
	private static final String CLASS_NAME = "Square";
	
	public Square()
	{
		super();
	}
	public Square(String name, double side)
	{
		// This will call the constructor of Rectangle
		super(name, side, side);
	}
	
	@Override
	public String getClassName()
	{
		return CLASS_NAME;
	}
	
	public double getSide()
	{
		return getWidth();
	}
	public void setSide(int side)
	{
		super.setSize(side, side);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s is a [%s], and is a [%s]", super.getName(), getClassName(), super.getClassName());
	}
}
