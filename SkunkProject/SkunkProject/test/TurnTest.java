import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TurnTest
{
	private Dice predictableDice;
	private Dice predictableDice1;
	private LinkedList<Integer>				testOrder;
	private LinkedList<Integer>				testOrder1;
	private LinkedList<LinkedList<Integer>>	listOfOrders;
	private LinkedList<LinkedList<Integer>>	listOfOrders1;
	private Turn myTurn;
	
	@Before
	public void setUp() throws Exception
	{
		testOrder		= new LinkedList<>();
		testOrder1		= new LinkedList<>();
		listOfOrders	= new LinkedList<>();
		listOfOrders1	= new LinkedList<>();
		testOrder.add(1);
		testOrder.add(2);
		testOrder.add(3);
		testOrder.add(4);
		testOrder.add(5);
		testOrder.add(6);
		testOrder1.add(1);
		testOrder1.add(1);
		testOrder1.add(1);
		testOrder1.add(1);
		testOrder1.add(1);
		testOrder1.add(1);
		listOfOrders.add(testOrder);
		listOfOrders.add(testOrder);
		listOfOrders1.add(testOrder);
		listOfOrders1.add(testOrder1);
		predictableDice = new Dice(listOfOrders);
		predictableDice1 = new Dice(listOfOrders1);
		myTurn = new Turn();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void pointAndChipCountTest()
	{
		myTurn.addRoll(predictableDice, true);
		myTurn.addRoll(predictableDice, true);
		assertEquals("Count Error.", 10, myTurn.getPointsWon());
		assertEquals("Count Error.", 0, myTurn.getChipsLost());
		
		
		myTurn = new Turn();
		myTurn.addRoll(predictableDice1, false);
		assertEquals("Count Error.", -3, myTurn.getPointsWon());
		assertEquals("Count Error.", 4, myTurn.getChipsLost());

		myTurn = new Turn();
		predictableDice1.roll();
		myTurn.addRoll(predictableDice1, false);
		assertEquals("Count Error.", -2, myTurn.getPointsWon());
		assertEquals("Count Error.", 2, myTurn.getChipsLost());

		myTurn = new Turn();
		predictableDice1.roll();
		predictableDice1.roll();
		myTurn.addRoll(predictableDice1, false);
		assertEquals("Count Error.", -1, myTurn.getPointsWon());
		assertEquals("Count Error.", 1, myTurn.getChipsLost());
	}
	
	@Test
	public void randomRollTest()
	{
		myTurn = new Turn();
		myTurn.addRoll();
		assertEquals("Random Roll Error.", myTurn.getCurrentRoll().getRolledValues().get(0) + myTurn.getCurrentRoll().getRolledValues().get(1), myTurn.getCurrentRoll().getRollScore());
	}

	@Test
	public void stringTest()
	{
		myTurn = new Turn();
		myTurn.addRoll(predictableDice, true);
		assertEquals("String Error.", "Dice with last roll: 2 + 2...interpreted as: pointScoring\npoints won = 4\nchips lost = 0", myTurn.toString());
	}
}
