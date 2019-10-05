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
		
		rollSet.add(new Rolls());
		rollSet.add(new Rolls());
		rollSet.add(new Rolls());
		rollSet.add(new Rolls());
		rollSet.add(new Rolls());
		
		for (int i = 0; i < rollSet.size(); i++)
		{
			StdOut.println(rollSet.get(i));
		}
	}

}
