//
// class Complex
// 15th March 2017 
// Created by Jaehyung Park
//

public class Complex {
	// make the Complex class
	private int realnum; // the realnum part of Complex
	private int imaginarynum; // the imaginarynum part of Complex

	// constructor with no parameter
	public Complex() {
		realnum = 0; // initializing
		imaginarynum = 0;// initializing
	}

	// constructor with two parameters
	public Complex(int realnum, int imaginarynum) {
		this.realnum = realnum; // initializing
		this.imaginarynum = imaginarynum; // initializing
	}

	// get the realnum
	public int getRealnum() {
		return realnum;
	}

	// set the realnum
	public void setRealnum(int realnum) {
		this.realnum = realnum;
	}

	// get the imaginarynum
	public int getImaginarynum() {
		return imaginarynum;
	}

	// set the imaginarynum
	public void setImaginarynum(int imaginarynum) {
		this.imaginarynum = imaginarynum;
	}

	// print the Complexnumber
	public void printComplexnum() {

		System.out.print(realnum);
		if (imaginarynum >= 0) {
			if (imaginarynum == 1) {
				System.out.println(" + " + "i"); // if imaginary num is 1 print
													// only i
			} else if (imaginarynum == 0) {
				System.out.println(); // if imaginary num is 0 print nothing
			} else {
				System.out.println(" + " + imaginarynum + "i"); // if imaginary num is bigger
																// than 1 print imaginary num and i
			}
		} else {
			System.out.println(" - " + imaginarynum * (-1) + "i"); // if imaginary num is
																	// negative print imaginary num with minus
																	
		}
	}

	// calculate the complex's absolute value
	public Double absoluteComplexnum(Complex x) {
		return (double) (Math.sqrt(Math.pow(x.realnum, 2)
				+ Math.pow(x.imaginarynum, 2)));

	}

	// add the Complexnumbers
	public Complex addComplexnum(Complex x) {

		Complex c1 = new Complex();
		c1.realnum = this.realnum + x.realnum;
		c1.imaginarynum = this.imaginarynum + x.imaginarynum;
		return c1;
	}

	// sub the Complexnumbers
	public Complex subComplexnum(Complex x) {

		Complex c1 = new Complex();
		c1.realnum = this.realnum - x.realnum;
		c1.imaginarynum = this.imaginarynum - x.imaginarynum;
		return c1;
	}

	// multiply the complexnumbers
	public Complex mulComplexnum(Complex x) {

		Complex c1 = new Complex();
		c1.realnum = this.realnum * x.realnum - this.imaginarynum * x.imaginarynum;
		c1.imaginarynum = this.realnum * x.imaginarynum + this.imaginarynum * x.realnum;
		return c1;
	}

}
