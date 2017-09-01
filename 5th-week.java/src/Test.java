public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Circle cir1 = new Circle("CirObject1", 3.0);
		Rectangle rec1 = new Rectangle("RecObject1", 3.0, 4.0);
		Square sq1 = new Square("SquareObject1", 6.0);

		System.out.println("Three shapes have been created:");
		System.out.println("1." + cir1.toString());
		System.out.printf("%s's area is %.2f, radius is %.2f, diameter is %.2f\n",
				cir1.getName(), cir1.getArea(), cir1.getRadius(),
				cir1.getDiameter());

		System.out.println("2." + rec1.toString());
		System.out.println("RecObject1's area is " + rec1.getArea()
				+ ", width is " + rec1.getWidth() + ", height is "
				+ rec1.getHeight());

		System.out.println("3." + sq1.toString());
		System.out.println("SquareObject1's area is " + sq1.getArea()
				+ ", side is " + sq1.getSide());
	}

}
