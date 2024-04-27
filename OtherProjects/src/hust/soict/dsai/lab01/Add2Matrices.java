package hust.soict.dsai.lab01;
import java.util.Scanner;
public class Add2Matrices {
	public int[][] sumOfMatrices(int[][] a1, int[][] a2){
		int[][] a3 = new int [a1.length][a1[0].length];
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1[0].length; j++) {
				a3[i][j] = a1[i][j] + a2[i][j];
			}
		}
		return a3;
	}
	public void printMatrix(int[][] m) {
		System.out.println("The resulting matrix is: ");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Add2Matrices obj = new Add2Matrices();
		System.out.println("Do you want to use default matrices (enter 0) "
				+ "or input new matrices from your keyboard (enter any)?");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if (option == 0) {
			int[][] array1 = {{1, 3, 5, 7},
							{2, 4, 6, 8}};
			int[][] array2 = {{2, 5, 8, 9},
							{1, 7, 4, 6}};
			int [][] sumOfMatrices = new int [array1.length][array1[0].length];
			sumOfMatrices = obj.sumOfMatrices(array1, array2);
			obj.printMatrix(sumOfMatrices);
		}else {
			System.out.print("Please enter the size of arrays:");
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			int[][] array1 = new int [rows][cols];
			int[][] array2 = new int [rows][cols];
			int[][] sumOfMatrices = new int [rows][cols];
			System.out.println("Please enter each row of array 1: ");
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					array1[i][j] = sc.nextInt();
				}
			}
			System.out.println("Please enter each row of array 2: ");
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					array2[i][j] = sc.nextInt();
				}
			}
			sc.close();
			sumOfMatrices = obj.sumOfMatrices(array1, array2);
			obj.printMatrix(sumOfMatrices);
		}
	}
}

