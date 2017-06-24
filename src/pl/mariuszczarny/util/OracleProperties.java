package pl.mariuszczarny.util;

public enum OracleProperties {
	DB_DRIVER("oracle.jdbc.driver.OracleDriver"),
	DB_CONNECTION("jdbc:oracle:thin:@localhost:1521:SID"),
	DB_USER("STL_PDAPI_TXN"),
	DB_PASSWORD("root");
	
	private final String value;

	private OracleProperties(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
