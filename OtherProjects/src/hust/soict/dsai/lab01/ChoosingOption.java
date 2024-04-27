package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		// customize options "Yes" and "No"
		int option = JOptionPane.showConfirmDialog(
				null, 
				"Do you want to change to the first class ticket?",
				null, 
				JOptionPane.YES_NO_OPTION); 
		JOptionPane.showMessageDialog(null, "You've chosen: " 
				+ (option == JOptionPane.YES_OPTION?"Yes":"No"));
//		JOptionPane.showMessageDialog(null, "You've chosen: " 
//				+ option);
		
		// customize options "I do" and "I don't"
		Object[] options = {"I do", "I don't"};
		int customizedOption = JOptionPane.showOptionDialog(
				null, 
				"Do you want to change to the first class ticket?",
				null, 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				options, 
				null); 
		JOptionPane.showMessageDialog(null, "You've chosen: "
				+ (customizedOption == JOptionPane.YES_OPTION?"I do":"I don't"));	
		
		System.exit(0);
	}
}
// After users choose "Cancel", in the next command,
// option is checked if it is "Yes", then return "Yes",
// otherwise return "No".
// We have "Cancel" is different from "Yes", so the return is "No".

// By adding 2 arguments (null, JOptionPane.YES_OPTION) into the JOptionPane.showConfirmDialog,
// we can customize the options including "Yes" and "No".

// In order to customize options like "I do" or "I don't",
// we can use JOptionPane.showOptionDialog.
