/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been inputted.
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
     * Creates a machine that issues tickets with the price preset
     * to each destination's fare.
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
     * Selects the Aylesbury ticket as the ticket being issued.
     */
    public void selectAylesburyTicket()
    {
        issuedTicket = aylesburyTicket;
        price = issuedTicket.getPrice();
        System.out.println("Ticket selected: Aylesbury");
    }
    
    /**
     * Selects the Amersham ticket as the ticket being issued.
     */
    public void selectAmershamTicket()
    {
        issuedTicket = amershamTicket;
        price = issuedTicket.getPrice();
        System.out.println("Ticket selected: Amersham");
    }
    
    /**
     * Selects the High Wycombe ticket as the ticket being issued.
     */
    public void selectHighWycombeTicket()
    {
        issuedTicket = highWycombeTicket;
        price = issuedTicket.getPrice();
        System.out.println("Ticket selected: High Wycombe");
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
     * Inserts a 10p coin into the ticket machine.
     */
    public void insert10P()
    {
        balance += 10;
    }
    
    /**
     * Inserts a 20p coin into the ticket machine.
     */
    public void insert20P()
    {
        balance += 20;
    }
    
    /**
     * Inserts a £1 coin into the ticket machine.
     */
    public void insert100P()
    {
        balance += 100;
    }
    
    /**
     * Inserts a £2 coin into the ticket machine.
     */
    public void insert200P()
    {
        balance += 200;
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
            System.out.println("# " + price + " pence.");
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
                               (price - balance) + " more pence.");
                    
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
