package pl.mariuszczarny.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public enum SqlQuery {
	INSERT("INSERT INTO DBUSER" + "(USER_ID, FIRSTNAME, LASTNAME, CREATED_DATE) " + "VALUES"
			+ "(1,'mkyong','system', " + "to_date('" + getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))");

	private static final String DATE_PATTERN = "MM/dd/yyyy HH:mm:ss";
	private final String query;

	private SqlQuery(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
	
	private static String getCurrentTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
		Date today = Calendar.getInstance().getTime();
		return dateFormat.format(today);
	}
}
