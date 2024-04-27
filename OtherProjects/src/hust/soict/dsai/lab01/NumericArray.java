package hust.soict.dsai.lab01;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class NumericArray {
	
	public static void main(String [] args) {
		Object[] options = {"Default", "New input"};
		int customizedOption = JOptionPane.showOptionDialog(
				null, 
				"Do you want to use default array or input new array from your keyboard?",
				null, 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				options, 
				null); 
		JOptionPane.showMessageDialog(null, "You've chosen: "
				+ (customizedOption == JOptionPane.YES_OPTION?"Default":"New input"));
		if (customizedOption == 0) {
			int sum = 0;
			int [] numericArray = {1789, 2035, 1899, 1456, 2013};
			int n = numericArray.length;
			Arrays.sort(numericArray);
			for (int i = 0; i < n; i++) {
				sum += numericArray[i];
			}
			System.out.println("Sorted array: " + Arrays.toString(numericArray));
			System.out.println("Sum = " + sum);
			System.out.println("Average value = " + sum/n);
		}else {
			int n = 0;
			do {
				String str_n = JOptionPane.showInputDialog(null,
						"Please input the length of your array: ",
						"Input",
						JOptionPane.INFORMATION_MESSAGE);
				try {
					n = Integer.parseInt(str_n);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "The format of length is wrong. Please enter another value!");
				} finally {
					if (n != 0) {
						break;
					}
				}
			} while (true);
			int[] numericArray = new int[n]; 
			int sum = 0;
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < n; i++) {
				numericArray[i] = sc.nextInt(); 
				sum += numericArray[i];
			}
			Arrays.sort(numericArray);
			System.out.println("Sorted array: " + Arrays.toString(numericArray));
			System.out.println("Sum = " + sum);
			System.out.println("Average value = " + sum/n);
		}
	}
}

