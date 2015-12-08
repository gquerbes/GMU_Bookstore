import java.util.LinkedList;

/**
 * This is the data definition class for the Students.
 * It will store the student information such as first and last name,
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
		

public class Student extends user {
	/**
	 * This method returns the total number of students using the Bookstore Reservation Application.
	 * @return numStudents (int)
	 */
    public static int getNumStudents() {
        return numStudents;
    }
    
    
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
        super(username);
        numStudents++;
    }
    
    /**
     * This method sets the student's shipping address
     * @param shippingAddress
     * @return boolean result
     */
    public Boolean setShippingAddress(String shippingAddress) {
        if(shippingAddress.length() == 0) {
            return false;
        }
        else {
        this.shippingAddress = shippingAddress;
        return true;
        }
    }
    public String getCourses() {
        String output = "";
        for(int i =0; i < courses.size(); i++) {
            output += courses.get(i).getCourseName() + "\n";
        }
        return output;
    }
    
    /**
     * This method returns the student's shipping address
     * @return shippingAddress
     */
    public String getShippingAddress() {
        return shippingAddress;
    }
    /**
     * Returns the linked list of courses
     * @return course list
     */
    public LinkedList<Course> getCourseList(){
    	return courses;
    }
    /**
     * This method returns basic student information, that includes student's name, Gnumber, and the list of courses.
     * @return basic student information
     */
    /**
     * This method adds a course to the current student's information
     * @param acourse
     */
    public void addCourse(Course acourse) {
        this.courses.add(acourse); 
        acourse.setTextStock(acourse.getTextStock()-1);
    }
    public String toString() {
        return "Student Name: " + getFirstName() + ", " + getLastName() + "\n"
                + "Student GNumber: " + getgNumber() + "\n"
                + "Student's list of Courses: " + getCourses();
    }
    
}