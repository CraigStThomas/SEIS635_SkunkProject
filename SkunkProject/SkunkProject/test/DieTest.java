import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DieTest
{
	private LinkedList<Integer>	testOrder	= new LinkedList<>();
	private Die					testDie, randomDie;

	@Before
	public void setUp() throws Exception
	{
		testOrder.add(1);
		testOrder.add(2);
		testOrder.add(3);
		testOrder.add(4);
		testOrder.add(5);
		testOrder.add(6);
		testDie = new Die(testOrder);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void setupTest()
	{ // Confirms the initial result is 1
		assertEquals("Setup Error.", testDie.getLastRoll(), 1);
	}

	@Test
	public void cycleTest()
	{ // Confirms the die cycles through the list
		testDie.roll();
		assertEquals("Cycling Error 2.", testDie.getLastRoll(), 2);
		testDie.roll();
		assertEquals("Cycling Error 3.", testDie.getLastRoll(), 3);
		testDie.roll();
		assertEquals("Cycling Error 4.", testDie.getLastRoll(), 4);
		testDie.roll();
		assertEquals("Cycling Error 5.", testDie.getLastRoll(), 5);
		testDie.roll();
		assertEquals("Cycling Error 6.", testDie.getLastRoll(), 6);
	}
	@Test
	public void popAddTest()
	{ // Confirms "rolled" values are added to the end of the list
		testDie.roll();
		testDie.roll();
		testDie.roll();
		testDie.roll();
		testDie.roll();
		testDie.roll();
		assertEquals("Pop/Add Error.", testDie.getLastRoll(), 1);
	}
	@Test
	public void loadTest()
	{ // Confirms a random die can become loaded
		randomDie = new Die(); // Empty Constructor creates random die
		randomDie.roll();
		randomDie.loadTheDie(testOrder);
		assertEquals("Load Error.", randomDie.getLastRoll(), 1);
		randomDie.roll();
		assertEquals("Load Error.", randomDie.getLastRoll(), 2);
		randomDie.roll();
		assertEquals("Load Error.", randomDie.getLastRoll(), 3);
		randomDie.roll();
		assertEquals("Load Error.", randomDie.getLastRoll(), 4);
		randomDie.roll();
		assertEquals("Load Error.", randomDie.getLastRoll(), 5);
		randomDie.roll();
		assertEquals("Load Error.", randomDie.getLastRoll(), 6);
	}
	@Test
	public void stringTest()
	{	// confirms toString prints as expected
//		setUp();
		assertEquals("String Error.", testDie.toString(), "Die: 1");
	}
}
