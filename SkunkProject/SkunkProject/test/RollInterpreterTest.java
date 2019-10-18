import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RollInterpreterTest
{
	private LinkedList<Integer> pointScoringResult;
	private LinkedList<Integer> skunkResult;
	private LinkedList<Integer> skunkDeuceResult;
	private LinkedList<Integer> doubleSkunkResult;

	@Before
	public void setUp() throws Exception
	{
		pointScoringResult = new LinkedList<>();
		pointScoringResult.add(5);
		pointScoringResult.add(5);
		
		skunkResult = new LinkedList<>();
		skunkResult.add(1);
		skunkResult.add(3);
		
		skunkDeuceResult = new LinkedList<>();
		skunkDeuceResult.add(1);
		skunkDeuceResult.add(2);
		
		doubleSkunkResult = new LinkedList<>();
		doubleSkunkResult.add(1);
		doubleSkunkResult.add(1);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testRollInterpretation()
	{
		assertEquals("Intepretation Error.", RollInterpreter.interpretRoll(pointScoringResult), InterpretedRoll.pointScoring);
		assertEquals("Intepretation Error.", RollInterpreter.interpretRoll(skunkResult), InterpretedRoll.skunk);
		assertEquals("Intepretation Error.", RollInterpreter.interpretRoll(skunkDeuceResult), InterpretedRoll.skunkDeuce);
		assertEquals("Intepretation Error.", RollInterpreter.interpretRoll(doubleSkunkResult), InterpretedRoll.doubleSkunk);
	}

}
