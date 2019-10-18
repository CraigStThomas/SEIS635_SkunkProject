import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest
{
	Player myPlayer;

	@Before
	public void setUp() throws Exception
	{
		myPlayer = new Player("myPlayer");
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void gettersAndSettersTest()
	{
		assertEquals("Player Name Error.", "myPlayer", myPlayer.getName());
		myPlayer.setChips(25);
		assertEquals("Chip Count Error.", 25, myPlayer.getChips());
		myPlayer.setPlayerScore(35);
		assertEquals("Player Score Error.", 35, myPlayer.getPlayerScore());
	}
	
	@Test
	public void rollDecisionTest()
	{
		myPlayer.setRollDecision("y");
		assertEquals("Roll Decision Error.", true, myPlayer.rollAgain());
		myPlayer.setRollDecision("n");
		assertEquals("Roll Decision Error.", false, myPlayer.rollAgain());
	}
	
	@Test
	public void startTurnTest()
	{
		myPlayer.startTurn();
		myPlayer.getCurrentTurn().addRoll();
		assertEquals("Turn Error.", myPlayer.getCurrentTurn().getCurrentRoll().getRolledValues().get(0) + myPlayer.getCurrentTurn().getCurrentRoll().getRolledValues().get(1), myPlayer.getCurrentTurn().getCurrentRoll().getRollScore());
	}

	@Test
	public void continueTurnTest()
	{
		myPlayer.startTurn();
		myPlayer.setRollDecision("y");
		if (myPlayer.continueTurn() > 4)
		{
			fail("Continue Turn Error.");
		}
		myPlayer.setRollDecision("n");
		if (myPlayer.continueTurn() > 4)
		{
			fail("Continue Turn Error.");
		}	
	}
}
