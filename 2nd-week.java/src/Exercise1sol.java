import java.util.Random;
import java.util.Scanner;

public class Exercise1sol
{
	static Random randomNumbers = new Random();
	static int answer; // the correct answer

	// ask the user to answer multiplication problems
	public static void main (String[] args)
	{
		Scanner input = new Scanner(System.in);
		int guess; // the user's guess
		createQuestion(); // display the first question
		System.out.print("Enter your answer (-1 to exit):");
		guess = input.nextInt();
		
		while (guess != -1)
		{
			// checks if the user answered correctly
			if (guess != answer)
				System.out.println(createResponse(false));
			else
			{
				System.out.println(createResponse(true));
				createQuestion();
			}
			System.out.print("Enter your answer (-1 to exit):");
			guess = input.nextInt();
		} // end while
	} // end method
	
	// prints a new question and stores the corresponding answer
	public static void createQuestion()
	{
		// get two random numbers between 1 and 9
		int digit1 = 1 + randomNumbers.nextInt(9);
		int digit2 = 1 + randomNumbers.nextInt(9);
		answer = digit1 * digit2;
		System.out.printf("How much is %d times %d?\n", digit1, digit2);
	} // end method createQuestion

	// create a new response
	public static String createResponse(boolean correct)
	{
		if (correct)
			switch (randomNumbers.nextInt(3))
			{
			case 0:
				return ("Very Good!");
			case 1:
				return ("Excellent!");
			case 2:
			default :
				return ("Keep up the good work!");
			} // end switch
		else // otherwise, assume incorrect
			switch (randomNumbers.nextInt(3))
			{
			case 0:
				return ("No. Please try again.");
			case 1:
				return ("Wrong. Try once more.");
			case 2:
			default:
				return ("No. Keep trying.");
			} // end switch
	} // end method createResponse
} // end class Multiply
