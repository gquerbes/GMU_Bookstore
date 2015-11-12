/**
 * This is the data definition class that stores course information,
 * such as course name, textbook required for the course, and the current stock of the textbook.
 * @author Ishan Shams
 * @author Gabriel Querbes
 */
public class Course {
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
    public Boolean setCourseName(String courseName) {
    	if(courseName.length() == 0) {
    		throw new IllegalArgumentException("Course Name can't be empty.");
    	}
    	else {
    		this.courseName = courseName;
    		return true;
    	}
        
    }

    /**
     * This method sets the course text.
     * @param courseText
     */
    public Boolean setCourseText(String courseText) {
    	if(courseText.length() == 0) {
    		throw new IllegalArgumentException("Textbook name can't be empty");
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
    public void setTextStock(int textStock) {
    	
    		this.textStock = textStock;
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
    /**
     * This method validates text stock
     * @param textStock
     * @return boolean result
     */
    private boolean isValidTextStock(String textStock) {
        
           for (int x = 0; x < textStock.length(); x++) {
              
                 if (!Character.isDigit(textStock.charAt(x))) {
                    return false;
                 }
              
           }
        
        return true;
     }

    
}
