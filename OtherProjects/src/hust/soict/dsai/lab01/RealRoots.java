package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class RealRoots {
	public static void main(String[] args) throws Exception {
		do {
			String type = JOptionPane.showInputDialog(null,
					"Please enter 0 for linear equation, 1 for linear system or 2 for second-degree equation: ", 
					"Type of your equation",
					JOptionPane.INFORMATION_MESSAGE);
			
// linear equation
			if (type.equals("0")) { 
				String a, b;
				a = JOptionPane.showInputDialog(null,
						"Input the first coefficient:",
						"Input coefficients",
						JOptionPane.INFORMATION_MESSAGE);
				b = JOptionPane.showInputDialog(null,
							"Input the second coefficient:",
							"Input coefficients",
							JOptionPane.INFORMATION_MESSAGE);
				double coff_a = Double.parseDouble(a);
				double coff_b = Double.parseDouble(b);
				double root = 0;
				do {
					if (coff_a == 0) {
						a = JOptionPane.showInputDialog(null, 
								"Please choose another value for the first coefficient!", 
								"Error",
								JOptionPane.INFORMATION_MESSAGE);
						coff_a = Double.parseDouble(a);
					} else {
						root = (0-coff_b) / coff_a;
					}
				} while (coff_a == 0);	
				
				JOptionPane.showMessageDialog(null, 
						"Root: " + root, 
						"Show the result",
						JOptionPane.INFORMATION_MESSAGE);
				break;
// linear system
			} else if (type.equals("1")) { 
				Scanner sc = new Scanner(System.in);
				double a11 = sc.nextDouble();
				double a12 = sc.nextDouble();
				double b1 = sc.nextDouble();
				double a21 = sc.nextDouble();
				double a22 = sc.nextDouble();
				double b2 = sc.nextDouble();
			try {
				double D = (a11*a22) - (a21*a12);
				double D1 = (b1*a22) - (b2*a12);
				double D2 = (a11*b2) - (a21*b1);
				double x1 = D1/D;
				double x2 = D2/D;
				System.out.println("The solution of this linear system is:" + "\n" 
							+ "x1 = " + x1 + "\n" 
							+ "x2 = " + x2);
				} catch (ArithmeticException arithException){
					System.out.println("This linear system has infinite solutions or no solution.");
				}
				break;
// second degree equation
			} else if (type.equals("2")) {
				Scanner sc = new Scanner(System.in);
				double a = sc.nextDouble();
				double b = sc.nextDouble();
				double c = sc.nextDouble();
				try {
					if (a == 0d) {
						throw new Exception("The value of the first cofficient cannot be zero!");
					}
					double discriminant = b*b - 4*a*c;
					if (discriminant == 0d) {
						throw new Exception("The equation has a double root: x = " + -b/(2*a));
					} else if (discriminant < 0) {
						throw new Exception("The equation has no real solution!");
					}
					double sqrtDisc = Math.sqrt(discriminant);
					double x1 = (double)(-b + sqrtDisc)/(2*a);
					double x2 = (double)(-b - sqrtDisc)/(2*a);
					System.out.println("The equation has 2 distinct roots:\n"
							+ "x1 = " + x1 + "\n"
							+ "x2 = " + x2);
				}
				catch (Exception e) {
					System.out.print(e.getMessage());
				}
				break;
			} else {
				JOptionPane.showMessageDialog(null, "You've entered the wrong format!");
			}
		} while (true);
	}
}

		

