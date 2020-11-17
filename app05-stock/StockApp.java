/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products.
 *
 * @author Jason Huggins
 * @version 17/11/2020
 */
public class StockApp
{
    // Constant to clear the screen
    // public static final char CLEAR_CODE = '\u000C';
    
    // Constants for app commands
    public static final String ADD = "add";
    public static final String REMOVE = "remove";
    public static final String DELIVER = "deliver";
    public static final String PRINT_ALL = "printall";
    public static final String QUIT = "quit";
    
    // Use to get user input
    private InputReader input;
    // Gets the stock manager for the app
    private StockManager manager;
    // Adds the products to the stock list
    private StockDemo demo;
    
    /**
     * Constructor for objects of class StockApp.
     */
    public StockApp()
    {
        input = new InputReader();
        manager = new StockManager();
        demo = new StockDemo(manager);
    }

    /**
     * Runs during the operation of the app, quitting when the user inputs
     * "quit".
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = input.getString().toLowerCase();
            
            if (choice.equals(QUIT)) 
            {
                System.out.println("Exiting application...");
                System.out.println("You may now close this window.");
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }
    
    /**
     * Executes a menu choice based on what the user inputs.
     */
    public void executeMenuChoice(String choice)
    {
        if (choice.equals(ADD))
        {
            addProduct();
        }
        else if (choice.equals(REMOVE))
        {
            removeProduct();
        }
        else if (choice.equals(DELIVER))
        {
            deliverProduct();
        }
        else if (choice.equals(PRINT_ALL))
        {
            manager.printAllProducts();
            System.out.println("\nPress ENTER to return to the menu.");
            String value = input.getString();
        }
    }
    
    /**
     * Adds a new product to the stock list, with the user needing to 
     * provide a product ID and name.
     */
    private void addProduct()
    {
        System.out.println("|-- Product Addition --|\n");
        
        System.out.println("Please enter the product ID:");
        int id = Integer.parseInt(input.getString());
        
        System.out.println("Please enter the product name:");
        String name = input.getString();
        
        Product product = new Product(id, name);
        manager.addProduct(product);
        
        System.out.println("\nYou have added: " + product + "\n");
    }
    
    /**
     * Removes a product from the stock list, with the user inputting a
     * product ID through the terminal window.
     */
    private void removeProduct()
    {
        System.out.println("|-- Product Removal --|\n");
        manager.printAllProducts();
        
        System.out.println("\nPlease enter the ID of the product" + 
            " to be removed:");
        int id = Integer.parseInt(input.getString());
        
        manager.removeProduct(id);
    }
    
    /**
     * Delivers a quantity of a product from the stock list, with the user
     * inputting the product's ID and quantity.
     */
    private void deliverProduct()
    {
        System.out.println("|-- Product Delivery --|\n");
        
        System.out.println("Please enter the product ID:");
        int id = Integer.parseInt(input.getString());
        
        System.out.println("Please enter a quantity:");
        int qty = Integer.parseInt(input.getString());
        
        manager.delivery(id, qty);
    }
    
    /**
     * Print out a menu of operation choices.
     */
    private void printMenuChoices()
    {
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Deliver:    Deliver a quantity of a" + 
            " product");
        System.out.println("    Sell:       Sell a quantity of a product");
        System.out.println("    Search:     Search for a product by" + 
            " a part of its name");
        System.out.println("    LowStock:   Print all products with low" +
            " stock levels (stock < 3)");
        System.out.println("    ReStock:    Re-stock all products up to" +
            " a set minimum level");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
    }
    
    /**
     * Print the title of the program and the authors name.
     */
    private void printHeading()
    {
        // System.out.println(CLEAR_CODE);
        System.out.println("\n******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Jason Huggins");
        System.out.println("******************************\n");
    }
}