import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RollsTest
{
	private Dice predictableDice;
	private Dice randomDice;
	private LinkedList<Integer>				testOrder;
	private LinkedList<LinkedList<Integer>>	listOfOrders;
	
	private Rolls randomRolls;
	private Rolls predictableRolls;
	
	@Before
	public void setUp() throws Exception
	{
		testOrder		= new LinkedList<>();
		listOfOrders	= new LinkedList<>();
		testOrder.add(1);
		testOrder.add(2);
		testOrder.add(3);
		testOrder.add(4);
		testOrder.add(5);
		testOrder.add(6);
		listOfOrders.add(testOrder);
		listOfOrders.add(testOrder);
		predictableDice = new Dice(listOfOrders);
		
		randomDice = new Dice();
		
		randomRolls = new Rolls();
		predictableRolls = new Rolls(predictableDice, true);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void getRolledValuesTest()
	{
		assertEquals("Rolled Values Error.", predictableRolls.getRolledValues().get(0), testOrder.get(1));
		assertEquals("Rolled Values Error.", predictableRolls.getRolledValues().get(1), testOrder.get(1));
	}
	
	@Test
	public void getRolledScoreTest()
	{
		assertEquals("Rolled Score Error.", randomRolls.getRolledValues().get(0) + randomRolls.getRolledValues().get(1), randomRolls.getRollScore());
	}
	
	@Test
	public void getResultTest()
	{
		assertEquals("Result Error.", InterpretedRoll.pointScoring, predictableRolls.getResult());
	}
	
	@Test
	public void stringTest()
	{
		assertEquals("String Error.", "Dice with last roll: 2 + 2...interpreted as: pointScoring", predictableRolls.toString());
	}

}
