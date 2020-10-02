
/**
 * The Course class represents a course in the course database. 
 * It holds information on the course including its title and code number.
 *
 * @author Jason Huggins
 * @version 02/10/2020
 */
public class Course
{
    // the code number of the course
    private String codeNumber;
    // the title of the course
    private String title;

    /**
     * Creates a new course with a given code number and title.
     */
    public Course(String codeNo, String courseTitle)
    {
        codeNumber = codeNo;
        title = courseTitle;
    }
    
    /**
     * Returns the code number of this course.
     */
    public String getCodeNumber()
    {
        return codeNumber;
    }
    
    /**
     * Returns the title of this course.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Prints the course's title and code number to the output terminal.
     */
    public void print() 
    {
        System.out.println(codeNumber + ", " + title);
    }
}
