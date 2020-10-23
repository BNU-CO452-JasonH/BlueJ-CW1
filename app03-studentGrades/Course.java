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
    
    // the final mark calculated for the course
    private int finalMark;
    // the final grade calculated for the course
    private String finalGrade;

    /**
     * Creates a new course with a given code number and title.
     */
    public Course(String codeNo, String courseTitle)
    {
        codeNumber = codeNo;
        title = courseTitle;
        createModules();
        
        finalMark = 0;
        finalGrade = null;
    }
    
    /**
     * Creates the four modules for the course with its details preset.
     */
    public void createModules()
    {
        moduleOne = new Module("Computer Architectures", "CO450");
        moduleTwo = new Module("Programming Concepts", "CO452");
        moduleThree = new Module("Digital Technologies" +
            " and Professional Practice", "CO450");
        moduleFour = new Module("Computer Architectures", "CO450");
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
     * Prints the course's title and code number to the output terminal, as
     * well as its final mark.
     */
    public void print() 
    {
        System.out.println(codeNumber + ", " + title);
        System.out.println("Final mark: " + finalMark);
    }
    
}