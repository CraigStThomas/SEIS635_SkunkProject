import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkIO {
	
	public static void menu() {
		boolean end =false;
		while(!end) {
			StdOut.println("Press H for help and S to start");
			String option = StdIn.readLine();
			if(option.equalsIgnoreCase("h")) {
				end = true;
				showHelp();
			}
			if (option.equalsIgnoreCase("s")) {
				end = true;
			}
			else {
				continue;
			}
		}
	}
	private static void showHelp() {
		StdOut.println("Help Goes here.");
	}
}
