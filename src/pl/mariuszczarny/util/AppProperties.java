package pl.mariuszczarny.util;

public enum AppProperties {
	STATMEMENT_PATH("config/testscript.sql");
	
	private final String value;

	private AppProperties(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
