import java.util.Scanner;
import java.util.Random;

public class Minesweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Random randomNumbers = new Random(); // make Random
		int row; // Input row
		int col; // Input columns
		int n; // number of bombs
		int count = 0; // count the number of bombs
		int temp_row = 0; // temporarily save the bomb's row
		int temp_col = 0; // temporarily save the bomb's columns
		System.out.print("Enter the number rows: ");
		row = input.nextInt();
		System.out.print("Enter the number of columns: ");
		col = input.nextInt();
		System.out.print("Enter the number of bomb: ");
		n = input.nextInt();
		System.out.println("This is bomb map:");
		String[][] mines = new String[row][col]; // see where is bombs and make a matrix
		int[][] Findmines = new int[row][col]; // calculate the number of bombs and make a matrix
		for (int i = 0; i < row; i++)// initialize the bomb map
		{
			for (int j = 0; j < col; j++) {
				mines[i][j] = "-";   
			}

		}

		while (count != n) // Define random positions for n bombs
		{
			count = 0;
			temp_row = randomNumbers.nextInt(row);
			temp_col = randomNumbers.nextInt(col);
			mines[temp_row][temp_col] = "*";
			for (int i = 0; i < row; i++)// make the matrix
			{
				for (int j = 0; j < col; j++) {
					if (mines[i][j] == "*") {
						count++;
					}
				}

			}
		}
		for (int i = 0; i < row; i++) {    //calculate the number bomb near by
			for (int j = 0; j < col; j++) {  // 8 cases to check where is bomb near by
				// [i-1][j-1]
				if (i > 0 && j > 0) {
					if (mines[i - 1][j - 1] == "*") {
						Findmines[i][j]++;
					}
				}
				// [i-1][j]
				if (i > 0) {
					if (mines[i - 1][j] == "*") {
						Findmines[i][j]++;
					}
				}
				// [i-1][j+1]
				if (i > 0 && j < col - 1) {
					if (mines[i - 1][j + 1] == "*") {
						Findmines[i][j]++;
					}
				}
				// [i][j-1]
				if (j > 0) {
					if (mines[i][j - 1] == "*") {
						Findmines[i][j]++;
					}
				}
				// [i][j+1]
				if (j < col - 1) {
					if (mines[i][j + 1] == "*") {
						Findmines[i][j]++;
					}
				}
				// [i+1][j-1]
				if (i < row - 1 && j > 0) {
					if (mines[i + 1][j - 1] == "*") {
						Findmines[i][j]++;
					}
				}
				// [i+1][j]
				if (i < row - 1) {
					if (mines[i + 1][j] == "*") {
						Findmines[i][j]++;
					}
				}
				// [i+1][j+1]
				if (i < row - 1 && j < col - 1) {
					if (mines[i + 1][j + 1] == "*") {
						Findmines[i][j]++;
					}
				}
			}
		}

		for (int i = 0; i < row; i++) {  // show bomb map
			for (int j = 0; j < col; j++) {
				if (mines[i][j] == "*") {  //show where are bombs
					System.out.print("*");
				} else if (mines[i][j] == "-" && Findmines[i][j] == 0) {  // show "-" there are no bombs near by
					System.out.print(mines[i][j]);
				} else {  // show where are bombs near by()
					System.out.print(Findmines[i][j]);
				}
			}
			System.out.println();
		}

	}

}
