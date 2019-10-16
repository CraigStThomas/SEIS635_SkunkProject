import java.util.LinkedList;

import edu.princeton.cs.introcs.StdOut;

public class Rolls
{
	Dice dice;
	LinkedList<Integer> rolledValues;
	InterpretedRoll result;
	private int rollScore;
	
	public Rolls()
	{
		dice = new Dice();
		dice.roll();
		rolledValues = dice.getLastRoll();
		result = RollInterpreter.interpretRoll(rolledValues);
		rollScore = rolledValues.get(0) + rolledValues.get(1);
	}
	
	// for use with predictable dice
	public Rolls(Dice inputDice, boolean rollThem)
	{
		dice = inputDice;
		
		// this exists so that we can avoid burning the first predicted value in loaded dice
		// not the best solution, but it's all i can think of right now
		if (rollThem != false)
		{
			dice.roll();
		}
		rolledValues = dice.getLastRoll();
		result = RollInterpreter.interpretRoll(rolledValues);
	}
	
	public LinkedList<Integer> getRolledValues() {
		return rolledValues;
		}
	
	public int getRollScore() {
		return rollScore;
	}
	
	public InterpretedRoll getResult() {
		return result;
	}
	
	public String toString()
	{
//		String returnString = dice.toString() + "...interpreted as: " + result;
		String returnString = "Dice with last roll: ";
		
		for (int i = 0; i < rolledValues.size(); i++)
		{
			returnString += ((i == 0) ? "" : " + ") + rolledValues.get(i);
		}
		
		returnString += "...interpreted as: " + result;
		
		return returnString;
	}
	
/*	
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
*/
}
