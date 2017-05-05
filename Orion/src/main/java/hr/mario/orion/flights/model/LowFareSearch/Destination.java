package hr.mario.orion.flights.model.LowFareSearch;

public class Destination {
	private String airport;
	private String terminal;
	
	public Destination(String airport, String terminal) {
		super();
		this.airport = airport;
		this.terminal = terminal;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	@Override
	public String toString() {
		return "Destination [airport=" + airport + ", terminal=" + terminal + "]";
	}
	
	
}
