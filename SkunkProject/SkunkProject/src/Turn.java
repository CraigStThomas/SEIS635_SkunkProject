import java.util.LinkedList;

import edu.princeton.cs.introcs.StdOut;

public class Turn
{
	private LinkedList<Rolls> rolls;
	private Rolls currentRoll;
	private int chipsLost;
	
	public Turn()
	{
		rolls = new LinkedList<>();
	}
	
	public void addRoll()
	{
		Rolls newRoll = new Rolls();
		rolls.add(newRoll);
		currentRoll = newRoll;
	}
	
	public Rolls addRoll(Dice inputDice, boolean rollThem)
	{
		Rolls newRoll = new Rolls(inputDice, rollThem);
		rolls.add(newRoll);
		return newRoll;
	}	
//	public int getChipsLost() {
//		return chipsLost;
//	}
	public Rolls getCurrentRoll() {
		return currentRoll;
	}
	
	public int getPointsWon()
	{
		int returnValue = 0;
		
		for (int i = 0; i < rolls.size(); i++)
		{
			switch (rolls.get(i).getResult())
			{
				case skunk:
					return -1;
				case skunkDeuce:
					return -2;
				case doubleSkunk:
					return -3;
				case pointScoring:
					returnValue += (rolls.get(i).getRolledValues().get(0) + rolls.get(i).getRolledValues().get(1));
					break;
				default:
					return -255;  // this is an error, it should never happen...maybe need better return values as some confusing can arise with this and the double skunk situation???
			}
		}
		
		return returnValue;
	}
	
	public int getChipsLost()
	{		
		for (int i = 0; i < rolls.size(); i++)
		{
			switch (rolls.get(i).getResult())
			{
				case skunk:
					return 1;
				case skunkDeuce:
					return 2;
				case doubleSkunk:
					return 4;
				case pointScoring:
					break;
				default:
					return -2;  // this is an error, it should never happen...see comment in getPointsWon
			}
		}
		
		return 0;  // this should only happen if there are no skunks in the turn
	}
	
	public String toString()
	{
		String returnString = "";
		
		for (int i = 0; i < rolls.size(); i++)
		{
			if (i != 0)
			{
				returnString += "\n";
			}
			returnString += rolls.get(i).toString();
		}
		
		returnString += "\npoints won = " + getPointsWon();
		returnString += "\nchips lost = " + getChipsLost();
		
		return returnString;
	}
	
/*
	public static void main(String[] args)
	{
		final int TEST_TYPE = 0;
		
		Turn myTurn;
		
		switch (TEST_TYPE)
		{
			case 0:	// this example isn't great, as it allows rolls to continue if a skunk happens
				myTurn = new Turn();
				
				myTurn.addRoll();
				myTurn.addRoll();
				myTurn.addRoll();
				myTurn.addRoll();
				myTurn.addRoll();
				
				StdOut.println(myTurn);
				break;
				
			case 1:	// lets use some predictable dice
				LinkedList<LinkedList<Integer>> listOfOrders = new LinkedList<>();
				
				// make an order of rolls
				LinkedList<Integer> order = new LinkedList<>();

				// add some items to the list
//				order.add(1);
				order.add(2);
				order.add(3);
				order.add(4);
				order.add(5);
				order.add(2);
				
				// add this ordered list to our list of orders
				listOfOrders.add(order);
				
				// make a new order of rolls
				order = new LinkedList<>();
				
				// add some items to it
//				order.add(6);
				order.add(5);
				order.add(4);
				order.add(3);
				order.add(2);
				order.add(2);

				// add this ordered list to our list of orders
				listOfOrders.add(order);
				
				// make a dice set with the specified roll orders
				Dice dice1 = new Dice(listOfOrders);
				
				myTurn = new Turn();
				
				myTurn.addRoll(dice1, false);
				myTurn.addRoll(dice1, true);
				myTurn.addRoll(dice1, true);
				myTurn.addRoll(dice1, true);
				myTurn.addRoll(dice1, true);
				
				StdOut.println(myTurn);
				break;
		}
		
	}
*/
}
