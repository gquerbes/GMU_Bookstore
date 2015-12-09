import javax.swing.JOptionPane;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Bookstore {

	/**
	 * @author Gabriel Querbes
	 * @author Ishan Shams
	 * @param args
	 * This program is designed to allow students to order books via the system 
	 * for classes in the AIT department.
	 * The system will populate a list of users and courses along with corresponding information from 2 separate text files.
	 * When a student logs in or creates a new account they will be prompted to select the courses that they will be taking.
	 * Upon system termination, the program will output a text file documenting the number of books left and needed to be ordered.
	 */
	
	/**
	 * Create itemized list of input values to prevent errors during presentation
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create array of all courses
		LinkedList <Course> courseList = new LinkedList<Course>();
		populateCourses(courseList);
		
		//populate student accounts from file
		LinkedList<Student> studentList = new LinkedList<Student>();
		populateStudentAccounts(studentList);
		
		
		//take user to login screen
		//Student aStudent = login(studentList,courseList);
		
		login(studentList,courseList);
		
		//send current student to menu for textbook ordering
		//menu(courseList, aStudent, studentList);
		
		//outputs the textbook reservation to a file
		dataToFiles(courseList);
	}
	
	
	
	/**
	 * @param courseList
	 *Create all courses based on text file input
	 */
	public static void populateCourses(LinkedList <Course> courseList){
		
		Scanner inputStream = null;
		
		//open text file 
		try{
			inputStream = new Scanner (new FileInputStream ("courses.txt"));
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "The file \"courses.txt\" could not be found");
			JOptionPane.showMessageDialog(null, "The system will now exit");
			System.exit(0);
		}
		
		
		//pull line of text to generate a course
		while(inputStream.hasNextLine()){
			String s1 = inputStream.nextLine();
			//locate course name
			int courseNameStart = (s1.indexOf("-")+1);
			int courseNameEnd = (s1.indexOf(","));
			String courseName = s1.substring(courseNameStart,courseNameEnd);
			//locate course text
			int courseTextStart = (s1.indexOf(",",courseNameEnd)+1);
			int courseTextEnd = (s1.indexOf(",",courseTextStart));
			String courseText = (s1.substring(courseTextStart,courseTextEnd));
			//locate text stock
			int textStockStart = (s1.indexOf(",",courseTextStart)+1);
			int textStock = Integer.parseInt(s1.substring(textStockStart));
			
			//create course from info
			Course aCourse = new Course (courseName);
			aCourse.setCourseText(courseText);
			aCourse.setTextStock(textStock);
			
		
			//add course to list
			courseList.add(aCourse);
		}
	}
	
	
	public static boolean createAdmin(){
		User myAdmin = new Admin("Admin");
		myAdmin.setEmail("admin@admin.com");
		myAdmin.setFirstName("FirstAdmin");
		myAdmin.setLastName("lastAdmin");
		myAdmin.setgNumber("00800000");
		myAdmin.setPassword("abc12345");
		myAdmin.setPhoneNumber("5555555555");
	
		String username = JOptionPane.showInputDialog(null, "Enter admin username");
		
		String password = JOptionPane.showInputDialog(null, "Enter admin Password");
		
		if(username.equals(myAdmin.getUsername()) && password.equals(myAdmin.getPassword())){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	/**
	 * @param studentList
	 * Populate system with list of students accounts from text file
	 */
	public static void populateStudentAccounts(LinkedList <Student> studentList){
		Scanner inputStream = null;
		//open text file of accounts
		try{
			inputStream = new Scanner (new FileInputStream("accounts.txt"));
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "The file \"accounts.txt\" could not be found");
			JOptionPane.showMessageDialog(null, "The system will now exit");
			System.exit(0);
		}
		
			
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
			Student aStudent = new Student(username); //DIASABLE ONCE DDC HAS INHERITENCE
			//User aStudent = new Student(username); ENABLE ONCE DDC HAS INHERITENCE
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
	public static void menu (LinkedList<Course> courseList, User aUser, LinkedList <Student> studentList){
		int selection = -1;
		final int MAX_COURSES = 7;
		boolean more;
		
		//send user if admin to add course
		Student aStudent = new Student();
		if(aUser instanceof Student){
			aStudent = (Student) aUser;
			String menuPrompt = "Welcome to the GMU IT Bookstore!"
					+ "\nPlease enter the number that corresponds to one of your classes";
			for(int i =0; i<courseList.size(); i++){
				Course aCourse = courseList.get(i);
				menuPrompt += "\n"+ (i+1) +") "+ aCourse.getCourseName();
			}
			
			do{
				do{
					try{
						selection = Integer.parseInt(JOptionPane.showInputDialog(menuPrompt));
						
						if (selection > courseList.size() || selection <= 0){
							throw new IllegalArgumentException();
							
						}
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Invalid entry, please enter number associated with course");
						selection = -1;
					}
					catch(IllegalArgumentException e) {
						JOptionPane.showMessageDialog(null, "Invalid Selection. Try again.");
						selection = -1;
					}
					
				}while (selection > courseList.size() || selection <= 0);
				
				//add a course to student list of courses if its not already added to student's courses
				if(aStudent.getCourseList().contains(courseList.get(selection-1))){
					JOptionPane.showMessageDialog(null,"You have already ordered this book");
				}
				else if(aStudent.getCourseList().size() >= MAX_COURSES){
					JOptionPane.showMessageDialog(null,"You have already registered "+ MAX_COURSES + " courses, the max number allowed");
					break;
				}
				else{
					if(courseList.get(selection-1).getTextStock()<1){
						JOptionPane.showMessageDialog(null,"This book is backordered and will take extra processing time");
					}
					Course aCourse = (courseList.get(selection-1));
					aStudent.addCourse(aCourse);	
					JOptionPane.showMessageDialog(null, courseList.get(selection-1).getCourseText() +" Has been added to your cart");
				}
				
				
				//prompt student if they would like to continue entering courses
				int reply  = JOptionPane.showConfirmDialog(null, "Do you have another class to enter?","title", JOptionPane.YES_NO_OPTION);
				if (reply == 1){more = false;}
				else {more = true;}
			}while (more && (aStudent.getCourseList().size() <= MAX_COURSES));
			
			//Give confirmation of order
			JOptionPane.showMessageDialog(null, "Your order has been entered\n");
		}
		else{
			Admin tempAdmin;
			addCourse (courseList);
		}
		
		
		
		//return user to login screen
		login(studentList,courseList);
		
	
	}
	
	public static void addCourse(LinkedList<Course> courseList){
		
		String courseName ="";
		String courseText="";
		int textStock = -1;
		
		Course aCourse = new Course();
		do{
			do{
				courseName = JOptionPane.showInputDialog("Please enter the course name in the format ITXXX (where XXX are numbers");
				if(!aCourse.setCourseName(courseName)) {
					JOptionPane.showMessageDialog(null, "The course name must be atleast 5 characters long in this format: ITXXX", "Invalid Course Name", JOptionPane.ERROR_MESSAGE);
				}
			}while(!(aCourse.setCourseName(courseName)));
			
			do{
				courseText = JOptionPane.showInputDialog("Please enter the textbook name for " + courseName);
				if(!aCourse.setCourseText(courseText)) {
					JOptionPane.showMessageDialog(null, "Invalid course text", "Invalid Course Text", JOptionPane.ERROR_MESSAGE);
				}
			}while(!(aCourse.setCourseText(courseText)));
			
			do{
				try{
					textStock = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the books in stock"));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null,"The number of books in stock must be a numerical value");
				}
			}while((!aCourse.setTextStock(textStock)));
			
			courseList.add(aCourse);	
		}while (JOptionPane.showConfirmDialog(null, "addAnother")== 0);
		
		
	}
	
	/**
	 * @param studentList
	 * @return Student
	 * Register new student by prompting them for user info
	 */
	public static Student registerStudentAccount(LinkedList <Student> studentList){
		String username ="";
		String password ="";
		String first ="";
		String last ="";
		String GNum ="";
		String phoneNum ="";
		String email ="";
		String address ="";
		Student aStudent=null;
		
		//prompt for username until available username is entered
		do{
			username = JOptionPane.showInputDialog("Please enter desired username");
			aStudent = validateUsername(username,studentList);
			if (aStudent != null){
				JOptionPane.showMessageDialog(null, "This username is already in use!\nPlease try again");
			}
		}while (aStudent != null);
		
		//create student object
		 aStudent = new Student(username);
		
		
		//prompt for password until valid entry is given
		do{
			password = JOptionPane.showInputDialog("Please enter desired password");
			if(!aStudent.setPassword(password)){
				JOptionPane.showMessageDialog(null,"Password does not meet requirements. Minimum 8 characters\nTry Again.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}while(!aStudent.setPassword(password));
		
		//prompt for first name until valid entry is made
		do{
			first = JOptionPane.showInputDialog("Please enter your first name");
			if (!aStudent.setFirstName(first)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again.");
			}
		}while(!aStudent.setFirstName(first));
		
		
		//prompt for last name until valid entry is made
		do{
			last = (JOptionPane.showInputDialog("Please enter your last name"));
			if (!aStudent.setLastName(last)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setLastName(last));
		
		//prompt for G-Number until valid entry is made
		do{
			GNum = (JOptionPane.showInputDialog("Please enter your G-number"));
			if(!aStudent.setgNumber(GNum)){
				JOptionPane.showMessageDialog(null, "Invalid entry! Please write your GNumber in this format 00XXXXXX \nPlease try again", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}while(!aStudent.setgNumber(GNum));
		
		//prompt for phone number until valid entry is made
		do{
			phoneNum = (JOptionPane.showInputDialog("Please enter your phone number"));
			if(!aStudent.setPhoneNumber(phoneNum)){
				JOptionPane.showMessageDialog(null, "Invalid entry. Please write your phone number in XXXXXXXXXX format \nPlease try again","Error", JOptionPane.ERROR_MESSAGE);
			}
		}while(!aStudent.setPhoneNumber(phoneNum));
				
		//prompt for email until valid entry is made
		do{
			email = (JOptionPane.showInputDialog("Please enter your Email address"));
			if(!aStudent.setEmail(email)){
				JOptionPane.showMessageDialog(null, "Invalid entry, correct format: abc@efg.com \nPlease try again","Error", JOptionPane.ERROR_MESSAGE);
			}
		}while(!aStudent.setEmail(email));
		
		//prompt for address until valid entry is made
		do{
			address = (JOptionPane.showInputDialog("Please enter your shipping address"));
			if(!aStudent.setShippingAddress(address)){
				JOptionPane.showMessageDialog(null, "Invalid entry \nPlease try again");
			}
		}while(!aStudent.setShippingAddress(address));
		
		
		
		JOptionPane.showMessageDialog(null, "Your account has been created");
		try { 
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("accounts.txt", true)));
			
	                pw.println("\r\n-"+aStudent.getFirstName() +","+aStudent.getLastName() +","+aStudent.getgNumber()+","+aStudent.getPassword()+","+aStudent.getPhoneNumber() +","+aStudent.getEmail()+","+aStudent.getUsername() +","+aStudent.getShippingAddress());
	         	    pw.close();
	         
		}
			 catch (IOException e) {
				 e.printStackTrace();
			 }
		
		studentList.add(aStudent);
		return aStudent;
	}
	
	

	/**
	 * @param studentList
	 * @return student
	 * Prompt username and password and find match, if no match give user option to create a new account
	 */
	public static void login(LinkedList <Student> studentList,LinkedList<Course> courseList){
		//Prompt user to login or terminate systems
		
		String input = "";
		do{
			input = JOptionPane.showInputDialog("Enter 1 to login, 2 for admin course addition, or 3 to exit system");
			
			if (input.equals("3")){
				JOptionPane.showMessageDialog(null, "Goodbye");
				dataToFiles(courseList);
			}
			else if(input.equals("2")){
				if(createAdmin()){
					addCourse(courseList);
				}
				else{
					JOptionPane.showMessageDialog(null, "incorrect credentials");
					login(studentList,courseList);
				}
				
			}
			else if (input.equals("1")){}
			else {JOptionPane.showMessageDialog(null,"Invalid selection, Try again.");}
		}while (!(input.equals("1")));
		
		String username = JOptionPane.showInputDialog(null, "Enter username");
		String password = JOptionPane.showInputDialog(null, "Please enter your password");
		Student aStudent = validateUsername(username,studentList);

		//Loop through users and look for match, If non found, use 'registerStudenAccount' method to create and return a student
		if(aStudent == null){
			int selection = JOptionPane.showConfirmDialog(null, "Account does not exist\nWould you like to create a new account?\n'NO' to try another account 'YES' to create a new account","title", JOptionPane.YES_NO_OPTION);
			if(selection == 1){
				login(studentList,courseList);
			}
			else if (selection == 0){
				aStudent = registerStudentAccount(studentList);
			}
		}
		//Alert use of incorrect passwords
		else{
			if (!(validatePassword(aStudent,password))){
				do{
					password = JOptionPane.showInputDialog("Incorrect password entered\nTry again or enter 'D' to return to main screen");
					if(password.equalsIgnoreCase("D")){
						login(studentList,courseList);
					}
				}while(!(validatePassword(aStudent,password)));
				
			}
		}
		//if (aStudent.instancOf())
		menu(courseList,aStudent,studentList);
		
	}
	
	
	
	/**
	 * @param username
	 * @param studentList
	 * @return student
	 * Validate if user account exists
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
	
	
	/**
	 * @param aStudent
	 * @param aPassword
	 * @return if valid
	 * validate if password matches the user
	 */
	public static boolean validatePassword (Student aStudent, String aPassword){
		boolean isValid = false;
		if (aStudent.getPassword().equals(aPassword)){
			isValid = true;
		}
		else {isValid = false;}
		return isValid;
	}
	
	
	/**
	 * @param courseList
	 * This method is going to export data into text files
	 */
	public static void dataToFiles(LinkedList<Course> courseList){
		try { 
		PrintWriter pw = new PrintWriter(new FileOutputStream("stockUpdate.txt"));
		 
         for(int i = 0; i < courseList.size(); i++) {
             if(courseList.get(i) != null) 
                pw.write("Course name: "+courseList.get(i).getCourseName() +" Text: " + courseList.get(i).getCourseText() +", and the stock remaining: "+courseList.get(i).getTextStock() + "\r\n");
             	
         }
         pw.close();
         JOptionPane.showMessageDialog(null, "The textbook stock is stored in a text file.", "GMU BookStore", JOptionPane.INFORMATION_MESSAGE);
		 }
		 catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
		System.exit(0);
	}
	

}
