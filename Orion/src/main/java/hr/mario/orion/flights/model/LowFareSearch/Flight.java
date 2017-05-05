package hr.mario.orion.flights.model.LowFareSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flight {
	
	@JsonProperty("departs_at")
	private String departsAt;
	
	@JsonProperty("arrives_at")
	private String arrivesAt;
	
	private Origin origin;
	private Destination destination;
	
	@JsonProperty("marketing_airline")
	private String marketingAirline;
	
	@JsonProperty("operating_airline")
	private String operatingAirline;
	
	@JsonProperty("flight_number")
	private String flightNumber;
	private String aircraft;
	
	@JsonProperty("booking_info")
	private BookingInfo bookingInfo;
	public Flight(String departsAt, String arrivesAt, Origin origin, Destination destination, String marketingAirline, String operatingAirline, String flightNumber, String aircraft,
			BookingInfo bookingInfo) {
		super();
		this.departsAt = departsAt;
		this.arrivesAt = arrivesAt;
		this.origin = origin;
		this.destination = destination;
		this.marketingAirline = marketingAirline;
		this.operatingAirline = operatingAirline;
		this.flightNumber = flightNumber;
		this.aircraft = aircraft;
		this.bookingInfo = bookingInfo;
	}
	public String getDepartsAt() {
		return departsAt;
	}
	public void setDepartsAt(String departsAt) {
		this.departsAt = departsAt;
	}
	public String getArrivesAt() {
		return arrivesAt;
	}
	public void setArrivesAt(String arrivesAt) {
		this.arrivesAt = arrivesAt;
	}
	public Origin getOrigin() {
		return origin;
	}
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public String getMarketingAirline() {
		return marketingAirline;
	}
	public void setMarketingAirline(String marketingAirline) {
		this.marketingAirline = marketingAirline;
	}
	public String getOperatingAirline() {
		return operatingAirline;
	}
	public void setOperatingAirline(String operatingAirline) {
		this.operatingAirline = operatingAirline;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public BookingInfo getBookingInfo() {
		return bookingInfo;
	}
	public void setBookingInfo(BookingInfo bookingInfo) {
		this.bookingInfo = bookingInfo;
	}
	@Override
	public String toString() {
		return "Flight [departsAt=" + departsAt + ", arrivesAt=" + arrivesAt + ", origin=" + origin + ", destination=" + destination + ", marketingAirline=" + marketingAirline + ", operatingAirline="
				+ operatingAirline + ", flightNumber=" + flightNumber + ", aircraft=" + aircraft + ", bookingInfo=" + bookingInfo + "]";
	}
	
	
}
