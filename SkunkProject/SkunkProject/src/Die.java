import java.util.LinkedList;

import edu.princeton.cs.introcs.StdOut;

public class Die
{
	private int lastRoll;
	private LinkedList<Integer> rollOrder;

	public Die()
	{
		rollOrder = new LinkedList<>();
		this.roll();
	}
	
	// This constructor is used to make a predictable die. The roll order driven by
	// that of the provided LinkedList.  The current implementation will cycle to the
	// beginning of the order after reaching the end.  The roll() method discusses an
	// alternative approach.
	// You could call this constructor with an empty LinkedList to make an
	// unpredictable die.  It could be useful in the Dice constructor to make
	// 1 predictable die and 1 unpredictable die.
	public Die(LinkedList<Integer> inputRollOrder)
	{
		// Referencing the same LinkedList object could cause problems
		// in cases that have more than 1 die.  The 2+ die could
		// manipulate each other's roll orders.
		// Here, i do a shallow copy to avoid this problem.
		// A deep copy seems unnecessary (for now) since i don't expect 
		// any manipulation of the Integers the LinkedList points at.
		// TBD...can i fix the type safety warning?...do i care?
		
		rollOrder = (LinkedList<Integer>) inputRollOrder.clone();
		
		// roll the die so it has some value
		this.roll();
	}
	
	// maybe we want a way to make the die predictable after it already exists?
	// this could also be used to make a currently predictable die unpredictable
	// (with an empty LinkedList)
	public void loadTheDie(LinkedList<Integer> inputRollOrder)
	{
		// this shallow copy is discussed in the constructor
		rollOrder = (LinkedList<Integer>) inputRollOrder.clone();
		this.roll();
	}

	public int getLastRoll() // getter or accessor method
	{
		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return anything
	{
		if (rollOrder.isEmpty())
		{
			this.lastRoll = (int) (Math.random() * 6 + 1);
		}
		else
		{
			// pop() will remove the Integer from the LinkedList
			this.lastRoll = rollOrder.pop();
			
			// I then add the Integer back to the end of the LinkedList.
			// Removing this line would change this predictable die from cycling
			// endlessly through the predicted roll order, to it becoming unpredictable
			// (a normal die) after running through its roll order once.
			rollOrder.add(lastRoll);
		}
	}
	
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

	
	// some exmple code for playing with this die
	
	public static void main(String[] args)
	{
		final int DIE_TYPE = 2;
		final int NUM_TRIALS = 12;
		
		switch (DIE_TYPE)
		{
			// lets make an unpredictable die (typical die) and roll it a few times
			case 0:
				Die myDie = new Die();
				
				for (int i = 0; i < NUM_TRIALS; i++)
				{
					myDie.roll();
					StdOut.println(myDie);
				}
				break;
				
			// lets make a predictable die (useful for testing stuff) and roll it a few times
			case 1:
				LinkedList<Integer> myRollOrder1 = new LinkedList<>();
				
				myRollOrder1.add(1);
				myRollOrder1.add(2);
				myRollOrder1.add(3);
				myRollOrder1.add(4);
				myRollOrder1.add(5);
				myRollOrder1.add(6);
				myRollOrder1.add(1);
				myRollOrder1.add(2);
				myRollOrder1.add(3);
				myRollOrder1.add(4);
				myRollOrder1.add(5);
				myRollOrder1.add(6);
				
				Die myDie1 = new Die(myRollOrder1);
				
				for (int i = 0; i < NUM_TRIALS; i++)
				{
					// i dont want the first pass to roll the dice, otherwise we'd burn
					// the first of any set roll order
					if (i != 0)
					{
						myDie1.roll();
					}
					StdOut.println(myDie1);
				}
				break;
			
			// lets get funky
			case 2:
				// make that same predictable die from case 1
				LinkedList<Integer> myRollOrder2 = new LinkedList<>();

				myRollOrder2.add(1);
				myRollOrder2.add(2);
				myRollOrder2.add(3);
				myRollOrder2.add(4);
				myRollOrder2.add(5);
				myRollOrder2.add(6);
				myRollOrder2.add(1);
				myRollOrder2.add(2);
				myRollOrder2.add(3);
				myRollOrder2.add(4);
				myRollOrder2.add(5);
				myRollOrder2.add(6);
				
				Die myDie2 = new Die(myRollOrder2);
				
				for (int i = 0; i < NUM_TRIALS; i++)
				{
					// i dont want the first pass to roll the dice, otherwise we'd burn
					// the first of any set roll order
					if (i != 0)
					{
						myDie2.roll();
					}
					
					// we get funky halfway through the rolls, and make the die unpredictable
					if (i == NUM_TRIALS/2)
					{
						myDie2.loadTheDie(new LinkedList<Integer>());
					}
					
					StdOut.println(myDie2);
				}
				
				// more funk
				// re-load the roll order (make it predictable again) and roll a few more times
				myDie2.loadTheDie(myRollOrder2);
				
				for (int i = 0; i < 6; i++)
				{
					// i dont want the first pass to roll the dice, otherwise we'd burn
					// the first of any set roll order
					if (i != 0)
					{
						myDie2.roll();
					}
					
					StdOut.println(myDie2);
				}
				break;
		}		
	}
}
