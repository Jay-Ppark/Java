
public class Sphere extends Circle{

	static final String CLASS_NAME = "Sphere";
	// constructor
	public Sphere(String name,double radius)
	{
		super(name,radius);
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
	//calculate area
	public double getArea()
	{
		return 4*Math.PI*getRadius()*getRadius();
	}
	//calculate volume
	public double getVolume()
	{
		return 4*Math.PI*getRadius()*getRadius()*getRadius()/3;
	}
	//return print format
	public String toString()
	{
		return getName() + " is a " + CLASS_NAME + " inherited from " + super.getClassName() +" class";
	}
}
