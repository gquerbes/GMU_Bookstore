/**
 * This is the data definition class that stores course information,
 * such as course name, textbook required for the course, and the current stock of the textbook.
 * @author Ishan Shams
 * @author Gabriel Querbes
 */
public class Course extends User{
	/**
	 * This method returns the total number of courses added by the students.
	 * @return numCourses
	 */
    public static int getNumCourses() {
        return numCourses;
    }
    //Declaration
    private String courseName;
    private String courseText;
    private int textStock;

    private static int numCourses = 0;
    
    //Default Constructor
    public Course(){
        this("");
        
    }
    //Specific Constructor
    public Course(String name) {
        this.courseName = name;
        numCourses++;
    }
    /**
     * This method set the course name.
     * @param courseName
     */
    public boolean setCourseName(String courseName) {
    	if(courseName.length()==5){
    		this.courseName = courseName;
    		return true;
    	}
    	else{
    		return false;
    	}
        
    }

    /**
     * This method sets the course text.
     * @param courseText
     */
    public boolean setCourseText(String courseText) {
    	if (courseText.length() <= 0) {
    		return false;
    	}
    	else {
        this.courseText = courseText;
        return true;
    	}
    }
    /**
     * This method sets the textbook stock
     * @param textStock
     */
    public boolean setTextStock(int textStock) {
        this.textStock = textStock;
        return true;
    }
    /**
     * This method returns the course name
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method returns the textbook name
     * @return courseText
     */
    public String getCourseText() {
        return courseText;
    }
    /**
     * This method returns the text stock
     * @return textStock
     */
    public int getTextStock() {
        return textStock;
    }
    
    
}
