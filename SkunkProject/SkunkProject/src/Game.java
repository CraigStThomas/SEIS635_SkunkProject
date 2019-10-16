import java.util.LinkedList;

import edu.princeton.cs.introcs.StdOut;

public class Game
{
	private LinkedList<Player> players;
	int kitty;
	boolean endgame = false;
	private Player currentPlayer;
	
	public Game()
	{
		players = new LinkedList<>();
		kitty = 0;
	}

	public void addPlayer(String name) {
		Player newPlayer = new Player(name);
		players.add(newPlayer);
	}
	
	public void setCurrentPlayer (int index) {
		currentPlayer = players.get(index);
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void addToKitty(int chipsLost) {
		kitty = kitty + chipsLost;
	}
/*
	public static void main(String[] args)
	{
		Game newGame = new Game();
		newGame.initializeGame(5);
		
		int turnIndex = 0;
		int exitLoop = 0;
		
		while (exitLoop == 0)
		{
			for (int i = 0; i < newGame.players.size(); i++)
			{
				newGame.playTurn(newGame.players.get(i));
				StdOut.println(newGame.players.get(i).getTurns().get(turnIndex) + "\n");
			}
			
			for (int i = 0; i < newGame.players.size(); i++)
			{
				if (newGame.players.get(i).getPoints() >= GameConstants.WINNING_POINTS)
				{
					exitLoop = 1;
				}
			}
			
			turnIndex++;
		}
		
		StdOut.println("total turns = " + turnIndex);
		for (int i = 0; i < newGame.players.size(); i++)
		{
			StdOut.println(newGame.players.get(i).getName() + " has " + newGame.players.get(i).getPoints() + " points and " + newGame.players.get(i).getChips() + " chips");
		}
		StdOut.println("size of kitty = " + newGame.kitty + " chips");
	}
	*/
}
