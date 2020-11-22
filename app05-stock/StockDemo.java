// Importing Random class.
import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * Modified by Jason Huggins
 * Dated 22/11/2020
 */
public class StockDemo
{
    // Constant for the first product ID.
    public static final int FIRST_ID = 101;
    // The stock manager.
    private StockManager manager;
    // Random number generator used for making random delivery quantities.
    private Random generator;
    
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        generator = new Random();
        this.manager = manager;
        int id = FIRST_ID;
        
        // Adding at least 10 products
        manager.addProduct(new Product(id, "PlayStation 4 Pro"));
        manager.addProduct(new Product(102, "Nintendo Switch Neon"));
        manager.addProduct(new Product(103, "Xbox One X"));
        manager.addProduct(new Product(104, "Xbox One S"));
        manager.addProduct(new Product(105, "PlaySation 4 Slim"));
        manager.addProduct(new Product(106, "PlaySation 5"));
        manager.addProduct(new Product(107, "Xbox Series X"));
        manager.addProduct(new Product(108, "Xbox Series S"));
        manager.addProduct(new Product(109, "Nintendo Switch Grey"));
        manager.addProduct(new Product(110, "Xbox One S All-Digital Edition"));       
    }
    
    /**
     * Demonstrates the use of a StockManager by running through several processes for
     * testing purposes.
     */
    public void runDemo()
    {
       System.out.println("|------StockManager Demonstration------|");
        
       // Show details of all products.
       manager.printAllProducts();
       
       // Demos delivery process.
       System.out.println("\n|---Delivery Demonstration---|\n");
       demoDelivery();
       // Demos selling process.
       System.out.println("\n|---Selling Demonstration---|\n");
       demoSell();
       // Demos stock renaming process.
       System.out.println("\n|---Stock Renaming Demonstration---|\n");
       demoRename();
       // Demos stock removal process.
       System.out.println("\n|---Stock Removal Demonstration---|\n");
       demoRemove();
       // Demos printing products based on a part of its name.
       System.out.println("\n|---Product Search with Partial Name Demonstration---|\n");
       manager.printPartialName("PlayStation");
       // Demos printing products with low stock levels.
       System.out.println("\n|---Low Product Stock Demonstration---|\n");
       manager.printLowStock();
    }
    
    /**
     * Demonstrates taking delivery of all products and prints the updated stock list
     * afterwards.
     */
    private void demoDelivery()
    {
        int amount = 0;
        
        // Randomly generates an amount to deliver for each product.
        for (int id = 101; id <= 110; id++)
        {
            amount = generator.nextInt(9);
            manager.delivery(id, amount);
            amount++;
        }

        // Test for error message when an invalid product ID is inputted.
        manager.delivery(132, 5);
        
        manager.printAllProducts();
    }
    
    /**
     * Demonstrates selling different quantities of each product.
     */
    private void demoSell()
    {
        int amount = 0;
        
        for (int id = 101; id <= 110; id++)
        {
            amount = generator.nextInt(9);
            manager.sellProduct(id, amount);
            amount++;
        }
    }
    
    /**
     * Demonstrates two products in the stock list with misspelt names being renamed 
     * to their correct names.
     */
    private void demoRename()
    {
        // Shows details of the products with incorrect names.
        manager.printDetails(105);
        manager.printDetails(106);
        
        // Renames the above products to correct names.
        manager.renameProduct(105, "PlayStation 4 Slim");
        manager.renameProduct(106, "PlayStation 5");
        
        // Shows details of the products again with correct names.
        manager.printDetails(105);
        manager.printDetails(106);
    }
    
    /**
     * Demonstrates a product found at the end of the stock list being removed.
     */
    private void demoRemove()
    {
        // Adds a new product to the stock list for this demo.
        manager.addProduct(new Product(111, "Nintendo 2DS XL"));
        
        // Removes the last product from the stock list based on its ID.
        manager.removeProduct(111);
        
        // Shows details of all products with the last product removed.
        manager.printAllProducts();
    }
    
}
