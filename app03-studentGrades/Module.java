
/**
 * The Module class represents a module within a course, containing its
 * title, module code and percentage mark.
 *
 * @author Jason Huggins
 * @version 16/10/2020
 */
public class Module
{
    // the module's title
    private String title;
    // the module's code number
    private String codeNo;
    // the module's percentage mark
    private int mark;
    
    /**
     * Creates a new module with a given title and code number.
     * @param title The title of the module.
     * @param codeNo The code number of the module.
     */
    public Module(String title, String codeNo)
    {
        this.title = title;
        this.codeNo = codeNo;
        mark = 0;
    }

}
