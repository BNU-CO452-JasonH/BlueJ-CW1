// Importing Date type from package
import java.util.Date;

/**
 * The Ticket class models a ticket, containing a destination (either
 * Aylesbury, Amersham or High Wycombe), price and the date/time 
 * it was issued. 
 *
 * @author Jason Huggins
 * @version 10/10/2020
 */
public class Ticket
{
   // The ticket's destination
   private String destination;
   // The ticket's date and time when issued
   private Date issueDateTime;
   // The ticket's price
   private int price;
    
   /**
    * Constructor for objects of class Ticket setting the destination
    * and price, where the date shows the current system 
    * date and time.
    * @param givenDestination - the new ticket's destination
    * @param givenPrice - the new ticket's price
    */
   public Ticket(String givenDestination, int givenPrice)
   {
       destination = givenDestination;
       price = givenPrice;
       issueDateTime = new Date();
   }
   
   /**
    * @return The destination the ticket is for
    */
   public String getDestination()
   {
       return destination;
   }
   
   /**
    * @return The price of the ticket
    */
   public int getPrice()
   {
       return price;
   }
   
   /**
    * Prints the ticket to the output terminal.
    */
   public void print()
   {
       System.out.println("Ticket: " + destination + "\nPrice: " + 
           "\nIssued: " + issueDateTime);
   }
}