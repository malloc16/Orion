package hr.mario.orion.flights.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hr.mario.orion.flights.model.Currency;
import hr.mario.orion.flights.model.FlightSearch;
import hr.mario.orion.flights.model.TravelClass;
import hr.mario.orion.flights.validator.FlightSearchValidator;

@Controller
@RequestMapping(value = "/Flights")
//@SessionAttributes("search")
public class FlightsController {
	
	private static Logger log = Logger.getLogger(FlightsController.class);
	
	@ModelAttribute("travelClass")
	public List<TravelClass> intTravelClass(){
		List<TravelClass> lista = new ArrayList<>();
		String lang = "ENG";
		lista.add(new TravelClass(1, "First class", "Prva klasa", lang));
		lista.add(new TravelClass(1, "Business class", "Poslovna klasa", lang));
		lista.add(new TravelClass(1, "Economy class", "Ekonomska klasa", lang));
		
		return lista;
	}
	
	@ModelAttribute("currency")
	public List<Currency> intCurrency(){
		List<Currency> lista = new ArrayList<>();
		lista.add(new Currency(1, "Kuna", "HRK"));
		lista.add(new Currency(2, "Euro", "EUR"));
		lista.add(new Currency(3, "US dolar", "USD"));
		
		return lista;
	}
	
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
	public String submitForm(@ModelAttribute("search") FlightSearch search, BindingResult result, SessionStatus status, RedirectAttributes ra){
		log.debug("------------------------POST-----------------------");
		validator.validate(search, result);
		
		if(result.hasErrors()){
			return "flight";
		}
		ra.addFlashAttribute("search", search);
//		status.setComplete();
//		return "redirect:Flights/results";
		return "redirect:results";
	}
	
	@RequestMapping(value = "/results", method = RequestMethod.GET)
	public String success(@ModelAttribute("search") FlightSearch search, ModelMap map, HttpServletRequest request){
		log.debug("success()");
		log.debug(search.toString());
		log.debug("origin: " + search.getOrigin());
		if(search.getOrigin() == null){
			return "redirect:/Flights";
			
		}
		return "results";
	}
	
}
