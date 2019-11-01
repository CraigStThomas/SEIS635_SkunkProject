import java.util.LinkedList;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkIO {
	
	public String welcome() {
		StdOut.println("Welcome to the Skunk Game!");
		StdOut.println("Would you like to see the rules? (y/n)");
		return StdIn.readLine();
	}
	public void showRules() {
		StdOut.print("Rules of Skunk \nDIRECTIONS FOR PLAYING \nThe object of the game is to accumulate a score of 100 points or more. \nA score is made by rolling the dice and combining the points on the two dice. \nFor example: A 4 and 5 would be 9 points - \nif the player decides to take another roll of the dice and turns up a 3 and 5 (8 points), he would then have an accumulated total of 17 points for the two rolls. \nThe player has the privilege of continuing to shake to increase his score or of passing the dice to wait for the next series, \nthus preventing the possibility of rolling a Skunk and losing his score. \nPENALTIES: \nA skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\n" + 
				"A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice. \nTWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. \nPlayer must again start to score from scratch. \nThe first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win. \nWhen he decides to stop, his total score is the goal. /nEach succeeding player receives one more chance to better the goal and end the game. \nThe winner of each game collects all chips in \"kitty\" and in addition five chips from each losing player or 10 chips from any player without a score. \n");
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
