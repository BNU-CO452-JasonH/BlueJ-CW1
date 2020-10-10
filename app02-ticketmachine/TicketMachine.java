/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Jason Huggins
 * Dated 10/10/2020
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // An object of the Ticket class representing the issued ticket
    private Ticket issuedTicket;
    // An object of the Ticket class representing the Aylesbury ticket
    private Ticket aylesburyTicket;
    // An object of the Ticket class representing the Amersham ticket
    private Ticket amershamTicket;
    // An object of the Ticket class representing the High Wycombe ticket
    private Ticket highWycombeTicket;
    
    /**
     * Creates a machine that issues tickets with the price being set
     * accordingly to each destination's fare.
     */
    public TicketMachine()
    {
        price = 0;
        balance = 0;
        total = 0;
        
        aylesburyTicket = new Ticket("Aylesbury", 220);
        amershamTicket = new Ticket("Amersham", 300);
        highWycombeTicket = new Ticket("High Wycombe", 330);
        issuedTicket = null;
    }

    /**
     * @return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * @return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receives an amount of money from a customer.
     * Checks that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    
    /**
     * Selects the Aylesbury ticket as the ticket being issued.
     */
    public void selectAylesburyTicket()
    {
        issuedTicket = aylesburyTicket;
    }
    
    /**
     * Selects the Amersham ticket as the ticket being issued.
     */
    public void selectAmershamTicket()
    {
        issuedTicket = amershamTicket;
    }
    
    /**
     * Selects the High Wycombe ticket as the ticket being issued.
     */
    public void selectHighWycombeTicket()
    {
        issuedTicket = highWycombeTicket;
    }
    
    /**
     * Prints a ticket if enough money has been inserted, and
     * reduces the current balance by the ticket price. 
     * An error message is printed if more money is 
     * required.
     */
    public void printTicket()
    {
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
    }

    /**
     * @return The money in the balance.
     * The balance is then cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
