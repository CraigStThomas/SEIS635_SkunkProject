import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest
{
	Game myGame;
	
	@Before
	public void setUp() throws Exception
	{
		myGame = new Game();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void kittyTest()
	{
		assertEquals("Kitty Error.", 0, myGame.getKitty());
		myGame.addToKitty(7);
		assertEquals("Kitty Error.", 7, myGame.getKitty());
	}
	
	@Test
	public void playerTest()
	{
		myGame.addPlayer("myPlayer");
		myGame.setCurrentPlayer(0);
		assertEquals("Game.Player Error.", "myPlayer", myGame.getCurrentPlayer().getName());
		myGame.addPlayer("myPlayer1");
		myGame.setCurrentPlayer(1);
		assertEquals("Game.Player Error.", "myPlayer1", myGame.getCurrentPlayer().getName());
	}
}
