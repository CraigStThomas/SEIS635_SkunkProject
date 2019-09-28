import java.util.LinkedList;

import edu.princeton.cs.introcs.*;

public class Scratch
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
//		Die myDie = new Die();
		LinkedList<Integer> myOrder = new LinkedList<>();
		myOrder.add(1);
		myOrder.add(2);
		myOrder.add(3);
		Die myDie = new Die(myOrder);
		System.out.println(myDie.getLastRoll());
		myDie.roll();
		System.out.println(myDie.getLastRoll());
		myDie.roll();
		System.out.println(myDie.getLastRoll());
		myDie.roll();
		System.out.println(myDie.getLastRoll());
		myDie.roll();
		System.out.println(myDie.getLastRoll());
		myDie.roll();
		System.out.println(myDie.getLastRoll());
	}

}
