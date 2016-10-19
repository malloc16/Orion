package hr.mario.orion.flights.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FlightSearch {
	private String apiKey;
	private String origin;
	private String destination;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arriveByDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnByDate;
	private Integer adultsNumber;
	private Integer childrenNumber;
	private Integer infantsNumber;
	private String includeAirlines;
	private String excludeAirlines;
	private Boolean nonStop;
	private Double maxPrice;
	private String currency;
	private String travelClass;
	private Integer numberOfResults;
	
	public FlightSearch(String apiKey, String origin, String destination, Date departureDate, Date returnDate, Date arriveByDate, Date returnByDate, Integer adultsNumber, Integer childrenNumber,
			Integer infantsNumber, String includeAirlines, String excludeAirlines, Boolean nonStop, Double maxPrice, String currency, String travelClass, Integer numberOfResults) {
		super();
		this.apiKey = apiKey;
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.arriveByDate = arriveByDate;
		this.returnByDate = returnByDate;
		this.adultsNumber = adultsNumber;
		this.childrenNumber = childrenNumber;
		this.infantsNumber = infantsNumber;
		this.includeAirlines = includeAirlines;
		this.excludeAirlines = excludeAirlines;
		this.nonStop = nonStop;
		this.maxPrice = maxPrice;
		this.currency = currency;
		this.travelClass = travelClass;
		this.numberOfResults = numberOfResults;
	}

	public FlightSearch() {
		this.apiKey = "";
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getArriveByDate() {
		return arriveByDate;
	}

	public void setArriveByDate(Date arriveByDate) {
		this.arriveByDate = arriveByDate;
	}

	public Date getReturnByDate() {
		return returnByDate;
	}

	public void setReturnByDate(Date returnByDate) {
		this.returnByDate = returnByDate;
	}

	public Integer getAdultsNumber() {
		return adultsNumber;
	}

	public void setAdultsNumber(Integer adultsNumber) {
		this.adultsNumber = adultsNumber;
	}

	public Integer getChildrenNumber() {
		return childrenNumber;
	}

	public void setChildrenNumber(Integer childrenNumber) {
		this.childrenNumber = childrenNumber;
	}

	public Integer getInfantsNumber() {
		return infantsNumber;
	}

	public void setInfantsNumber(Integer infantsNumber) {
		this.infantsNumber = infantsNumber;
	}

	public String getIncludeAirlines() {
		return includeAirlines;
	}

	public void setIncludeAirlines(String includeAirlines) {
		this.includeAirlines = includeAirlines;
	}

	public String getExcludeAirlines() {
		return excludeAirlines;
	}

	public void setExcludeAirlines(String excludeAirlines) {
		this.excludeAirlines = excludeAirlines;
	}

	public Boolean getNonStop() {
		return nonStop;
	}

	public void setNonStop(Boolean nonStop) {
		this.nonStop = nonStop;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	public Integer getNumberOfResults() {
		return numberOfResults;
	}

	public void setNumberOfResults(Integer numberOfResults) {
		this.numberOfResults = numberOfResults;
	}

	public String getApiKey() {
		return apiKey;
	}
	
	
	
	
	
	
}
