import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{
    public static void main(String[] args)
    {
		    	
    	StdOut.println("Welcome to Skunk game!"); //to print a welcome massage.
    	StdOut.println("This is a sample functionality of a single turn with 1 player. ");
    	Game sampleGame = new Game();
    	// Eventually add logic to input number of players, then loop through adding a player
    	StdOut.println("Player, please input your name: ");
    	String name = StdIn.readLine();
    	sampleGame.addPlayer(name);
    	sampleGame.setCurrentPlayer(0);
    	Player currentPlayer = sampleGame.getCurrentPlayer();
    	currentPlayer.startTurn();
    	boolean rollAgain = true;
    	while (rollAgain) {
    		StdOut.println(currentPlayer.getName() + ", it is your turn. Would you like to roll the dice? y/n: ");
    		currentPlayer.setRollDecision(StdIn.readLine());
    		switch (currentPlayer.continueTurn()) {
    		case 0: {
    			rollAgain = false;
    			StdOut.println("Thank you for playing! Your final score is: " + currentPlayer.getPlayerScore());
    			break;
    		}
    		case 1: {
    			rollAgain = false;
    			StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll()); // see note next to this method
    			StdOut.println("You rolled a Skunk! Your turn is over and you lose 1 chip.");
    			sampleGame.addToKitty(1);
    			StdOut.println("Your total score is: " + currentPlayer.getPlayerScore());
    			break;
    		}
    		case 2: {
    			rollAgain = false;
    			StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll()); // see note next to this method
    			StdOut.println("You rolled a Skunk Deuce! Your turn is over and you lose 2 chips.");
    			sampleGame.addToKitty(2);
    			StdOut.println("Your total score is: " + currentPlayer.getPlayerScore());
    			break;
    		}
    		case 3: {
    			rollAgain = false;
    			StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll());
    			StdOut.println("You rolled a Double Skunk! Your turn is over and you lose all your points and four chips.");
    			sampleGame.addToKitty(4);
    			StdOut.println("Your total score is: 0");
    			break;
    		}
    		case 4: {
    			StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll());
    			StdOut.println("Your current turn score is: " + currentPlayer.getCurrentTurn().getTurnScore()); 
    			StdOut.println("If you end your turn now, your total score would be: " + currentPlayer.getPlayerScore() + " + " + currentPlayer.getCurrentTurn().getTurnScore());   
    			break;
    		}
    		
    		}
    	}
    	StdOut.println("Goodbye.");
    }
}
