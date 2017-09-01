
public class Cube extends Square{

	static final String CLASS_NAME = "Cube";
	//constructor
	public Cube(String name,double length)
	{
		super(name,length);
	}
	//get length
	public double getLength()
	{
		return super.dimension1;
	}
	//set length
	public void setLength(double length)
	{
		super.dimension1=length;
	}
	//calculate area
	public double getArea()
	{
		return 6*getLength()*getLength();
	}
	//calculate volume
	public double getVolume()
	{
		return getLength()*getLength()*getLength();
	}
	//return print format
	public String toString()
	{
		return getName() + " is a " + CLASS_NAME + " inherited from " + getClassName() +" class";
	}
}
