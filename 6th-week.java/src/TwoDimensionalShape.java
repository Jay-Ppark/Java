

/**
 * @author ailab
 * Create class of 2DShape and can be subclassed.
 */
public abstract class TwoDimensionalShape implements Comparable<TwoDimensionalShape>, Sizable
{
	private static final String CLASS_NAME = "2D Shape";
	private String name;
	private double dimension1;
	private double dimension2;
	
	// Constructor
	public TwoDimensionalShape()
	{
	}
	public TwoDimensionalShape(String name, double d1, double d2)
	{
		setName(name);
		setDimension1(d1);
		setDimension2(d2);
	}
	
	// Get class name
	public String getClassName()
	{
		return CLASS_NAME;
	}
	
	// Get & set name
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	// Get & set methods for dimension 1
	public double getDimension1()
	{
		return dimension1;
	}
	public void setDimension1(double dimension1)
	{
		this.dimension1 = dimension1;
	}
	
	// Get & set methods for dimension 2
	public double getDimension2()
	{
		return dimension2;
	}
	public void setDimension2(double dimension2)
	{
		this.dimension2 = dimension2;
	}
	
	// Don't know the kind of current shape
	// must be implement in subclass (Override)
	public abstract double getArea();
	
	public int compareTo(TwoDimensionalShape otherShape)
	{
        double val;
        val = getArea() - otherShape.getArea();
        if (val > 0)
        {
            return 1;
        }
        else if (val < 0)
        {
            return -1;
        }
        return 0;
    }
	
	@Override
	public String toString()
	{
		return String.format("%s is a [%s]", getName(), getClassName());
	}
}
