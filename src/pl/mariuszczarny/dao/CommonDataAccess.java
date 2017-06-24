package pl.mariuszczarny.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mariusz Czarny
 *
 */
public interface CommonDataAccess {
	String read(List<String> selectQueries, String columnName) throws SQLException;
	void closeConnection() throws SQLException;
	int[] makeBatch(List<String> queries) throws SQLException;
}
