import java.util.Scanner;
import java.util.Random;

public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		long k = 0;
		int count = 0;
		count = 5 * n + 1;
		Random randomGenerator = new Random();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of dices: ");
		n = input.nextInt();
		System.out.print("Enter number of rolls: ");
		k = input.nextInt();
		System.out.println("Sum\t" + "Frequency\t" + "Percentage");
		int[] dice = new int[count];
		double[] result = new double[count];
		for (int i = 1; i < k + 1; i++) {
			int randomInt = randomGenerator.nextInt(6 * n + 1);
			for (int j = n; j < count; j++) {
				if (j == randomInt) {
					dice[j - n]++;
				}
			}
		}
		for (int i = 3 * n; i < 6 * n + 1; i++) {
			System.out.print(i + '\t' + dice[i - 3 * n] + '\t');
			result[i - 3 * n] = dice[i - 3 * n] / k * 100;
			System.out.format("%.2f%n", result[i - 3 * n]);

		}
	}

}
