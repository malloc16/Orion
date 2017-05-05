package hr.mario.orion.flights.model.LowFareSearch;

public class Origin {
	private String airport;
	private String terminal;
	
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
	public Origin(String airport, String terminal) {
		super();
		this.airport = airport;
		this.terminal = terminal;
	}
	@Override
	public String toString() {
		return "Origin [airport=" + airport + ", terminal=" + terminal + "]";
	}
	
	
}
