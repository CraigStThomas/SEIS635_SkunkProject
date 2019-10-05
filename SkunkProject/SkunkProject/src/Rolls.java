import java.util.LinkedList;

import edu.princeton.cs.introcs.StdOut;

public class Rolls
{
	Dice dice;
	LinkedList<Integer> rolledValues;
	InterpretedRoll result;
	
	public Rolls()
	{
		dice = new Dice();
		
		dice.roll();
		rolledValues = dice.getLastRoll();
		result = RollInterpreter.interpretRoll(rolledValues);
	}
	
	// for use with predictable dice
	public Rolls(Dice inputDice)
	{
		dice = inputDice;
		
		dice.roll();
		rolledValues = dice.getLastRoll();
		result = RollInterpreter.interpretRoll(rolledValues);
	}
	
	public String toString()
	{
		String returnString = dice.toString() + "...interpreted as: " + result;		
		
		return returnString;
	}
	
	
	public static void main(String[] args)
	{
		LinkedList<Rolls> rollSet = new LinkedList<>();
		
		while (true)
		{
			Rolls thisRoll = new Rolls();
			rollSet.add(thisRoll);
			if (thisRoll.result != InterpretedRoll.pointScoring)
			{
				break;
			}
		}

		int pointsTotal = 0;
		
		for (int i = 0; i < rollSet.size(); i++)
		{
			StdOut.println(rollSet.get(i));
			
			if (rollSet.get(i).result == InterpretedRoll.pointScoring)
			{
				pointsTotal += rollSet.get(i).rolledValues.get(0) + rollSet.get(i).rolledValues.get(1);
			}
		}

		StdOut.println("total points scored (ignoring the skunk penalty) = " + pointsTotal);
	}

}
