package hr.mario.orion.flights.model;

public class AirportLinks {
	
	public String url;
	public String name;
	
	public AirportLinks(String url) {
		this.url = url;
		this.name = this.url.substring(this.url.lastIndexOf("/")+1).replace("_", " ");
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
}
