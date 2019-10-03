import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class DiceTest {
	private LinkedList<Integer> testOrder = new LinkedList<>();
	private LinkedList<LinkedList<Integer>> listOfOrders = new LinkedList<>();
	private Dice testDice;
	private LinkedList<Integer> targetList = new LinkedList<>(); // Creates LinkedList to compare against resulting Linked List
	
	@Before
	public void setUp() throws Exception {
		testOrder.add(1);
		testOrder.add(2);
		testOrder.add(3);
		testOrder.add(4);
		testOrder.add(5);
		testOrder.add(6);
		listOfOrders.add(testOrder);
		listOfOrders.add(testOrder);
		testDice = new Dice(listOfOrders);
	}
	@Test
	public void setupTest() { // Confirms correct setup
		targetList.add(1);
		targetList.add(1);
		assertEquals("Setup Error.", testDice.getLastRoll(), targetList);
		targetList.clear();
	}
	@Test
	public void cycleTest() { // Given Die passed all tests, confirms that Dice.roll rolls all dice.
		testDice.roll();
		targetList.add(2);
		targetList.add(2);
		assertEquals("Cycle Error.", testDice.getLastRoll(), targetList);
		targetList.clear();
		testDice.roll();
		targetList.add(3);
		targetList.add(3);
		assertEquals("Cycle Error.", testDice.getLastRoll(), targetList);
		targetList.clear();
		testDice.roll();
		targetList.add(4);
		targetList.add(4);
		assertEquals("Cycle Error.", testDice.getLastRoll(), targetList);
		targetList.clear();
		testDice.roll();
		targetList.add(5);
		targetList.add(5);
		assertEquals("Cycle Error.", testDice.getLastRoll(), targetList);
		targetList.clear();
		testDice.roll();
		targetList.add(6);
		targetList.add(6);
		assertEquals("Cycle Error.", testDice.getLastRoll(), targetList);
		targetList.clear();
	}
}
