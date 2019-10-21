import java.util.LinkedList;

public class Game
{
	private LinkedList<Player> players;
	int kitty; // Collect and distribute chips
	boolean endgame = false;
	private Player currentPlayer;
	int numberOfPlayers, currentPlayerIndex;
	private SkunkIO console = new SkunkIO();
	
	public Game()
	{
		players = new LinkedList<>();
		kitty = 0;
	}

	public void setupGame() {
		console.welcome();
		numberOfPlayers = console.requestNumberOfPlayers();
		for (int i = 1; i <= numberOfPlayers; i++) {
			this.addPlayer(console.requestPlayerName(i));
		}
		this.setCurrentPlayer(0);
		currentPlayerIndex = 0;
		this.takeTurn();
	}
	
	public void takeTurn() {
		console.startTurn(currentPlayer);
		console.printScoreboard(players);
		currentPlayer.startTurn();
		boolean rollAgain = true;
		while (rollAgain) {
		currentPlayer.setRollDecision(console.requestRollDecision(currentPlayer));
		switch (currentPlayer.continueTurn()) {
		case 0: { //double skunk
			rollAgain = false;
			console.printDoubleSkunkResult(currentPlayer);
			this.addToKitty(4);
			break;
				}
		case 1: { // skunk
			rollAgain = false;
			console.printSkunkResult(currentPlayer);
			this.addToKitty(1);
			break;
				}
		case 2: { // skunk deuce
			rollAgain = false;
			console.printSkunkDeuceResult(currentPlayer);
			this.addToKitty(2);
			break;
				}
		case 3: { // point scoring
			console.printScoringResult(currentPlayer);
			break;
				}
		case 4: { //decline to roll
			rollAgain = false;
			console.printNoRollResult(currentPlayer);
			break;
				}
			}
		}
		if (currentPlayer.getPlayerScore() < 100)
		this.endTurn();
		else
		this.startEndgame();
	}
	
	public void startEndgame() {
		console.endgameMessage(currentPlayer);
		System.out.println("Not Yet Implemented");
		return;
	}
	
	public void endTurn() { //I'd like to find a better way to handle this, which cycles through players, 
		//going back to player 1 when the last player is reached.
		if (currentPlayerIndex < numberOfPlayers -1) {
		currentPlayer = players.get(currentPlayerIndex + 1);
		currentPlayerIndex++;
		}
		else {
			currentPlayer = players.get(0);
			currentPlayerIndex = 0;
		}
		this.takeTurn();
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
	
	public int getKitty() {
		return kitty;
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
