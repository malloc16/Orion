package hr.mario.orion.flights.service;

import java.util.HashMap;

public interface MessagesPropertiesFile {
	
	HashMap<String, String> getProperties();
	
	void readProperties();
	
}
