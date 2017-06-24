package pl.mariuszczarny;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.mariuszczarny.connection.DatabaseConnector;
import pl.mariuszczarny.dao.CommonDataAccess;
import pl.mariuszczarny.dao.DataAccess;
import pl.mariuszczarny.util.Context;

public class Executor {
	private static Logger LOGGER = Logger.getLogger(Executor.class.getName());
	QueringStrategy queryStrategy;

	public Executor(Context context) {
		chooseStrategy(context);
	}

	private void chooseStrategy(Context context) {
		switch (context) {
		case ENUM:
			LOGGER.log(Level.INFO, "Query will be read from enum");
			queryStrategy = new EnumReadStrategy();
			break;

		case FILE:
			LOGGER.log(Level.INFO, "Query will be read from file");
			queryStrategy = new FileReadStrategy();
			break;
		}
	}

	public void execute() {
		try {
			Connection dbConnection = DatabaseConnector.getDBConnection();
			CommonDataAccess dataAccess = new DataAccess(dbConnection);
			List<String> queries = queryStrategy.readyFrom();
			dataAccess.makeBatch(queries);
			dataAccess.closeConnection();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
		}
	}
}
