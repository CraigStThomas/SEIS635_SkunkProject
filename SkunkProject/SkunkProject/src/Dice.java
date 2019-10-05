import java.util.LinkedList;

import edu.princeton.cs.introcs.StdOut;

/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */
 
public class Dice
{
	/////////////////////////////////////////////////////////////////////////
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top
	/////////////////////////////////////////////////////////////////////////

	private final int DEFAULT_DIE_COUNT = 2;
	private LinkedList<Die> die;
	private LinkedList<Integer> lastDiceRoll;
	
	/////////////////////////////////////////////////////////////////////////
	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables
	/////////////////////////////////////////////////////////////////////////
	
	// typically used constructor, it will make 2 unpredictable dice
	public Dice()
	{
		die = new LinkedList<>();
		
		for (int i = 0; i < DEFAULT_DIE_COUNT; i++)
		{
			die.add(new Die());
		}
		
		// i dont call roll() here because the Die constructor already does
		// this also is consistent with my predictable dice constructor which
		// has an even better reason to not roll here
		saveLastRoll();
	}
	
	// overloaded constructors
	
	// i dunno, maybe we want to make a dice set with more than 2 dice, or 1 die...or 0 die?
	// these dice will also be unpredictable
	public Dice(int dieCount)
	{
		die = new LinkedList<>();
		
		for (int i = 0; i < dieCount; i++)
		{
			die.add(new Die());
		}
		
		saveLastRoll();
	}
	
	// make a set of die, each with their own roll order the number of roll orders
	// passed in will determine how many dice are created
	// the method parameter is a nested linked list
	// each entry in the outer linked list is a set of ordered rolls
	// an ordered roll is a linked list with each entry as an integer value representing
	// the value to be rolled
	public Dice(LinkedList<LinkedList<Integer>> rollOrders)
	{
		die = new LinkedList<>();
		
		for (int i = 0; i < rollOrders.size(); i++)
		{
			die.add(new Die(rollOrders.get(i)));
		}

		saveLastRoll();
	}
	
	// making a dice object out of existing die objects
	// i had to remove it because it shares a signature with
	// my other overloaded constructor, and i think
	// this constructor isn't very useful...for now
//	public Dice(LinkedList<Die> inputDie)
//	{
//		die = (LinkedList<Die>) inputDie.clone();
//		
//		// roll() isn't called because (presumably) these die already have been rolled
//		saveLastRoll();
//	}

	/////////////////////////////////////////////////////////////////////////
	// Instance methods can also be declared anywhere
	// Convention: after constructors
	/////////////////////////////////////////////////////////////////////////
	
	// here i am returning a linked list of integers representing what
	// each die rolled
	public LinkedList<Integer> getLastRoll()
	{
		return lastDiceRoll;
	}

	// this is the 2nd part of the typical roll() method, it is
	// split into its own method as it sometimes must be called
	// without a roll() being called
	private void saveLastRoll()
	{
		lastDiceRoll = new LinkedList<>();
		
		// build a linked list with each entry representing a die's rolled value
		for (int i = 0; i < die.size(); i++)
		{
			lastDiceRoll.add(die.get(i).getLastRoll());
		}
	}

	public void roll()
	{		
		for (int i = 0; i < die.size(); i++)
		{
			die.get(i).roll();
		}
		
		saveLastRoll();
	}

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	// e.g. Roll of 4 + 3
	public String toString()
	{
		String returnString = "Dice with last roll: ";
		
		for (int i = 0; i < die.size(); i++)
		{
			returnString += ((i == 0) ? "" : " + ") + lastDiceRoll.get(i);
		}		
		
		return returnString;
	}

	// static methods can go anywhere - but at end is standard

