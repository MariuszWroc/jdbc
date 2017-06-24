package pl.mariuszczarny;

import static pl.mariuszczarny.util.Context.FILE;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mariusz Czarny
 *
 */
public final class MainApp {
	private static Logger LOGGER = Logger.getLogger(MainApp.class.getName());

	private MainApp() {
	}
	
	public static void main(String[] argv) {
		Executor executor = new Executor(FILE);
		LOGGER.log(Level.INFO, "Executing..");
		executor.execute();
	}

}
