import static org.junit.Assert.*;

import org.junit.Test;

public class SkunkAppTest {

	@Test
	public void testGetNumberofPlayer() {
		SkunkApp skApp = new SkunkApp();
		int numberOfPlayers = skApp.newGame.getPlayers().size();
		assertEquals(0, numberOfPlayers);
		skApp.setupGame(4);
		numberOfPlayers = skApp.newGame.getPlayers().size();
		assertEquals(4, numberOfPlayers);
	}


	@Test
	public void testSetNumberOfPlayers() {
		SkunkApp skApp = new SkunkApp();
		skApp.setupGame(8);
		int numberOfPlayers = skApp.newGame.getPlayers().size();
		assertEquals(8, numberOfPlayers);
	}
	@Test
	public void testRollAgain() {
		SkunkApp skApp = new SkunkApp();
		skApp.newGame.setRollAgain(true);
		assertEquals(true, skApp.newGame.isRollAgain());
	}

}