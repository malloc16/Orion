package hr.mario.orion.flights.model.LowFareSearch;

import java.util.List;

public class Inbound {
	private List<Flight> flights;

	public Inbound(List<Flight> flights) {
		super();
		this.flights = flights;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Inbound [flights=" + flights + "]";
	}
	
}
