
public class Main
{
	public static void main(String[] args)
	{
		// Create an object
		Circle cir1 = new Circle("CirObject1", 3.0);
		Rectangle rec1 = new Rectangle("RecObject1", 3.0, 4.0);
		Square sq1 = new Square("SquareObject1", 6.0);
		
		TwoDimensionalShape sq2 = new Square("SquareObject2", 4.0);
		System.out.println("Four shapes have been created:");
		
		// Print the object properties
		System.out.println("1. " + cir1);
		System.out.printf("%s's area is %.2f, radius is %.2f, diameter is %.2f\n", cir1.getName(), cir1.getArea(), cir1.getRadius(), cir1.getDiameter());
		
		System.out.println("2. " + rec1);
		System.out.printf("%s's area is %.2f, width is %.2f, height is %.2f\n", rec1.getName(), rec1.getArea(), rec1.getWidth(), rec1.getHeight());
		
		System.out.println("3. " + sq1);
		System.out.printf("%s's area is %.2f, side is %.2f\n", sq1.getName(), sq1.getArea(), sq1.getSide());
		
		System.out.println("4. " + sq2);
		System.out.printf("%s's area is %.2f\n\n", sq2.getName(), sq2.getArea()); // But can't use sq2.getSide()
		
		// Print all circle shape
		System.out.printf("Is %s TwoDimensionalShape? %s\n", sq1.getName(), sq1 instanceof TwoDimensionalShape);
		System.out.printf("Is %s Rectangle? %s\n", sq1.getName(), sq1 instanceof Rectangle);
		System.out.printf("Is %s Square? %s\n", sq1.getName(), sq1 instanceof Square);
		System.out.printf("Is %s TwoDimensionalShape? %s\n", sq2.getName(), sq2 instanceof TwoDimensionalShape);
		System.out.printf("Is %s Square? %s\n", sq2.getName(), sq2 instanceof Square);
	}
}