	public static void main(String[] args)
	{
		/////////////////////////////////////////////////////////////////////////
		// first we will make some dice, later we will play with them
		/////////////////////////////////////////////////////////////////////////
		
		Dice dice1;
		
		// 0 = 2 predictable dice
		// 1 = 10 unpredictable dice
		// any other value = 2 unpredictable dice
		final int DICE_TYPE = 2;
		
		switch (DICE_TYPE)
		{
			case 0:
				// a nested LinkedList, might look strange
				// it is a list of orders of rolls
				LinkedList<LinkedList<Integer>> listOfOrders = new LinkedList<>();
				
				// make an order of rolls
				LinkedList<Integer> order = new LinkedList<>();

				// add some items to the list
				order.add(1);
				order.add(2);
				order.add(3);
				order.add(4);
				order.add(5);
				order.add(6);
				order.add(1);
				order.add(2);
				order.add(3);
				order.add(4);
				order.add(5);
				order.add(6);
				
				// add this ordered list to our list of orders
				listOfOrders.add(order);
				
				// make a new order of rolls
				order = new LinkedList<>();
				
				// add some items to it
				order.add(6);
				order.add(5);
				order.add(4);
				order.add(3);
				order.add(2);
				order.add(1);
				order.add(6);
				order.add(5);
				order.add(4);
				order.add(3);
				order.add(2);
				order.add(1);

				// add this ordered list to our list of orders
				listOfOrders.add(order);
				
				// make a dice set with the specified roll orders
				dice1 = new Dice(listOfOrders);
				break;
				
			case 1:
				dice1 = new Dice(10);
				break;

			default:
				dice1 = new Dice();
				break;
		}
		
		/////////////////////////////////////////////////////////////////////////
		// we made some dice, now we play with them a little
		// there are things die can do that aren't exercised here
		/////////////////////////////////////////////////////////////////////////
		
		// change this number to see different ways of playing with the dice
		// 0 = roll the dice and query their rolled value, note this only works if the dice have exactly 2 die
		// any other value = roll the dice and use the toString() method to print the results
		final int PLAY_WITH_DICE = 0;
		
		final int NUM_TRIALS = 12;
		
		switch (PLAY_WITH_DICE)
		{
			case 0:
				for (int i = 0; i < NUM_TRIALS; i++)
				{
					// i dont want the first pass to roll the dice, otherwise we'd burn the first of any set roll order
					if (i != 0)
					{
						dice1.roll();
					}

					// the following tests won't make sense (or be safe) without making sure this dice set has exactly 2 die
					if (dice1.die.size() == 2)
					{
						// check for double skunk
						if ((dice1.lastDiceRoll.get(0) == 1) && (dice1.lastDiceRoll.get(1) == 1))
						{
							StdOut.println("double skunk!:  " + " " + dice1.lastDiceRoll.get(0) + " + " + dice1.lastDiceRoll.get(1));
						}
						// check for deuce skunk
						else if (
									((dice1.lastDiceRoll.get(0) == 1) || (dice1.lastDiceRoll.get(1) == 1)) &&
									((dice1.lastDiceRoll.get(0) == 2) || (dice1.lastDiceRoll.get(1) == 2))
								)
						{
							StdOut.println("skunk & a deuce:" + " " + dice1.lastDiceRoll.get(0) + " + " + dice1.lastDiceRoll.get(1));
						}
						// check for any other skunk
						else if ((dice1.lastDiceRoll.get(0) == 1) || (dice1.lastDiceRoll.get(1) == 1))
						{
							StdOut.println("skunk + other:  " + " " + dice1.lastDiceRoll.get(0) + " + " + dice1.lastDiceRoll.get(1));
						}
						// any non-skunk
						else
						{
							StdOut.println("non-skunk:      " + " " + dice1.lastDiceRoll.get(0) + " + " + dice1.lastDiceRoll.get(1));
						}
					}
				}
				break;
			
			default:
				for (int i = 0; i < NUM_TRIALS; i++)
				{
					// i dont want the first pass to roll the dice, otherwise we'd burn
					// the first of any set roll order
					if (i != 0)
					{
						dice1.roll();
					}
					StdOut.println(dice1);
				}
				break;
		}
	}
}
