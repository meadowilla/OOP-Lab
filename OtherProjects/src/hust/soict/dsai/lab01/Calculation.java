package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class Calculation {
	public static void main(String[] args) {
		String strNum1, strNum2;
	
		String strSum = "Sum = ", strDiff = "Difference = ", strPr = "Product = ", strQuo = "Quotient = ";
	
		strNum1 = JOptionPane.showInputDialog(null, 
			"Please input the first number:",
			"Input Numbers", 
			JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		
		strNum2 = JOptionPane.showInputDialog(null, 
				"Please input the second number:",
				"Input Numbers", 
				JOptionPane.INFORMATION_MESSAGE);
		double num2 = Double.parseDouble(strNum2);
			
		double sum = num1 + num2;
		double diff = num1 - num2;
		if (diff <0) {
			diff = 0 - diff;
		}
		double pro = num1 * num2;
		double quo = num1 / num2;
		
		JOptionPane.showMessageDialog(null, 
				strSum + sum + "\n" + strDiff + diff + "\n"
				+ strPr + pro + "\n" + strQuo + quo + "\n", 
				"Show the results",
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
