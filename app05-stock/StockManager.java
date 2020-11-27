import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Jason Huggins
 * @version 27/11/2020
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list. If the product ID entered by the user
     * already exists in the stock list, an error message will be
     * shown, saying that it's a duplicate.
     * @param item The product to be added to the stock list.
     */
    public void addProduct(Product item)
    {
        if (findProduct(item.getID()) != null) 
        {
            System.out.println("Error: This product has a duplicated ID.");
        }
        else
        {
            stock.add(item);
            System.out.println("\nYou have added: " + item + "\n");
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for (Product product : stock) 
        {
            if (product.getID() == id)
            {
                return product;
            }
        }
        
        return null;
    }
    
    /**
     * Remove a product from the list based on its ID.
     * @param id The ID of the product to be removed.
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            System.out.println("Product ID " + id + " has been " 
                + "removed from the stock list.");
            stock.remove(product);
        }
        else
        {
            System.out.println("Product ID " + id + " has not been found.");
        }
    }
    
    /**
     * Renames a particular product based on its given ID and new name.
     * @param id The ID of the product to be renamed.
     * @param name The new name that the product will be renamed to.
     */
    public void renameProduct(int id, String name)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            product.setName(name);
            System.out.println("Product ID " + id + " has been renamed to " + 
                product.getName());
        }
        else
        {
            System.out.println("Product ID " + id + " has not been found.");
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);

        if (product != null)
        {
            product.increaseQuantity(amount);
            System.out.println("Product delivered: " + product.getName() 
                + " [Qty: " + amount + "]");
        }
        else
        {
            System.out.println("Product ID " + id + " has not been found.");
        }
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }

    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printDetails(int id)
    {
        Product product = findProduct(id);
        
        if (product != null) 
        {
            System.out.println(product);
        }
        else 
        {
            System.out.println("Product ID " + id + " has not been found.");
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id, int quantity)
    {
        Product product = findProduct(id);
        
        if (product != null) 
        {
            product.sell(quantity);
        }
        else
        {
            System.out.println("Product ID " + id + " has not been found.");
        }
    }
    
    /**
     * Print details of all products.
     */
    public void printAllProducts()
    {
        printHeader();
        
        for (Product product : stock)
        {
            System.out.println(product);
        }
    }
    
    /**
     * Prints details of products beginning with a certain string, 
     * given in the parameter.
     * @param partialName The prefix of the product name to be searched for.
     */
    public void printPartialName(String partialName)
    {
        System.out.println("Products beginning with '" + partialName + "':");
        
        for (Product product : stock)
        {
            if (product.getName().startsWith(partialName))
            {
                System.out.println(product);
            }
        }
    }
    
    /**
     * Prints details of all products with low stock levels, where the
     * low stock threshold is set to 3.
     */
    public void printLowStock()
    {
        System.out.println("Products with low stock levels (stock < 4):\n");
        
        for (Product product : stock)
        {
            if (product.getQuantity() <= 3)
            {
                System.out.println(product);
            }
        }
    }
    
    /**
     * Restocks all products with low stock levels to a set
     * minimum level, which in this case is 7.
     */
    public void restockProducts()
    {
        printLowStock();
        
        System.out.println("\nRestocked above products to "
            + "set minimum level - 7.");
        for (Product product : stock)
        {
            if (product.getQuantity() <= 3)
            {
                product.setQuantity(7);
            }
        }
    }
    
    /**
     * Prints a header for the stock list.
     */
    public void printHeader()
    {
        System.out.println("===================");
        System.out.println("Jason's Stock List");
        System.out.println("===================");
    }
}
