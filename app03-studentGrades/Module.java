
/**
 * The Module class represents a module within a course, containing its
 * title, module code and percentage mark.
 *
 * @author Jason Huggins
 * @version 26/10/2020
 */
public class Module
{
    // the module's title
    private String title;
    // the module's code number
    private String codeNo;
    // the module's percentage mark
    private int mark;
    // the module's credit amount
    private int credit;
    // "true" if the module has been completed or "false" otherwise
    private boolean completed;
    // "true" if the module has been passed or "false" otherwise
    private boolean passed;
    
    /**
     * Creates a new module with a given code number and title.
     * @param codeNo The code number of the module.
     * @param title The title of the module.
     */
    public Module(String codeNo, String title)
    {
        this.codeNo = codeNo;
        this.title = title;
        
        mark = -1; // set to -1 so it won't start off as being completed
        credit = 0;
        
        completed = false;
        passed = false;
    }

    /**
     * Awards a percentage mark to a student for this module, but it must
     * be in the range of 0-100. Should the input not fall within this range,
     * an error message is printed.
     * @param mark The percentage mark awarded to the student.
     */
    public void awardMark(int mark)
    {
        if ((mark >= 0) && (mark <= 100))
        {
            this.mark = mark;
        }
        else
        {
            System.out.println("Invalid input. The percentage mark " + 
                "inputted must be between 0-100.");
        }
    }
    
    /**
     * @return The title of this module.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * @return The code number of this module.
     */
    public String getCodeNo()
    {
        return codeNo;
    }
    
    /**
     * @return The percentage mark of this module.
     */
    public int getMark()
    {
        return mark;
    }
    
    /**
     * @return true if the module has been completed or false otherwise.
     */
    public boolean isCompleted()
    {
        return mark >= 0;
    }
    
    /**
     * @return true if the module has been passed or false otherwise.
     */
    public boolean isPassed()
    {
        if (isCompleted()) 
        {
            credit = 15; // adds 15 credits for a completed module
        }
        
        return mark >= 40;
    }
    
    /**
     * Prints the module details to the output terminal.
     */
    public void print()
    {
        System.out.println("Module: " + title + " (" +
            codeNo + ")" + " = " + mark);
    }
}
