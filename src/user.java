import java.util.LinkedList;
/**
 * This is the data definition class for the Users.
 * It will store the user information such as first and last name,
 * GNumber, password, phone number, email address, username, and shipping address.
 * This class will also store student's enrolled courses.
 * 
 * 
 * INCLUDE READ ME FILE WITH INSTRUCTIONS FOR PROFESSOR SO SHE CAN SEE THE CHANGES FROM
 * THE FIRST PRESENTATION, AND HOW TO TEST THEM
 * 
 * 
 * @author Ishan Shams
 * @author Gabriel Querbes
 *
 */
public abstract class User {

	/**
	 * This method returns the total number of students using the Bookstore Reservation Application.
	 * @return numStudents (int)
	 */
    public static int getNumUsers() {
        return numUsers;
    }
    
    private static int numUsers = 0;
	private String firstName;
    private String lastName;
    private String gNumber;
    private String password;
    private String phoneNumber;
    private String email;
    private String username;
	
    public User() {
    	this("");
    }
    public User(String username) {
    	this.username = username;
    }
    /**
     * This method sets student's first name
     * @param firstName
     * @return boolean result
     */
    public Boolean setFirstName(String firstName) {
        if (firstName.length() == 0) {
            return false;
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
            return false;
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
            return false;
        } 
    }
    /**
     * This methods sets the Password
     * @param password
     * @return boolean result
     */
    public Boolean setPassword(String password) {
        if (password.length() < 8) {
            return false;
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
    public Boolean setPhoneNumber(String phoneNumber) {
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
    public Boolean setEmail(String email) {
        if(email.contains("@")&&(email.contains("."))&&(email.indexOf('@') < email.indexOf('.'))) {
        this.email = email;
        return true;
        }
        else {
            return false;
        }
        
    }
    /**
     * This method sets the student's username
     * @param username
     * @return boolean result
     */
    public boolean setUsername(String username){
    	if (username.length() == 0){
    		return false;
    	}
    	else{
    		this.username = username;
    		return true;
    	}
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
    
}
