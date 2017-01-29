package pl.mariuszczarny.dao;

import java.sql.SQLException;

import pl.mariuszczarny.util.SqlQuery;

/**
 * @author Mariusz Czarny
 *
 */
public interface CommonDataAccess {
	/**
	 * @param statement
	 * @return
	 * @throws SQLException
	 */
	String create(SqlQuery statement) throws SQLException;
	/**
	 * @param statement
	 * @return
	 * @throws SQLException
	 */
	String read(SqlQuery statement) throws SQLException;
	/**
	 * @param statement
	 * @return
	 * @throws SQLException
	 */
	String update(SqlQuery statement) throws SQLException;
	/**
	 * @param statement
	 * @return
	 * @throws SQLException
	 */
	String delete(SqlQuery statement) throws SQLException;
}
