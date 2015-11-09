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
		populateStudentAccounts();
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
	public static void populateStudentAccounts(){
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
	public static void registerStudentAccount(){
		String username;
		String password;
		String first;
		String last;
		String GNum;
		String phoneNum;
		String email;
		String address;
		
		
		//prompt for username until available username is entered
		do{
			username = JOptionPane.showInputDialog("Please enter desired username");
			if (!validateUsername(username)){
				JOptionPane.showMessageDialog(null, "This username is already in use!\nPlease try again");
			}
		}while (!validateUsername(username));
		
		//create student object
		Student aStudent = new Student();
		
		//prompt for password until valid entry is given
		do{
			password = JOptionPane.showInputDialog("Please enter desired password");
			if(!aStudent.setPassword(password)){
				JOptionPane.showMessageDialog(null,"Password does not meet requirements \nTry Again.");
			}
		}while(!aStudent.setPassword(password));
		
		//prompt for first name until valid entry is made
		do{
			aStudent.setFName(JOptionPane.showInputDialog("Please enter your first name"));
			if (!aStudent.setFName(first)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again.");
			}
		}while(!aStudent.setFName(first));
		
		
		//prompt for last name until valid entry is made
		do{
			aStudent.setLName(JOptionPane.showInputDialog("Please enter your last name"));
			if (!aStudent.setLName(last)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setLName(last));
		
		//prompt for G-Number until valid entry is made
		do{
			aStudent.setGNum(JOptionPane.showInputDialog("Please enter your G-number"));
			if(!aStudent.setGNum(GNum)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setGNum(GNum));
		
		//prompt for phone number until valid entry is made
		do{
			aStudent.setPhoneNumber(JOptionPane.showInputDialog("Please enter your phone number"));
			if(!aStudent.setPhoneNumber(phoneNum)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setPhoneNumber(phoneNum));
				
		//prompt for email until valid entry is made
		do{
			aStudent.setEmail(JOptionPane.showInputDialog("Please enter your Email address"));
			if(!aStudent.setEmail(email)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setEmail(email));
		
		//prompt for address until valid entry is made
		do{
			aStudent.setShipAddress(JOptionPane.showInputDialog("Please enter your shipping address"));
			if(!aStudent.setShipAddress(address)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setShipAddress(address));
	}
	
	
	/**
	 * 
	 */
	public static void login(){
		String username = JOptionPane.showInputDialog(null, "Enter username");
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
