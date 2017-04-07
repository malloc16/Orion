package hr.mario.orion.flights.model;

public class Airport {
	private String iata;
	private String icao;
	private String name;
	private String location;
	private String timeZone;
	private String dayLightSavingTime;
//	private String dayLightSavingTimeStart;
//	private String dayLightSavingTimeEnd;
	
	public Airport(String iata, String icao, String name, String location, String timeZone, String dayLightSavingTime) {
		super();
		this.iata = iata;
		this.icao = icao;
		this.name = name;
		this.location = location;
		this.timeZone = timeZone;
		this.dayLightSavingTime = dayLightSavingTime;
	}
	
	public Airport(){
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getDayLightSavingTime() {
		return dayLightSavingTime;
	}

	public void setDayLightSavingTime(String dayLightSavingTime) {
		this.dayLightSavingTime = dayLightSavingTime;
	}

	@Override
	public String toString() {
		return "Airport [iata=" + iata + ", icao=" + icao + ", name=" + name + ", location=" + location + ", timeZone=" + timeZone + ", dayLightSavingTime=" + dayLightSavingTime + "]";
	}
	
	public String getStartDST(){
		if(this.getDayLightSavingTime() != null && this.getDayLightSavingTime().length() != 0){
			return this.getDayLightSavingTime().substring(0, this.getDayLightSavingTime().indexOf("-"));
		}else{
			return "";
		}
	}
	
	public String getEndDST(){
		if(this.getDayLightSavingTime() != null && this.getDayLightSavingTime().length() != 0){
			return this.getDayLightSavingTime().substring(this.getDayLightSavingTime().indexOf("-")+1, this.getDayLightSavingTime().length());
		}else{
			return "";
		}	
	}
	
	public String getCity(){
		return this.location.substring(0, this.location.indexOf(","));
	}
	
	public String getState(){
		int zarezi = this.location.length() - this.location.replace(",", "").length();
		if(zarezi == 2){
			return location.substring(location.indexOf(",")+1, location.length()).substring(0, location.substring(location.indexOf(",")+1, location.length()).indexOf(",")).trim();
		}else{
			return "";
		}
	}
	
	public String getCountry(){
		return this.location.substring(this.location.lastIndexOf(",") + 1, this.location.length()).trim();
	}
	
	
}
