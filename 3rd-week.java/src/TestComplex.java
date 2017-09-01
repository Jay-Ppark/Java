
public class TestComplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Complex c1 = new Complex(1,2);   //make an object
		Complex c2 = new Complex(3,-5);  //make an object
		//Complex c3;
		//c3.printComplexnum();
		System.out.print("First complex is: ");
		c1.printComplexnum();
		System.out.print("Second complex is: ");
		c2.printComplexnum();
		System.out.print("Result of addition is: ");
		c1.addComplexnum(c2).printComplexnum();
		System.out.print("Result of subtraction is: ");
		c1.subComplexnum(c2).printComplexnum();
		System.out.print("Result of multiplication is: ");
		c1.mulComplexnum(c2).printComplexnum();
		System.out.println("First complex's absolute value is: " + c1.absoluteComplexnum(c1));
		System.out.println("Second complex's absolute value is: " + c2.absoluteComplexnum(c2));
		
		
	}

}
