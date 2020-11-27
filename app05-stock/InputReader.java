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
        System.out.print("> "); // user input prompt
        return reader.nextLine();
    }
    
    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as an int. If an invalid integer is entered,
     * the exception will be caught and an error message will be
     * shown.
     *
     * @param prompt The string prompting the user for an integer input.
     * @return The valid integer inputted by the user.
     */
    public int getInt(String prompt)
    {
        boolean isValid = false;
        int number = 0;
        
        while (!isValid)
        {
            try
            {
                System.out.println(prompt);
                System.out.print("> "); // user input prompt
                String value = reader.nextLine();
                number = Integer.parseInt(value);
                isValid = true;
            }
            catch (Exception e)
            {
                System.out.println("Error: invalid integer inputted.");
            }
        }
        
        return number;
    }
}