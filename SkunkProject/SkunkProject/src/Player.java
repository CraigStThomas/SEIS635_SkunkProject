import java.util.LinkedList;

import edu.princeton.cs.introcs.StdOut;

public class Player
{
	private int points;
	private int chips;
	private String name;
	private LinkedList<Turn> turns;
	
	public Player(String inputName)
	{
		name = inputName;
		points = GameConstants.STARTING_POINTS;
		chips = GameConstants.STARTING_CHIPS;
		
		turns = new LinkedList<>();
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public void setPoints(int value)
	{
		points = value;
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
	
	public boolean playerRollDecision()
	{
		boolean rollDecision = false;
		
		if (Math.random() < 0.5)
		{
			rollDecision = true;
		}
		
		return rollDecision;
	}
	
	public void saveTurn(Turn inputTurn)
	{
		turns.add(inputTurn);
		
		if (inputTurn.getPointsWon() == -1)
		{
			points = 0;
		}
		else
		{
			points += inputTurn.getPointsWon();
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
}
