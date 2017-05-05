package hr.mario.orion.flights.model.LowFareSearch;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import hr.mario.orion.flights.model.Currency;

public class LowFareSearch {
	
	private Currency currency;
	@JsonProperty("results")
	private List<LowFareSearchResults> lowFareSearchResults;
	public LowFareSearch(Currency currency, List<LowFareSearchResults> lowFareSearchResults) {
		super();
		this.currency = currency;
		this.lowFareSearchResults = lowFareSearchResults;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public List<LowFareSearchResults> getLowFareSearchResults() {
		return lowFareSearchResults;
	}
	public void setLowFareSearchResults(List<LowFareSearchResults> lowFareSearchResults) {
		this.lowFareSearchResults = lowFareSearchResults;
	}
	@Override
	public String toString() {
		return "LowFareSearch [currency=" + currency + ", lowFareSearchResults=" + lowFareSearchResults + "]";
	}
	
	
}
