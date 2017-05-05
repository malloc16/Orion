package hr.mario.orion.flights.model.LowFareSearch;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LowFareSearchResults {
	@JsonProperty("itineraries")
	private List<Itineraries> itineraries;
	private Fare fare;
	public LowFareSearchResults(List<Itineraries> itineraries, Fare fare) {
		super();
		this.itineraries = itineraries;
		this.fare = fare;
	}
	public List<Itineraries> getItineraries() {
		return itineraries;
	}
	public void setItineraries(List<Itineraries> itineraries) {
		this.itineraries = itineraries;
	}
	public Fare getFare() {
		return fare;
	}
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "LowFareSearchResults [itineraries=" + itineraries + ", fare=" + fare + "]";
	}
	
}
