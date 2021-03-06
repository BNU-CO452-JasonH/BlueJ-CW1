/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * Modified by Jason Huggins
 * Dated 06/11/2020
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * Changes the ID of a product based on the given ID.
     * @param id The product's current ID to be changed.
     */
    public void setID(int id)
    {
        this.id = id;
    }
    
    /**
     * Changes the name of the product.
     * @param name The product's current name to be changed.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Changes the quantity of the product.
     * @param quantity The product's current quantity to be changed.
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    /**
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        return id + ": " +  name + " [Stock level: " + quantity + "]";
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0) 
        {
            quantity += amount;
        }
        else 
        {
            System.out.println("Attempted to restock " + name +
                               " with a non-positive amount: " + amount);
        }
    }

    /**
     * Sell this product with a given quantity.
     * An error is reported if there appears to be insufficient stock or no stock.
     * @param sellQuantity The quantity of the product to be sold.
     */
    public void sell(int sellQuantity)
    {
        if (quantity >= sellQuantity) 
        {
            quantity -= sellQuantity;
            System.out.println("Sold " + sellQuantity + " of product: " + toString());
        }
        else if (sellQuantity > quantity)
        {
            System.out.println("Insufficient stock of product: " + toString());
            
            // Selling current quantity of product
            System.out.println("Amount ordered of available stock: " + quantity);
            quantity = 0;
        }
        else
        {
            System.out.println("No stock of product: " + toString());
        }
    }
}
