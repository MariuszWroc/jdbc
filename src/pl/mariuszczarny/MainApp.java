package pl.mariuszczarny;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.mariuszczarny.connection.DatabaseConnector;
import pl.mariuszczarny.dao.DataAccess;
import pl.mariuszczarny.util.SqlQuery;

/**
 * @author Mariusz Czarny
 *
 */
public final class MainApp {
	private static Logger LOGGER = Logger.getLogger(MainApp.class.getName());

	private MainApp() {
	}
	
	public static void main(String[] argv) {
		try {
			Connection dbConnection = DatabaseConnector.getDBConnection();
			DataAccess dataAccess = new DataAccess(dbConnection);
			dataAccess.create(SqlQuery.INSERT);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
		}
	}

}
