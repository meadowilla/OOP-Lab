// consider the security with inherent or getter/setter...
package hust.soict.dsai.lab01;
import java.util.Scanner;
public class DaysOfMonth {
	String[] options = {"", "January", "Febuary", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December",
			"", "Jan.", "Feb.", "Mar.", "Apr.", "May", "June",
			"July", "Aug", "Sept.", "Oct.", "Nov.", "Dec.",
			"", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
			"Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
			"", "1", "2", "3", "4", "5", "6", 
			"7", "8", "9", "10", "11", "12"};
	String month, year;
	public static void main(String [] args) {
		int mn = 0, yr = -1;
		DaysOfMonth input = new DaysOfMonth();
		Scanner sc = new Scanner(System.in);
		// input month and return month (mn) *type integer
		do {
			System.out.print("Enter month: ");
			input.month = sc.next();
			try {
				mn = input.identifyMonth(input.month);
			}
			catch (Exception e){
				System.out.println("The format of the month input is wrong. Please enter another value!");
			} 
			finally {
				if (mn != 0) {
					break;
				};
			}
		} while (true);
		// input year and return year (yr) type boolean (0: leap, 1: common)
		do {
			System.out.print("Enter year: ");
			input.year = sc.next();
			try {
				yr = input.classifyYear(input.year);
			} catch (Exception e) {
				System.out.println("The format of the year input is wrong. Please enter another value!");
			} finally {
				if (yr != -1) {
					break;
				}
			}
		} while (true);
		input.numberOfDays(mn, yr); // print the number of days in the given month
	}
	
	public int identifyMonth(String m) throws Exception {
		int pos = 0;
		boolean check = false;
		for (int i = 1; i < options.length; i++) {
			if (m.equals(options[i])) {
				check = true;
				pos = i;
				break;
			}
		}
		if (check == false) {
			throw new Exception ("hic");
		}
		return pos % 13;
	}
	
	public int classifyYear(String y0) throws Exception {
		int y = -1;
		y = Integer.parseInt(y0);
		if (y % 4 != 0) {
			return 1; // common year
		} else if ((y % 100 == 0)&(y % 400 != 0)) {
			return 1; // common year
		} else {
			return 0; // leap year
		}
	}
	public void numberOfDays(int mn, int yr) {
		switch (mn) {
		case 1:	System.out.println("There are 31 days in the given month.");
				break;
		case 2: if (yr == 0) {
				System.out.println("There are 28 days in the given month.");
				break;
			} else {
				System.out.println("There are 29 days in the given month.");
				break;
			}
		case 3: System.out.println("There are 31 days in the given month.");
				break;
		case 4: System.out.println("There are 30 days in the given month.");
				break;
		case 5: System.out.println("There are 31 days in the given month.");
				break;
		case 6: System.out.println("There are 30 days in the given month.");
				break;
		case 7: System.out.println("There are 31 days in the given month.");
				break;
		case 8: System.out.println("There are 31 days in the given month.");
				break;
		case 9: System.out.println("There are 30 days in the given month.");
				break;
		case 10: System.out.println("There are 31 days in the given month.");
				break;
		case 11: System.out.println("There are 30 days in the given month.");
				break;
		case 12: System.out.println("There are 31 days in the given month.");
				break;
		}
	}
}

