/**
 * The Program class creates and runs an instance of the StockApp class. 
 *
 * @author Jason Huggins
 * @version 13/11/2020
 */
public class Program
{
    private static StockApp app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main()
    {
        app = new StockApp();
        app.run();
    }
}