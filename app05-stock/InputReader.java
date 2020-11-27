import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 * Modified by Jason Huggins
 * Dated 27/11/2020
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return A String typed by the user.
     */
    public String getString()
    {
        System.out.print("> ");         // print prompt
        return reader.next();
    }
    
    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as an int.
     *
     * @return An int typed by the user.
     */
    public int getInt()
    {
        System.out.print("> ");         // print prompt
        return reader.nextInt();
    }
}