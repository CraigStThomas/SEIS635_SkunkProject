import java.util.LinkedList;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkIO {
	
	public void welcome() {
		StdOut.println("Welcome to the Skunk Game!");
	}
	
	public int requestNumberOfPlayers() {
		StdOut.println("Please enter the number of players: ");
		int i = StdIn.readInt();
		StdIn.readLine(); //This line is needed to clear the carriage return readInt leaves in StdIn.
		//Without this line, the first player's name will appear blank
		return i;
	}
	
	public String requestPlayerName(int playerNumber) {
		StdOut.println("Player" + playerNumber + ", enter your name: ");
		return StdIn.readLine();
	}
	
	public void startTurn(Player currentPlayer) {
		StdOut.println(currentPlayer.getName() + ", it is your turn. ");
		StdOut.println();
	}
	
	public void turnSkip(Player currentPlayer) {
		StdOut.println(currentPlayer.getName() + ", you have no chips.  Your turn is skipped.");
		StdOut.println();
	}
	
	public void printScoreboard(LinkedList<Player> players) {
		StdOut.println("Here is the current scoreboard.");
		StdOut.println("Name: \t Score: \t Chips: .");
		for (int i = 0; i < players.size(); i++) {
			StdOut.println(players.get(i).getName() + "\t" + players.get(i).getPlayerScore() + "\t" + players.get(i).getChips() + " . ");
		}
		StdOut.println();
	}

	public String requestRollDecision(Player currentPlayer) {
		StdOut.println(currentPlayer.getName() + " Would you like to roll the dice? y/n");
		return StdIn.readLine();
	}
	
	public void printNoRollResult(Player currentPlayer) {
		StdOut.println("You have chosen to end your turn. ");
		StdOut.println("Your new score is " + currentPlayer.getPlayerScore());
		StdOut.println();
	}
	
	public void printDoubleSkunkResult(Player currentPlayer) {
		StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll()); // Is there a better way to do this?
		StdOut.println("You rolled a Double Skunk! Your turn is over, you lose all your points, and you lose four chips.");
		StdOut.println("Your total score is: 0");
		StdOut.println("Your chip count is: " + currentPlayer.getChips());
		StdOut.println();
	}
	
	public void printSkunkDeuceResult(Player currentPlayer) {
		StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll());
		StdOut.println("You rolled a Skunk Deuce! Your turn is over and you lose 2 chips.");
		StdOut.println("Your total score is: " + currentPlayer.getPlayerScore());
		StdOut.println("Your chip count is: " + currentPlayer.getChips());
		StdOut.println();
	}
	
	public void printSkunkResult(Player currentPlayer) {
		StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll());
		StdOut.println("You rolled a Skunk! Your turn is over and you lose 1 chip.");
		StdOut.println("Your total score is: " + currentPlayer.getPlayerScore());
		StdOut.println("Your chip count is: " + currentPlayer.getChips());
		StdOut.println();
	}
	
	public void printScoringResult(Player currentPlayer) {
		StdOut.println("The result of that roll was: " + currentPlayer.getCurrentTurn().getCurrentRoll());
		StdOut.println("Your current turn score is: " + currentPlayer.getCurrentTurn().getPointsWon()); 
		StdOut.println("If you end your turn now, your total score would be: " + (currentPlayer.getPlayerScore() + currentPlayer.getCurrentTurn().getPointsWon()));
		StdOut.println("Your chip count is: " + currentPlayer.getChips());
		StdOut.println();
	}
	
	public void endgameMessage(Player endgamePlayer) {
		StdOut.println(endgamePlayer.getName() + " has reached 100 points or more. ");
		StdOut.println("Each player other than " + endgamePlayer.getName() + " will take one more turn. ");
		StdOut.println();
	}
	
	public void displayWinner(Player winningPlayer, int chipsWon) {
		StdOut.println(winningPlayer.getName() + " has won the game! ");
		StdOut.println(winningPlayer.getName() + " wins " + chipsWon + " chips. ");
		StdOut.println("Thanks for playing!");
		StdOut.println();
	}
	
	public String requestPlayAgain(Player currentPlayer)
	{
		StdOut.println(currentPlayer.getName() + " Would you like to play again? y/n");
		return StdIn.readLine();
	}
}
