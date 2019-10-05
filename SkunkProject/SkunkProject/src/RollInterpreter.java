import java.util.LinkedList;

public class RollInterpreter
{
	public static InterpretedRoll interpretRoll(LinkedList<Integer> values)
	{
		InterpretedRoll returnValue = InterpretedRoll.undefined;
		
		if (values.size() == 2)
		{
			// check for double skunk
			if ((values.get(0) == 1) && (values.get(1) == 1))
			{
				returnValue = InterpretedRoll.doubleSkunk;
			}
			// check for deuce skunk
			else if (
						((values.get(0) == 1) || (values.get(1) == 1)) &&
						((values.get(0) == 2) || (values.get(1) == 2))
					)
			{
				returnValue = InterpretedRoll.skunkDeuce;
			}
			// check for any other skunk
			else if ((values.get(0) == 1) || (values.get(1) == 1))
			{
				returnValue = InterpretedRoll.skunk;
			}
			// any non-skunk
			else
			{
				returnValue = InterpretedRoll.pointScoring;
			}
		}
		
		return returnValue;
	}
}
