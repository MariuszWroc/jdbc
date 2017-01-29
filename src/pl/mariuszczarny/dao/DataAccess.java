package pl.mariuszczarny.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.mariuszczarny.connection.DatabaseConnector;
import pl.mariuszczarny.util.SqlQuery;

public final class DataAccess implements CommonDataAccess{
	private static Logger LOGGER = Logger.getLogger(DataAccess.class.getName());
	private Connection dbConnection;
	
	public DataAccess(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public String create(SqlQuery query)  throws SQLException{
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
		return null;
	}
	
	@Override
	public String read(SqlQuery query) throws SQLException{
		@SuppressWarnings("unused")
		Statement statement = null;
		return null;
	}
	
	@Override
	public String update(SqlQuery query) throws SQLException{
		@SuppressWarnings("unused")
		Statement statement = null;
		return null;
	}
	
	@Override
	public String delete(SqlQuery query) throws SQLException{
		@SuppressWarnings("unused")
		Statement statement = null;
		return null;
	}
	
}
