/**
 * The Course class represents a course in the course database. 
 * It holds information on the course including its title and code number,
 * as well as its modules.
 *
 * @author Jason Huggins
 * @version 26/10/2020
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
    
    // the final mark calculated for the course
    private int finalMark;
    // the final grade calculated for the course
    private String finalGrade;

    /**
     * Creates a new course with a given code number and title.
     * @param codeNo The code number of the course.
     * @param courseTitle The title of the course.
     */
    public Course(String codeNo, String courseTitle)
    {
        codeNumber = codeNo;
        title = courseTitle;
        
        finalMark = 0;
        finalGrade = null;
    }
    
    /**
     * @return The code number of this course.
     */
    public String getCodeNumber()
    {
        return codeNumber;
    }
    
    /**
     * @return The title of this course.
     */
    public String getTitle()
    {
        return title;
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
     * Checks whether all four modules have been completed and if so, the
     * course's final mark is calculated.
     */
    public void courseCompleted()
    {
        if ((moduleOne.isCompleted()) && (moduleTwo.isCompleted()) &&
            (moduleThree.isCompleted()) && (moduleFour.isCompleted())) 
        {
            calculateFinalMark();
        }
    }
    
    /**
     * Calculates the final mark for this course by finding the sum of 
     * the total mark and dividing it by the number of modules (i.e. 4).
     */
    public void calculateFinalMark()
    {
        int totalMark = moduleOne.getMark() + moduleTwo.getMark() +
            moduleThree.getMark() + moduleFour.getMark();
            
        finalMark = totalMark / 4;
    }
    
    /**
     * Calculates the final grade for this course by comparing the final
     * mark to multiple grade boundaries.
     * Afterwards, the course's details, final mark and final grade are
     * printed.
     */
    public void calculateFinalGrade()
    {
        if ((finalMark >= 0) && (finalMark <= 39))
        {
            finalGrade = "F";
        }
        else if ((finalMark >= 40) && (finalMark <= 49))
        {
            finalGrade = "D";
        }
        else if ((finalMark >= 50) && (finalMark <= 59))
        {
            finalGrade = "C";
        }
        else if ((finalMark >= 60) && (finalMark <= 69))
        {
            finalGrade = "B";
        }
        else if ((finalMark >= 70) && (finalMark <= 100))
        {
            finalGrade = "A";
        }
        
        print();
    }
    
    /**
     * Prints the course and its modules' details to the output terminal, as
     * well as its final mark and final grade.
     */
    public void print() 
    {
        System.out.println("Course: " + title + " (" + codeNumber + ")");
        moduleOne.print();
        moduleTwo.print();
        moduleThree.print();
        moduleFour.print();
        System.out.println("Final mark: " + finalMark);
        System.out.println("Final grade: " + finalGrade);
    }
    
}