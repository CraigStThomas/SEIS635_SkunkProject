import java.util.LinkedList;

import edu.princeton.cs.introcs.StdOut;

public class Player
{
	private int playerScore;
	private int chips;
	private String name;
	private LinkedList<Turn> turns;
	private Turn currentTurn;
	private String rollDecision;
	
	public Player(String inputName)
	{
		name = inputName;
		playerScore = GameConstants.STARTING_POINTS;
		chips = GameConstants.STARTING_CHIPS;
		
		turns = new LinkedList<>();
	}
	
	public void startTurn() {
		Turn newTurn = new Turn();
		currentTurn = newTurn;
		turns.add(newTurn);
	}
	
	public int continueTurn() { // I'm sure there's a better way to structure this logically, but I don't have it right now.
		if (rollAgain()) {
			currentTurn.addRoll();
			currentTurn.determineRollOutcome();
			if (currentTurn.getChipsLost() == 0) {
				
				return 4;
			}
			else if (currentTurn.doubleSkunk) {
					playerScore = 0;
				
				return 3;
			}
			else if (currentTurn.getChipsLost() == 2) {
				return 2;
			}
			else {
				
				return 1;
			}
	}
		else {
			playerScore = playerScore + currentTurn.getTurnScore();
			return 0;
		}
	}
	
	public int getPlayerScore()
	{
		return playerScore;
	}
	
	public void setPlayerScore(int value)
	{
		playerScore = value;
	}
	
	public Turn getCurrentTurn() { //This is probably not great practice, but some of these numbers are buried so far down I can't figure out how else to get to them.
		return currentTurn;
	}
	
	public int getChips()
	{
		return chips;
	}
	
	public void setChips(int value)
	{
		chips = value;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setRollDecision(String input)
	{
		rollDecision = input;
	}
	
	public boolean rollAgain()
	{
		if (rollDecision.equals("y"))
			return true;
		else 
			return false;
	}
 /*	
	public void saveTurn(Turn inputTurn)
	{
		turns.add(inputTurn);
		
		if (inputTurn.getPointsWon() == -1)
		{
			playerScore = 0;
		}
		else
		{
			playerScore += inputTurn.getPointsWon();
		}
		
		chips -= inputTurn.getChipsLost();
	}
	
	public LinkedList<Turn> getTurns()
	{
		return turns;
	}
	
	public static void main(String[] args)
	{
		Player me = new Player("the dude");
		
		Turn newTurn = new Turn();
		newTurn.addRoll();
		newTurn.addRoll();
		newTurn.addRoll();
		newTurn.addRoll();
		newTurn.addRoll();
		
		me.saveTurn(newTurn);
		
		StdOut.println(me.turns.get(0));
	}
	*/
}
