
public class Course {

    public static int getNumCourses() {
        return numCourses;
    }
    private String courseName;
    private String courseID;
    private String courseText;
    private int textStock;

    private static int numCourses = 0;
    
    public Course(){
        this("","");
        numCourses++;
    }
    
    public Course(String name, String ID) {
        this.courseName = name;
        this.courseID = ID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseText(String courseText) {
        this.courseText = courseText;
    }

    public void setTextStock(int textStock) {
        this.textStock = textStock;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseText() {
        return courseText;
    }

    public int getTextStock() {
        return textStock;
    }
    
    
}
