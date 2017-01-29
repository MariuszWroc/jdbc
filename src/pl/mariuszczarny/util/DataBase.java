package pl.mariuszczarny.util;

public enum DataBase {
	DB_DRIVER("oracle.jdbc.driver.OracleDriver"),
	DB_CONNECTION("jdbc:oracle:thin:@localhost:1521:MKYONG"),
	DB_USER("root"),
	DB_PASSWORD("root");
	
	private final String value;

	private DataBase(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
