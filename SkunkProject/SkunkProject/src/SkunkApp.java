import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{
    public static void main(String[] args)
    {
		    	
    	StdOut.println("Welcome to Skunk game!"); //to print a welcome massage.

    	Dice newDice = new Dice();
    	newDice.roll(); // Invoke roll().
    	StdOut.println(newDice); 
    }
}
