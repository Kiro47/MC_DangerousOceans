package me.kiroscorner.dangerousoceans.utils;

public enum DataAccess {
	// List of Enums with data values grabbed from config files.
	SQUID_SPAWN_CHANCE_CHANCE(FileManager.getInstance().config.getString("Squid_Override_Chance").replace("%", "")),
	SQUID_CHANGE_CAN_BE_ELDER(FileManager.getInstance().config.getString("Squid_Override_Can_Be_Elder")),
	SQUID_CHANGE_ELDER_CHANCE(FileManager.getInstance().config.getString("Guardian_Replacement_Is_Elder").replace("%", ""));
	
	// Value variable for internal enum value
	private String value;
	
	// Constructor which asserts the value per Enum
	private DataAccess(String value) {
		this.value = value;
	}
	
	// Simple retrieval of value from enum
	public String getValue() {
		return value;
	}
	
};
