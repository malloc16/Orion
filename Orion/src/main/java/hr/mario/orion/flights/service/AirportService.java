package hr.mario.orion.flights.service;

import java.util.List;

import hr.mario.orion.flights.model.Airport;
import hr.mario.orion.flights.model.AirportLinks;

public interface AirportService {
	
	public List<Airport> getAirports();
	
	public void ispis();
	
	public List<Airport> getAirportList();
	
	public List<AirportLinks> getLinks();
	
	public List<Airport> getAirportByName(String name);
}
