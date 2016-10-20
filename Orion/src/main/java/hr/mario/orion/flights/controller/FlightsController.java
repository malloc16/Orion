package hr.mario.orion.flights.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import hr.mario.orion.flights.model.FlightSearch;
import hr.mario.orion.flights.validator.FlightSearchValidator;

@Controller
@RequestMapping(value = "/Flights")
public class FlightsController {
	
	private static Logger log = Logger.getLogger(FlightsController.class);
	
	@Autowired
	FlightSearchValidator validator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap map){
		log.debug("welcome()");
		FlightSearch search = new FlightSearch();
		map.addAttribute("search", search);
		
		return "flight";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("search") FlightSearch search, BindingResult result, SessionStatus status){
		log.debug("------------------------POST-----------------------");
		validator.validate(search, result);
		
		if(result.hasErrors()){
			return "flight";
		}
		
		return "results";
	}
	
}
