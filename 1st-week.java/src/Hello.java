import java.util.Scanner;
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		long n = 461012;
		double pi = Math.PI;
		System.out.println("a: " + a +  " b: " + b);
		System.out.printf("a: %d b: %d\n", a ,b);
		System.out.printf("%d%n", n);
		System.out.printf("%08d%n", n);
		System.out.printf("%, 8d%n", n);
		System.out.printf("%+,8d%n", n);
		System.out.printf("%f%n", pi);
		System.out.printf("%10.3f%n", pi);
		System.out.printf("%-10.3f%n", pi);
	}

}
