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
 * Dated 16/10/2020
 */
public class TicketMachine
{
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    
    // An object of the Ticket class representing the issued ticket
    private Ticket issuedTicket;
    // An object of the Ticket class representing the Aylesbury ticket
    public static final Ticket AYLESBURY_TICKET = 
        new Ticket("Aylesbury", 220);
    // An object of the Ticket class representing the Amersham ticket
    public static final Ticket AMERSHAM_TICKET =
        new Ticket("Amersham", 300);
    // An object of the Ticket class representing the High Wycombe ticket
    public static final Ticket HIGH_WYCOMBE_TICKET =
        new Ticket("High Wycombe", 330);
    
    /**
     * Creates a machine that issues tickets with the price preset
     * to each destination's fare. All available tickets that are 
     * purchasable are shown to the customer.
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;
        
        issuedTicket = null;
        
        // Prints all available tickets
        System.out.println("Tickets available to buy:");
        System.out.println("1. " + AYLESBURY_TICKET.getDestination() +
            " = " + AYLESBURY_TICKET.getPrice());
        System.out.println("2. " + AMERSHAM_TICKET.getDestination() +
            " = " + AMERSHAM_TICKET.getPrice());
        System.out.println("3. " + HIGH_WYCOMBE_TICKET.getDestination() +
            " = " + HIGH_WYCOMBE_TICKET.getPrice());
    }

    /**
     * Selects the Aylesbury ticket as the ticket to be issued.
     */
    public void selectAylesburyTicket()
    {
        issuedTicket = AYLESBURY_TICKET;
        System.out.println("Ticket selected: Aylesbury " + 
            "(" + issuedTicket.getPrice() + ")");
    }
    
    /**
     * Selects the Amersham ticket as the ticket to be issued.
     */
    public void selectAmershamTicket()
    {
        issuedTicket = AMERSHAM_TICKET;
        System.out.println("Ticket selected: Amersham " + 
            "(" + issuedTicket.getPrice() + ")");
    }
    
    /**
     * Selects the High Wycombe ticket as the ticket to be issued.
     */
    public void selectHighWycombeTicket()
    {
        issuedTicket = HIGH_WYCOMBE_TICKET;
        System.out.println("Ticket selected: High Wycombe " + 
            "(" + issuedTicket.getPrice() + ")");
    }

    /**
     * @return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Inserts a 10p coin into the ticket machine and displays 
     * the new balance.
     */
    public void insert10P()
    {
        balance += 10;
        System.out.println("Inserted 10p.");
        System.out.println("New balance: " + balance);
    }
    
    /**
     * Inserts a 20p coin into the ticket machine and displays 
     * the new balance.
     */
    public void insert20P()
    {
        balance += 20;
        System.out.println("Inserted 20p.");
        System.out.println("New balance: " + balance);
    }
    
    /**
     * Inserts a £1 coin into the ticket machine and displays 
     * the new balance.
     */
    public void insert100P()
    {
        balance += 100;
        System.out.println("Inserted £1.");
        System.out.println("New balance: " + balance);
    }
    
    /**
     * Inserts a £2 coin into the ticket machine and displays 
     * the new balance.
     */
    public void insert200P()
    {
        balance += 200;
        System.out.println("Inserted £2.");
        System.out.println("New balance: " + balance);
    }
    
    /**
     * Prints a ticket if enough money has been inserted, and
     * reduces the current balance by the ticket price. 
     * 
     * An error message is printed if no ticket has been 
     * selected or more money is required.
     */
    public void printTicket()
    {
        if (issuedTicket == null) 
        {
            System.out.println("No ticket has been selected.");
        }
        else if (balance >= issuedTicket.getPrice()) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# " + issuedTicket.getDestination() +
                " Ticket");
            System.out.println("# " + issuedTicket.getPrice() + " pence");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + issuedTicket.getPrice();
            // Reduce the balance by the price.
            balance = balance - issuedTicket.getPrice();
        }
        else 
        {
            System.out.println("Insufficient balance for the " +
                issuedTicket.getDestination() + 
                " ticket. \nYou must enter at least " +
                (issuedTicket.getPrice() - balance) + " more pence.");
        }
    }

    /**
     * Refunds the money remaining in the balance to the customer
     * and clears the balance afterwards.
     * @return the money in the balance.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
