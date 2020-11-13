/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Jason Huggins
 * @version 13/11/2020
 */
public class StockApp
{
    // Constant to clear the screen
    public static final char CLEAR_CODE = '\u000C';
    
    // Constants for app commands
    public static final String QUIT = "quit";
    public static final String ADD = "add";
    public static final String PRINT_ALL = "printall";
    
    // Use to get user input
    private InputReader input;
    // Gets the stock manager for the app
    private StockManager manager;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        manager = new StockManager();
    }

    /**
     * 
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = input.getInput().toLowerCase();
            
            if (choice.equals(QUIT)) 
            {
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }
    
    /**
     * 
     */
    public void executeMenuChoice(String choice)
    {
        if (choice.equals(ADD))
        {
            addProduct();
        }
        else if (choice.equals(PRINT_ALL))
        {
            
        }
    }
    
    private void addProduct()
    {
        
    }
        
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println(CLEAR_CODE);
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Jason Huggins");
        System.out.println("******************************");
    }
}