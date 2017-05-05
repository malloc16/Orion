package hr.mario.orion.flights.model.LowFareSearch;

import java.util.List;

public class Itineraries {
	private List<Inbound> inbounds;
	private List<Outbound> outbounds;
	public Itineraries(List<Inbound> inbounds, List<Outbound> outbounds) {
		super();
		this.inbounds = inbounds;
		this.outbounds = outbounds;
	}
	public List<Inbound> getInbounds() {
		return inbounds;
	}
	public void setInbounds(List<Inbound> inbounds) {
		this.inbounds = inbounds;
	}
	public List<Outbound> getOutbounds() {
		return outbounds;
	}
	public void setOutbounds(List<Outbound> outbounds) {
		this.outbounds = outbounds;
	}
	@Override
	public String toString() {
		return "Itineraries [inbounds=" + inbounds + ", outbounds=" + outbounds + "]";
	}
	
}
