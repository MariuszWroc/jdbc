package pl.mariuszczarny.util;

public enum MysqlProperties {
	DB_DRIVER("com.mysql.cj.jdbc.Driver"),
	DB_CONNECTION("jdbc:mysql://127.0.0.1:3306/myjdbc?serverTimezone=UTC"),
	DB_USER("root"),
	DB_PASSWORD("root");
	
	private final String value;

	private MysqlProperties(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
