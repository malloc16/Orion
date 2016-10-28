package hr.mario.orion.flights.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import hr.mario.orion.flights.model.Airport;
import hr.mario.orion.flights.model.AirportLinks;

@Service("airportService")
public class AirportServiceImpl implements AirportService {
	Logger log = Logger.getLogger(AirportServiceImpl.class);

	@Override
	public List<Airport> getAirports() {
		
		return null;
	}
	
	@Override
	public List<AirportLinks> getLinks(){
		log.debug("dohvati linkove");
		List<AirportLinks> lista = new ArrayList<>();
		String urlStart = "https://en.wikipedia.org";
		Document doc;
		
		try{
			doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_airports").get();
			Element airportList = doc.select("p").get(3);
			Elements linkovi = airportList.select("a[href]");
			
			for(Element link : linkovi){
				//lista.add(urlStart + link.attr("href"));
				lista.add(new AirportLinks(urlStart + link.attr("href")));
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}	
		return lista;
	}
	
	@Override
	public List<Airport> getAirportList(){
		log.debug("dohvati zracne luke");
		List<Airport> lista = new ArrayList<>();
		
		
		return lista;
	}

	@Override
	public void ispis() {
		List<AirportLinks> lista = getLinks();
		lista.forEach(s -> {
			log.debug("URL: " + s.url + ", name: " + s.name + "\n WIKI URL: " + s.urlWiki + ", WIKI name:" + s.nameWiki);
		});
		
	}
	
}
