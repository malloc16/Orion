package hr.mario.orion.flights.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("msgService")
public class MessagesPropertiesFileServiceImpl implements MessagesPropertiesFile {
	
	@Autowired
	Environment env;
	
	@Override
	public HashMap<String, String> getProperties() {
		HashMap<String, String> mapa = new HashMap<>();
		mapa.put("error.minLength", env.getProperty("error.minLength"));
		mapa.put("error.maxLength", env.getProperty("error.maxLength"));
		mapa.put("error.empty", env.getProperty("error.empty"));
		
		return mapa;
	}

	@Override
	public void readProperties() {
		System.out.println("Reading properties file...");
		System.out.println("error.minLength: " + env.getProperty("error.minLength"));
		System.out.println("error.maxLength: " + env.getProperty("error.maxLength"));
		
	}

}
