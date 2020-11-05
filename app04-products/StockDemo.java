/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * Modified by Jason Huggins
 * Dated 05/11/2020
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
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demoDelivery()
    {
        // Show details of all of the products.
        manager.printAllProducts();
        
        // Take delivery of all of the products and print the stock afterwards.
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

        manager.printAllProducts();
    }
    
    /**
     * Demonstrates two products with misspelt names being renamed with their correct
     * names.
     */
    public void demoRename()
    {
        // Shows details of products with incorrect names.
        manager.printDetails(105);
        manager.printDetails(106);
        
        // Renames above products to correct names and prints their details out.
        manager.renameProduct(105, "PlayStation 4 Slim");
        manager.renameProduct(106, "PlayStation 5");
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}
