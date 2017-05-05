package hr.mario.orion.flights.model.LowFareSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fare {
	@JsonProperty("total_price")
	private double totalPrice;
	
	@JsonProperty("price_per_adult")
	private PricePerAdult pricePerAdult;
	
	private Restrictions restrictions;
	
	public Fare(double totalPrice, PricePerAdult pricePerAdult, Restrictions restrictions) {
		super();
		this.totalPrice = totalPrice;
		this.pricePerAdult = pricePerAdult;
		this.restrictions = restrictions;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public PricePerAdult getPricePerAdult() {
		return pricePerAdult;
	}
	public void setPricePerAdult(PricePerAdult pricePerAdult) {
		this.pricePerAdult = pricePerAdult;
	}
	public Restrictions getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(Restrictions restrictions) {
		this.restrictions = restrictions;
	}
	
	@Override
	public String toString() {
		return "Fare [totalPrice=" + totalPrice + ", pricePerAdult=" + pricePerAdult + ", restrictions=" + restrictions + "]";
	}
	
}
