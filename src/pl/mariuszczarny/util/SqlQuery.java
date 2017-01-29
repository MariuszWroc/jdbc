package pl.mariuszczarny.util;

public enum SqlQuery {
	CREATE("CREATE TABLE dbuser (id int, firstname varchar(100), lastname varchar(100), address varchar(200));");

	private final String query;

	private SqlQuery(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
	
}
