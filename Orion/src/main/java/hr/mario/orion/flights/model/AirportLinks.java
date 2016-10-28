package hr.mario.orion.flights.model;

public class AirportLinks {
	
	public String url;
	public String name;
	public String urlWiki;
	public String nameWiki;
	
	public AirportLinks(String urlWiki) {
		this.urlWiki = urlWiki;
		this.name = this.urlWiki.substring(this.urlWiki.lastIndexOf("/")+1).replace("_", " ");
		this.nameWiki = this.name.indexOf(":") != -1? this.name.substring(this.name.indexOf(":")+1).trim(): this.name;
		this.url = "/Airports/List_of_Airports/" + this.nameWiki;
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

	public String getUrlWiki() {
		return urlWiki;
	}

	public void setUrlWiki(String urlWiki) {
		this.urlWiki = urlWiki;
	}

	public String getNameWiki() {
		return nameWiki;
	}

	public void setNameWiki(String nameWiki) {
		this.nameWiki = nameWiki;
	}
	
	
	
}
