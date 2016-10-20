package hr.mario.orion.flights.model;

public class TravelClass {
	
	private int id;
	private String nameEng;
	private String nameHr;
	private String lang;
	
	public TravelClass(int id, String nameEng, String nameHr, String lang) {
		this.id = id;
		this.nameEng = nameEng;
		this.nameHr = nameHr;
		this.lang = lang;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameEng() {
		return nameEng;
	}
	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}
	public String getNameHr() {
		return nameHr;
	}
	public void setNameHr(String nameHr) {
		this.nameHr = nameHr;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		if(lang.equals("HR")){
			return nameHr;
		}else if(lang.equals("ENG")){
			return nameEng;
		}else{
			return "No trasn: " + nameEng;
		}
		
	}
	
	
}
