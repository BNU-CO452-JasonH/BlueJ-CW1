/**
 * The Course class represents a course in the course database. 
 * It holds information on the course including its title and code number,
 * as well as its modules.
 *
 * @author Jason Huggins
 * @version 16/10/2020
 */
public class Course
{
    // the code number of the course
    private String codeNumber;
    // the title of the course
    private String title;
    
    // objects from the Module class modelling the four modules in a course
    private Module moduleOne;
    private Module moduleTwo;
    private Module moduleThree;
    private Module moduleFour;

    /**
     * Creates a new course with a given code number and title.
     */
    public Course(String codeNo, String courseTitle)
    {
        codeNumber = codeNo;
        title = courseTitle;
    }
    
    /**
     * Adds a module to the course (only 4 modules can be added to a module).
     * If a number not in the range of 1-4 is inputted, an error message
     * will be displayed, stating that the input is invalid.
     * @param module The module to be added to the course.
     * @param moduleNo The number the module is corresponding to.
     */
    public void addModule(Module module, int moduleNo)
    {
        if (moduleNo == 1) 
        {
            moduleOne = module;
        }
        else if (moduleNo == 2)
        {
            moduleTwo = module;
        }
        else if (moduleNo == 3)
        {
            moduleThree = module;
        }
        else if (moduleNo == 4) 
        {
            moduleFour = module;
        }
        else
        {
            System.out.println("Invalid module number inputted. " + 
                "Only four modules can be added to a course. " + 
                "Acceptable inputs are integers in the range 1-4.");
        }
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