package hust.soict.dsai.lab01;
import java.util.Scanner;
public class Triangle {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(" ".repeat(n-i) 
					+ "*".repeat(i*2 + 1) 
					+ " ".repeat(n-i));
		}
	}
}

