import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{
    public static void main(String[] args)
    {
		    	
    	StdOut.println("Welcome to Skunk game!"); //to print a welcome message.
    	StdOut.println("This is a sample functionality of a single turn with 1 player. ");
    	Game sampleGame = new Game();
    	// Eventually add logic to input number of players, then loop through adding a player
    	StdOut.println("Player, please input your name: ");
    	String name = StdIn.readLine();
    	sampleGame.addPlayer(name);
    	// Construct a loop to cycle through player turns (while !endgame perhaps?) 
    	sampleGame.setCurrentPlayer(0);
    	Player currentPlayer = sampleGame.getCurrentPlayer();
    	currentPlayer.startTurn();
    	boolean rollAgain = true;
    	while (rollAgain) {
    		StdOut.println(currentPlayer.getName() + ", it is your turn. Would you like to roll the dice? y/n: ");
    		currentPlayer.setRollDecision(StdIn.readLine());
    		switch (currentPlayer.continueTurn()) { // Each of these cases will eventually print a full scoreboard
    		case 0: {
    			rollAgain = false;
    			StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll()); // Is there a better way to do this?
    			StdOut.println("You rolled a Double Skunk! Your turn is over and you lose all your points and four chips.");
    			sampleGame.addToKitty(4);
    			StdOut.println("Your total score is: 0");
    			break;
    		}
    		case 1: {
    			rollAgain = false;
    			StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll());
    			StdOut.println("You rolled a Skunk! Your turn is over and you lose 1 chip.");
    			sampleGame.addToKitty(1); // Probably not the best way, but main is currently the only thing that interacts with Game
    			StdOut.println("Your total score is: " + currentPlayer.getPlayerScore());
    			break;
    		}
    		case 2: {
    			rollAgain = false;
    			StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll());
    			StdOut.println("You rolled a Skunk Deuce! Your turn is over and you lose 2 chips.");
    			sampleGame.addToKitty(2);
    			StdOut.println("Your total score is: " + currentPlayer.getPlayerScore());
    			break;
    		}
    		case 3: {
    			StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll());
    			StdOut.println("Your current turn score is: " + currentPlayer.getCurrentTurn().getPointsWon()); 
    			StdOut.println("If you end your turn now, your total score would be: " + (currentPlayer.getPlayerScore() + currentPlayer.getCurrentTurn().getPointsWon()));   
    			break;
    		}
    		case 4: {
    			rollAgain = false;
    			StdOut.println("Thank you for playing! Your final score is: " + currentPlayer.getPlayerScore());
    			break;
    		}

    		
    		}
    	}
    	// Manage endgame
    	StdOut.println("Goodbye.");
    }
}
