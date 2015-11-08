import javax.swing.JOptionPane;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Bookstore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		populateCourses();
		populateAccounts();
		
		
	}
	
	
	/**
	 * Open courses text file and populate courses based on info
	 */
	public static void populateCourses(){
		Scanner inputStream = null;
		
		try{
			inputStream = new Scanner (new FileInputStream ("courses.txt"));
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "The file \"courses.txt\" could not be found");
			JOptionPane.showMessageDialog(null, "The system will now exit");
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null, "courses file opened");
		//TODO create course objects using text file data
	}
	
	
	/**
	 * Open accounts file and create student accounts based on info
	 */
	public static void populateAccounts(){
		Scanner inputStream = null;
		
		try{
			inputStream = new Scanner (new FileInputStream("accounts.txt"));
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "The file \"accounts.txt\" could not be found");
			JOptionPane.showMessageDialog(null, "The system will now exit");
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null, "account file opened");
		//TODO create account objects based on text file info	
	}
	
	
	
	/**
	 * Create new account 
	 */
	public static void registerStudent(){
		String username;
		String password;
		do{
			username = JOptionPane.showInputDialog("Please enter desired username");
			if (!validateUsername(username)){
				JOptionPane.showMessageDialog(null, "This username is already in use!\nPlease try again");
			}
		}while (!validateUsername(username));
		
		password = JOptionPane.showInputDialog("Please enter desired password");
		
//		Student aStudent = new Student();
//		
//		aStudent.setFName(JOptionPane.showInputDialog("Please enter your first name"));
//		
//		aStudent.setLName(JOptionPane.showInputDialog("Please enter your last name"));
//		
//		aStudent.setGNum(JOptionPane.showInputDialog("Please enter your G-number"));
	}
	
	
	public static void login(){
		String username = JOptionPane.showInputDialog(null, "enter username");
		String password = JOptionPane.showInputDialog(null, "Please enter your password");
	}
	
	
	/**
	 * @return true / false if username is available
	 */
	public static boolean validateUsername(String username){
		boolean isValid = false;
		
		return isValid;
	}
	
	
	
	

}
