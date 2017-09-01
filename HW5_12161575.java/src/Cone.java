
public class Cone extends Circle{

	static final String CLASS_NAME = "Cone";
	private double height;
	//constructor
	public Cone(String name,double radius,double height)
	{
		super(name, radius);
		this.height=height;
	}
	//get radius
	public double getRadius()
	{
		return super.dimension1;
	}
	//set radius
	public void setRadius(double radius)
	{
		super.dimension1=radius;
	}
	//get height
	public double getHeight()
	{
		return height;
	}
	//set height
	public void setHeight(double height)
	{
		this.height=height;
	}
	//calculate generatingLine s^2 = r^2+h^2
	public double getGeneratingLine()
	{
		return Math.sqrt(Math.pow(getRadius(),2)+Math.pow(getHeight(),2));
	}
	//calculate area
	public double getArea()
	{
		return getRadius()*getRadius()*Math.PI + Math.PI*getRadius()*getGeneratingLine();
	}
	//calculate volume
	public double getVolume()
	{
		return Math.PI*getRadius()*getRadius()*getHeight()/3;
	}
	//return print format
	public String toString()
	{
		return getName() + " is a " + CLASS_NAME + " inherited from " + super.getClassName() +" class";
	}
}
