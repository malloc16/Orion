package hr.mario.orion.flights.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hr.mario.orion.flights.model.AirportLinks;
import hr.mario.orion.flights.service.AirportService;

@Controller
@RequestMapping(value={"/Airports", "/Airports/"})
public class AirportController {
	private static Logger log = Logger.getLogger(AirportController.class);
	
	@Autowired
	private AirportService airportService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap map){
		log.debug("welcome()");
		airportService.ispis();
		List<AirportLinks> airports = airportService.getLinks();
		map.addAttribute("airports", airports);
		
		return "airport";
	}
	
	@RequestMapping(value="/List_of_Airports/{ap}", method = RequestMethod.GET)
	public ModelAndView getAirportListByName(@PathVariable("ap") String s, ModelAndView model ){
		log.debug("getAirportListByName()");
		model.setViewName("airportList");
		return model;
	}
	
	@RequestMapping(value="/{ap}", method = RequestMethod.GET)
	public ModelAndView getAirportListByName2(@PathVariable("ap") String s, ModelAndView model ){
		log.debug("getAirportListByName2()");
		model.setViewName("airportList");
		return model;
	}
}
