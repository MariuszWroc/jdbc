package pl.mariuszczarny.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.mariuszczarny.connection.DatabaseConnector;

public final class DataAccess implements CommonDataAccess {
	private static final String MESSAGE_AFTER_TRANSACTION = "PASSED";
	private static Logger LOGGER = Logger.getLogger(DataAccess.class.getName());
	private Connection dbConnection;

	public DataAccess(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public String read(List<String> selectQueries, String columnName) throws SQLException {
		Statement statement = null;
		String resultMessage = "NO SELECT RESULT";

		try {
			statement = openConnection();
			for (String query : selectQueries) {
				LOGGER.info(query);

				ResultSet rs = statement.executeQuery(query);
				LOGGER.info("Table was created! " + rs.getString(columnName));
				rs.close();
			}

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
		return resultMessage;
	}

	@Override
	public void closeConnection() throws SQLException {
		if (dbConnection != null) {
			dbConnection.close();
		}
	}

	private Statement openConnection() throws SQLException {
		Statement statement;
		if (dbConnection == null) {
			dbConnection = DatabaseConnector.getDBConnection();
		}
		statement = dbConnection.createStatement();
		return statement;
	}

	@Override
	public int[] makeBatch(List<String> queries) throws SQLException {
		int[] executeBatch = new int [0];
		if (!queries.isEmpty()) {
			dbConnection.setAutoCommit(false);

			Statement statement = null;
			try {
				statement = openConnection();

				for (String query : queries) {
					LOGGER.info(query);
					statement.addBatch(query);
					LOGGER.info("Table was created!");
				}

				executeBatch = statement.executeBatch();
				dbConnection.commit();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
			} finally {
				if (statement != null) {
					statement.close();
				}
			}
		}

		return executeBatch;
	}
}
