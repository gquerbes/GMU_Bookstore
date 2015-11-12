import java.util.LinkedList;

/**
 * This is the data definition class for the Students.
 * It will store the student information such as first and last name,
 * GNumber, password, phone number, email address, username, and shipping address.
 * This class will also store student's enrolled courses.
 * @author Ishan Shams
 * @author Gabriel Querbes
 *
 */
		

public class Student {
	/**
	 * This method returns the total number of students using the Bookstore Reservation Application.
	 * @return numStudents (int)
	 */
    public static int getNumStudents() {
        return numStudents;
    }
    
    //Declaration
    private String firstName;
    private String lastName;
    private String gNumber;
    private String password;
    private String phoneNumber;
    private String email;
    private String username;
    private String shippingAddress;
    
    private int numCourses = 0;
    private LinkedList<Course> courses = new LinkedList<Course>();
    private static int numStudents = 0;
    
    //Default Constructor
    public Student() {
        this("");
    }
    //Specific Constructor
    public Student(String username) {
        this.username = username;
        numStudents++;
    }
    /**
     * This method sets student's first name
     * @param firstName
     * @return boolean result
     */
    public Boolean setFirstName(String firstName) {
        if (firstName.length() == 0) {
            throw new IllegalArgumentException("Student's first name is empty");
        }
        else {
            this.firstName = firstName;  
            return true;
        }
    }
    /**
     * This method sets student's last name
     * @param lastName
     * @return boolean result
     */
    public Boolean setLastName(String lastName) {
        if (lastName.length() == 0) {
        	throw new IllegalArgumentException("Student's last name is empty");
        }
        else {
            this.lastName = lastName;  
            return true;
        }
    }
    /**
     * This method return false if the user input is empty
     * @param inputCheck
     * @return true or false
     */
    private static boolean input(String inputCheck) {
        return inputCheck.trim().length() == 0;
        }
    /**
     * This method validates GNumber. User must enter 8 digits, or else this method will return false.
     * @param gNumber
     * @return boolean result
     */
    private boolean isValidgNumber(String gNumber) {
      if (gNumber.length() != 8) {
         return false;
      }
      else {
         for (int x = 0; x < gNumber.length(); x++) {
            
               if (!Character.isDigit(gNumber.charAt(x))) {
                  return false;
               }
            
         }
      }
      return true;
   }
    /**
     * This method validates phone number, if the phone number is not 10 digits long, then this method will return false.
     * @param phoneNumber
     * @return boolean result
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
      if (phoneNumber.length() != 10) {
         return false;
      }
      else {
         for (int x = 0; x < phoneNumber.length(); x++) {
            
               if (!Character.isDigit(phoneNumber.charAt(x))) {
                  return false;
               }
            
         }
      }
      return true;
   }

    /**
     * This method sets the GNumber.
     * @param gNumber
     * @return boolean result
     */
    public Boolean setgNumber(String gNumber) {
        if (!input(gNumber) && isValidgNumber(gNumber)) {
            this.gNumber = gNumber;
            return true;
        }
        else {
        	throw new IllegalArgumentException("Student's GNumber is invalid, it must be 8 digits (00xxxxxx");
        } 
    }
    /**
     * This methods sets the Password
     * @param password
     * @return boolean result
     */
    public Boolean setPassword(String password) {
        if (password.length() < 8) {
        	throw new IllegalArgumentException("Student's password must be atleast 8 characters long");
        }
        else {
           this.password = password;
           return true;
        }
        
    }
    /**
     * This method sets the student's phone number.
     * @param phoneNumber
     * @return boolean result
     */
    public boolean setPhoneNumber(String phoneNumber) {
        if (!input(phoneNumber) && isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return true;
        }
        else {
        	return false;
        } 
    }
    /**
     * This method sets the student's email address.
     * @param email
     * @return boolean
     */
    public boolean setEmail(String email) {
        char dot = '.';
        int ATposition = email.indexOf('@');
        int DOTposition = email.indexOf('.');
        
        if (ATposition > 0) {
            if(DOTposition > 0) {
                if (email.substring(0, ATposition).contains(".") || email.charAt(ATposition+1) == dot) {
                    throw new IllegalArgumentException("Sorry! Invalid position of the dot");
                }
                else {
                    this.email = email;
                    return true;
                }
            }
            else {
                throw new IllegalArgumentException("Sorry! You must enter a valid email.");
            }
        }
        else {
            throw new IllegalArgumentException("Sorry! You must enter a valid email.");
        }
    }
    /**
     * This method sets the student's shipping address
     * @param shippingAddress
     * @return boolean result
     */
    public Boolean setShippingAddress(String shippingAddress) {
        if(shippingAddress.length() == 0) {
        	throw new IllegalArgumentException("Sorry! You must enter a valid email address.");
        }
        else {
        this.shippingAddress = shippingAddress;
        return true;
        }
    }
    /**
     * This method sets the student's username
     * @param username
     * @return boolean result
     */
    public boolean setUsername(String username){
    	if (username.length() == 0){
    		throw new IllegalArgumentException("Sorry! You must enter a valid username.");
    	}
    	else{
    		this.username = username;
    		return true;
    	}
    }
    /**
     * This method adds a course to the current student's information
     * @param acourse
     */
    public void addCourse(Course acourse) {
        this.courses.add(acourse); 
        acourse.setTextStock(acourse.getTextStock()-1);
    }
    /**
     * This method returns the student's first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * This method returns the student's last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * This method returns the student's GNumber
     * @return gNumber
     */
    public String getgNumber() {
        return gNumber;
    }
    /**
     * This method returns the student's password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * This method returns the student's password
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * This method returns the student's email address
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * This method returns the student's shipping address
     * @return shippingAddress
     */
    public String getShippingAddress() {
        return shippingAddress;
    }
    /**
     * This method returns the student's username
     * @return username
     */
    public String getUsername(){
    	return username;
    }
    /**
     * This method returns the list of courses taken by the student
     * @return output
     */
    public String getCourses() {
        String output = "";
        for(int i =0; i < courses.size(); i++) {
            output += courses.get(i).getCourseName() + "\n";
        }
        return output;
    }
    /**
     * This method returns basic student information, that includes student's name, Gnumber, and the list of courses.
     * @return basic student information
     */
    public String toString() {
        return "Student Name: " + getFirstName() + ", " + getLastName() + "\n"
                + "Student GNumber: " + getgNumber() + "\n"
                + "Student's list of Courses: " + getCourses();
    }
    
}