package hr.mario.orion.flights.model.LowFareSearch;

import java.util.List;

public class Outbound {
	private List<Flight> flights;

	public Outbound(List<Flight> flights) {
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
		return "Outbound [flights=" + flights + "]";
	}
	
}
