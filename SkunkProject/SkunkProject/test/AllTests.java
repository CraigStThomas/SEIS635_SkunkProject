import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DiceTest.class, DieTest.class, GameTest.class, PlayerTest.class, RollInterpreterTest.class, RollsTest.class, TurnTest.class})
public class AllTests
{

}
