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
		
		//create array of all courses
		Course[] allCourses = populateCourses();
		
		//populate student accounts from file
		populateStudentAccounts();
		
		Student aStudent = login();
		
		//send current student to menu for textbook ordering
		menu(aStudent, allCourses);
	}
	
	
	/**
	 * Open courses text file and populate courses based on info
	 */
	public static Course[] populateCourses(){
		Course[] allCourses = new Course[20];
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
		
		
		return allCourses;
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
	 * Prompt student with list of courses and add each on based on selection to their list of courses
	 * @param allCourses
	 * @param aStudent
	 */
	public static void menu (Course [] allCourses, Student aStudent){
		int selection;
		boolean more;
		String menuPrompt = "Welcome to the GMU IT Bookstore!"
				+ "\nPlease enter the number that corresponds to one of your classes";
		for(int i =0; i<Course.getNumCourses(); i++){
			menuPrompt += "\n"+ (i+1) +") "+ allCourses[i].getCourseName();
		}
		
		do{
			do{
				try{
					selection = Integer.parseInt(JOptionPane.showInputDialog(menuPrompt));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid entry, please enter number associated with course");
				}
			}while (selection >= Course.getNumCourses() || selection < 0);
			
			//add a course to student list of courses
			aStudent.addCourse(allCourses[selection]);
			
			//prompt student if they would like to continue entering courses
			int reply  = JOptionPane.showConfirmDialog(null, "Do you have another class to enter?","title", JOptionPane.YES_NO_OPTION);
			if (reply ==0){more = false;}
			else more = true;
		}while (more);
		
	
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
		Student aStudent = new Student(username);
		
		
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
		
		//TODO add student to linked list / stack
		
		JOptionPane.showMessageDialog(null, "Your account has been created");
		
		
	}
	
	
	/**
	 * 
	 */
	public static Student login(){
		Student aStudent;
		String username = JOptionPane.showInputDialog(null, "Enter username");
		String password = JOptionPane.showInputDialog(null, "Please enter your password");
		
		//Loop through users and look for match, If non found, use 'registerStudenAccount' method to create and return a student
		
		return aStudent;
	}
	
	
	/**
	 * @return true / false if username is available
	 */
	public static boolean validateUsername(String username){
		boolean isValid = false;
		
		return isValid;
	}
	
	
	
	

}
