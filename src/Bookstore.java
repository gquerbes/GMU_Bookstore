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
		LinkedList <Course> courseList = new LinkedList<Course>();
				
		populateCourses(courseList);
		
		//linked list of students
		LinkedList<Student> studentList = new LinkedList<Student>();
		
		//populate student accounts from file
		populateStudentAccounts(studentList);
		
		Student aStudent = login();
		
		//send current student to menu for textbook ordering
		menu(courseList, aStudent);
	}
	
	
	/**
	 * Open courses text file and populate courses based on info
	 */
	public static void populateCourses(LinkedList <Course> courseList){
		
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
		
		//pull line of text to generate a course
		while(inputStream.hasNextLine()){
			String s1 = inputStream.nextLine();
			//locate course name
			int courseNameStart = (s1.indexOf("-")+1);
			int courseNameEnd = (s1.lastIndexOf(","));
			String courseName = s1.substring(courseNameStart, courseNameEnd);
			//locate course text
			String courseText = (s1.substring(courseNameEnd +1));
			
			//create course from info
			Course aCourse = new Course (courseName);
			aCourse.setCourseText(courseText);
			
			//add course to list
			courseList.add(aCourse);
		}
		

		
		
	}
	
	
	/**
	 * Open accounts file and create student accounts based on info
	 */
	public static void populateStudentAccounts(LinkedList <Student> studentList){
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
			
		//Pull line of text to generate a student 
		while(inputStream.hasNextLine()){
			String s1 = inputStream.nextLine();		
			//locate first name
			int fNsameStart = (s1.indexOf("-")+1);
			int fNameEnd = (s1.indexOf(","));
			String fName = s1.substring(fNsameStart, fNameEnd);
			//locate Last name
			int lNameStart = (s1.indexOf(",", fNameEnd)+1);
			int lNameEnd = (s1.indexOf(",",lNameStart));
			String lName = s1.substring(lNameStart,lNameEnd);
			//locate gNumber
			int gNumberStart =(s1.indexOf(",",lNameEnd)+1);
			int gNumberEnd = (s1.indexOf(",",gNumberStart));
			String gNumber = s1.substring(gNumberStart, gNumberEnd);
			//locate password
			int passwordStart = (s1.indexOf(",",gNumberEnd)+1);
			int passwordEnd = (s1.indexOf(",",passwordStart));
			String password = s1.substring(passwordStart,passwordEnd);
			//locate phone number
			int phoneNumberStart = (s1.indexOf(",",passwordEnd+1));
			int phoneNumberEnd = (s1.indexOf(",",phoneNumberStart));
			String phoneNumber = s1.substring(phoneNumberStart,phoneNumberEnd);
			//locate email
			int emailStart = (s1.indexOf(",",phoneNumberEnd)+1);
			int emailEnd = (s1.indexOf(",",emailStart));
			String email = s1.substring(emailStart,emailEnd);
			//locate username
			int usernameStart = (s1.indexOf(",",emailEnd)+1);
			int usernameEnd = (s1.indexOf(",",usernameStart));
			String username = s1.substring(usernameStart, usernameEnd);
			//locate address
			int addressStart = (s1.indexOf(",",usernameEnd)+1);
			String address = s1.substring(addressStart);
			
			//create student object and populate info
			Student aStudent = new Student(username);
			aStudent.setFirstName(fName);
			aStudent.setLastName(lName);
			aStudent.setgNumber(gNumber);
			aStudent.setPassword(password);
			aStudent.setPhoneNumber(phoneNumber);
			aStudent.setEmail(email);
			aStudent.setShippingAddress(address);
			
			//add Student to list
			studentList.add(aStudent);			
		}
		
	}
	
	
	/**
	 * Prompt student with list of courses and add each on based on selection to their list of courses
	 * @param allCourses
	 * @param aStudent
	 */
	public static void menu (LinkedList<Course> courseList, Student aStudent){
		int selection = -1;
		boolean more;
		String menuPrompt = "Welcome to the GMU IT Bookstore!"
				+ "\nPlease enter the number that corresponds to one of your classes";
		for(int i =0; i<courseList.size(); i++){
			Course aCourse = courseList.get(i);
			menuPrompt += "\n"+ (i+1) +") "+ aCourse.getCourseName();
		}
		JOptionPane.showMessageDialog(null, courseList.get(0));
		do{
			do{
				try{
					selection = Integer.parseInt(JOptionPane.showInputDialog(menuPrompt));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid entry, please enter number associated with course");
				}
				if (selection > courseList.size() || selection <= 0){
					JOptionPane.showMessageDialog(null, "Invalid Selection. Try again.");
				}
			}while (selection > courseList.size() || selection <= 0);
			
			//add a course to student list of courses
			Course aCourse = (courseList.get(selection-1));
			aStudent.addCourse(aCourse);
			
			//prompt student if they would like to continue entering courses
			int reply  = JOptionPane.showConfirmDialog(null, "Do you have another class to enter?","title", JOptionPane.YES_NO_OPTION);
			if (reply ==0){more = false;}
			else more = true;
		}while (more);
		
	
	}
	
	
	/**
	 * Create new account 
	 */
	public static void registerStudentAccount(LinkedList <Student> studentList){
		String username ="";
		String password ="";
		String first ="";
		String last ="";
		String GNum ="";
		String phoneNum ="";
		String email ="";
		String address ="";
		
		
		//prompt for username until available username is entered
		do{
			username = JOptionPane.showInputDialog("Please enter desired username");
			if (!(validateUsername(username,studentList) == null)){
				JOptionPane.showMessageDialog(null, "This username is already in use!\nPlease try again");
			}
		}while (!(validateUsername(username,studentList) == null));
		
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
			aStudent.setFirstName(JOptionPane.showInputDialog("Please enter your first name"));
			if (!aStudent.setFirstName(first)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again.");
			}
		}while(!aStudent.setFirstName(first));
		
		
		//prompt for last name until valid entry is made
		do{
			aStudent.setLastName(JOptionPane.showInputDialog("Please enter your last name"));
			if (!aStudent.setLastName(last)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setLastName(last));
		
		//prompt for G-Number until valid entry is made
		do{
			aStudent.setgNumber(JOptionPane.showInputDialog("Please enter your G-number"));
			if(!aStudent.setgNumber(GNum)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setgNumber(GNum));
		
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
			aStudent.setShippingAddress(JOptionPane.showInputDialog("Please enter your shipping address"));
			if(!aStudent.setShippingAddress(address)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setShippingAddress(address));
		
		//TODO add student to linked list / stack
		
		JOptionPane.showMessageDialog(null, "Your account has been created");
		
		
	}
	
	
	/**
	 * 
	 */
	public static Student login(){
		Student aStudent = null;
		String username = JOptionPane.showInputDialog(null, "Enter username");
		String password = JOptionPane.showInputDialog(null, "Please enter your password");
		
		//Loop through users and look for match, If non found, use 'registerStudenAccount' method to create and return a student
		
		return aStudent;
	}
	
	
	/**
	 * @return return student if username matches or null if no match is found
	 */
	public static Student validateUsername(String username, LinkedList <Student> studentList){
		Student aStudent = null;
		for(int i =0; i < studentList.size(); i++){
			if (username.equals(studentList.get(i).getUsername())){
				aStudent = studentList.get(i);
				return aStudent;
			}
		}
		
		return aStudent;
	}
	
	
	public static boolean validatePassword (Student aStudent, LinkedList <Student> studentList){
		boolean isValid = false;
		
		return isValid;
	}
	
	
	

}
