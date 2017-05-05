package hr.mario.orion.flights.model.LowFareSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Restrictions {
	private boolean refundable;
	@JsonProperty("change_penalties")
	private boolean changePenalties;
	
	public Restrictions(boolean refundable, boolean changePenalties) {
		super();
		this.refundable = refundable;
		this.changePenalties = changePenalties;
	}
	public boolean isRefundable() {
		return refundable;
	}
	public void setRefundable(boolean refundable) {
		this.refundable = refundable;
	}
	public boolean isChangePenalties() {
		return changePenalties;
	}
	public void setChangePenalties(boolean changePenalties) {
		this.changePenalties = changePenalties;
	}
	
	@Override
	public String toString() {
		return "Restrictions [refundable=" + refundable + ", changePenalties=" + changePenalties + "]";
	}
	
	
}
