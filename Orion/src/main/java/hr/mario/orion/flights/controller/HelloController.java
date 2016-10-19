package hr.mario.orion.flights.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import hr.mario.orion.flights.service.MessagesPropertiesFileServiceImpl;

@Controller
@RequestMapping("/")
public class HelloController {
	private static Logger log = Logger.getLogger(HelloController.class);
	
	@Autowired
	private MessagesPropertiesFileServiceImpl msgService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String hi(ModelMap map){
		log.debug("hello()");
		msgService.readProperties();
		citajMapu();
//		createJson();
//		createJson2();
		
		return "hello";
	}
	
	public void citajMapu(){
		log.debug("citajMapu()");
		HashMap<String, String> mapa = msgService.getProperties();
		for(Map.Entry<String, String> entry: mapa.entrySet()){
			log.info("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}
	
	public void createJson(){
		log.debug("createJson()");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("icao", "LDDU");
		myMap.put("iata", "DBV");
		myMap.put("name", "Dubrovnik Airport");
		myMap.put("city", "Dubrovnik");
		myMap.put("country", "HR");
		myMap.put("elevation", 527);
		myMap.put("lat", 42.5614013672);
		myMap.put("lon", 18.2681999207);
		myMap.put("tz", "Europe/Zagreb");
		
		try {
			mapper.writeValue(new File("C:\\Users\\mblazek\\Desktop\\dokument.json"), myMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createJson2(){
		log.debug("createJson2()");
		JsonFactory factory = new JsonFactory();
		try {
			JsonGenerator generator = factory.createGenerator(new File("C:\\Users\\mblazek\\Desktop\\dokument2.json"), JsonEncoding.UTF8);
			generator.writeStartObject();
//			generator.writeStartArray();
			generator.writeArrayFieldStart("Polje1");
			generator.writeStringField("icao", "LDDU");
			generator.writeStringField("iata", "DBV");
			generator.writeStringField("name", "Dubrovnik Airport");
			generator.writeStringField("city", "Dubrovnik");
			generator.writeStringField("country", "HR");
			generator.writeNumberField("elevation", 527);
			generator.writeNumberField("lat", 42.5614013672);
			generator.writeNumberField("lon", 18.2681999207);
			generator.writeStringField("tz", "Europe/Zagreb");
//			generator.writeEndArray();
//			generator.writeEndObject();
//			
//			generator.writeStartObject();
//			generator.writeArrayFieldStart("Polje2");
//			generator.writeObjectFieldStart("test2");
//			generator.writeStringField("icao", "x");
//			generator.writeStringField("iata", "x");
//			generator.writeStringField("name", "x x");
//			generator.writeStringField("city", "x");
//			generator.writeStringField("country", "HR");
//			generator.writeNumberField("elevation", 10);
//			generator.writeNumberField("lat", 42.5614013672);
//			generator.writeNumberField("lon", 18.2681999207);
//			generator.writeStringField("tz", "Europe/Zagreb");			
//			generator.writeEndArray();
//			
			generator.writeEndObject();
			
			generator.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
