import java.util.Random;
import java.util.Scanner;
public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random randomGenerator1 = new Random();
		Random randomGenerator2 = new Random();
		int n = 0;
		int result = 0;
		while(true)
		{
			int num1 = randomGenerator1.nextInt(9) + 1;
			int num2 = randomGenerator2.nextInt(9) + 1;
			result = num1 * num2;
			System.out.println("How much is " + num1 + " times " + num2 + "?");
			System.out.print("Enter your answer (-1 to exit):");
			Scanner input = new Scanner(System.in);
			n = input.nextInt();
			if(n == result)
			{
				System.out.println("Nice work!");
			}
			
			else if(n == -1)
			{
				break;
			}
			else
			{
				System.out.println("No. Keep trying.");
				while(true)
				{
					System.out.print("Enter your answer (-1 to exit):");
					n = input.nextInt();
					if(n == result)
					{
						break;
					}
				}
			}
		}

	}

}
