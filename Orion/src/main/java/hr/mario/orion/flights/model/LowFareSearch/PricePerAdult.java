package hr.mario.orion.flights.model.LowFareSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PricePerAdult {
	@JsonProperty("total_fare")
	private double totalFare;
	private double tax;
	
	public PricePerAdult(double totalFare, double tax) {
		super();
		this.totalFare = totalFare;
		this.tax = tax;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	@Override
	public String toString() {
		return "PricePerAdult [totalFare=" + totalFare + ", tax=" + tax + "]";
	}
	
	
}
