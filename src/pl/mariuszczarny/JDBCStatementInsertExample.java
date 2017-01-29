package pl.mariuszczarny;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.mariuszczarny.connection.DatabaseConnector;
import pl.mariuszczarny.util.SqlQuery;

/**
 * @author Mariusz Czarny
 *
 */
public class JDBCStatementInsertExample {
	private static Logger LOGGER = Logger.getLogger(JDBCStatementInsertExample.class.getName());
	
	public static void insertRecordIntoDbUserTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		try {
			dbConnection = DatabaseConnector.getDBConnection();
			statement = dbConnection.createStatement();

			LOGGER.info(SqlQuery.INSERT.getQuery());

			statement.executeUpdate(SqlQuery.INSERT.getQuery());

			LOGGER.info("Record is inserted into DBUSER table!");

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}


}
