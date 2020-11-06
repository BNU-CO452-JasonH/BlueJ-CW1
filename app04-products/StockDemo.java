/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * Modified by Jason Huggins
 * Dated 06/11/2020
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        
        // Adding at least 10 products
        manager.addProduct(new Product(101, "PlayStation 4 Pro"));
        manager.addProduct(new Product(102, "Nintendo Switch Neon"));
        manager.addProduct(new Product(103, "Xbox One X"));
        manager.addProduct(new Product(104, "Xbox One S"));
        manager.addProduct(new Product(105, "PlaySation 4 Slim"));
        manager.addProduct(new Product(106, "PlaySation 5"));
        manager.addProduct(new Product(107, "Xbox Series X"));
        manager.addProduct(new Product(108, "Xbox Series S"));
        manager.addProduct(new Product(109, "Nintendo Switch Grey"));
        manager.addProduct(new Product(110, "Xbox One S All-Digital Edition"));
        manager.addProduct(new Product(111, "Nintendo 2DS XL"));
    }
    
    /**
     * Demonstrates the use of a StockManager by running through several processes for
     * testing purposes.
     */
    public void runDemo()
    {
       System.out.println("|-------- Jason's Stock List --------|");
       System.out.println("StockManager Demonstration\n");
        
       // Show details of all products.
       manager.printAllProducts();
       
       // Demos delivery process
       demoDelivery();
       // Demos stock renaming process
       demoRename();
       // Demos stock removal process
       demoRemove();
    }
    
    /**
     * Demonstrates taking delivery of all products.
     */
    private void demoDelivery()
    {
        // Take delivery of all products and print the updated stock list afterwards.
        manager.delivery(101, 5);
        manager.delivery(102, 2);
        manager.delivery(103, 7);
        manager.delivery(104, 6);
        manager.delivery(105, 9);
        manager.delivery(106, 11);
        manager.delivery(107, 12);
        manager.delivery(108, 15);
        manager.delivery(109, 19);
        manager.delivery(110, 17);
        manager.delivery(111, 5);

        manager.printAllProducts();
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
        // Removes the last product from the stock list based on its ID.
        manager.removeProduct(111);
        
        // Shows details of all products with the last product removed.
        manager.printAllProducts();
    }

}
