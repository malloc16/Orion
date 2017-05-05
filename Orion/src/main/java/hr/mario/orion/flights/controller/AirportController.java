package hr.mario.orion.flights.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hr.mario.orion.flights.model.Airport;
import hr.mario.orion.flights.model.AirportLinks;
import hr.mario.orion.flights.service.AirportService;

@Controller
@RequestMapping(value = { "/Airports", "/Airports/" })
public class AirportController {
	private static Logger log = Logger.getLogger(AirportController.class);

	@Autowired
	private AirportService airportService;

	@ModelAttribute("airportList")
	public List<Airport> initAirportList() {
		List<Airport> al = new ArrayList<Airport>();
		al.add(new Airport("iata", "iaco", "name", "loacation", "timezone", "dst"));
		return al;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap map) {
		log.debug("welcome()");
		airportService.ispis();
		List<AirportLinks> airports = airportService.getLinks();
		map.addAttribute("airports", airports);

		return "airport";
	}
	//params ={"pageNum", "pageSize"},
	@RequestMapping(value = { "/List_of_Airports/{ap}", "/List_of_Airports/{ap}/{type}" }, method = RequestMethod.GET)
	public ModelAndView getAirportListByName(/* @PathVariable("ap") String s */ @PathVariable Map<String, String> pathVariablesMap, ModelAndView modelAndView, ModelMap model, HttpServletRequest req,
			@RequestParam(value = "pageNum", required = false)String pageNum, @RequestParam(value = "pageSize", required = false) String pageSize
			) {
		log.debug("getAirportListByName()");
		String s = pathVariablesMap.get("ap");
		String type = pathVariablesMap.get("type");
		PagedListHolder<Airport> airportPageHolder = null;

		log.debug("s: " + s + ", type: " + type);
		log.debug("pgNm: " + pageNum + ", pgSz: "+ pageSize);
		if (s == null) {
			modelAndView.setViewName("redirect:/Airports");
			return modelAndView;
		}

		if (type == null) {
			airportPageHolder = new PagedListHolder<>();
			airportPageHolder.setSource(airportService.getAirportByName(s));
			airportPageHolder.setPageSize(10);

			req.getSession().setAttribute("pagedAirportList", airportPageHolder);
			//Ovo mozda maknuti iz ifa
			req.getSession().setAttribute("ap", s);
			
			printPageDetails(airportPageHolder);
		} else if (type.equals("next")) {
			airportPageHolder = (PagedListHolder<Airport>) req.getSession().getAttribute("pagedAirportList");
			airportPageHolder.nextPage();
			printPageDetails(airportPageHolder);
		} else if (type.equals("prev")) {
			airportPageHolder = (PagedListHolder<Airport>) req.getSession().getAttribute("pagedAirportList");
			airportPageHolder.previousPage();
			printPageDetails(airportPageHolder);
		} else {
			airportPageHolder = (PagedListHolder<Airport>) req.getSession().getAttribute("pagedAirportList");
			int pageNumber = Integer.parseInt(type);
			log.debug("Page number: " + pageNumber);
			airportPageHolder.setPage(pageNumber);
			printPageDetails(airportPageHolder);
		}
		
		if(pageSize != null){
			try{
				int pgSz = Integer.parseInt(pageSize);
				airportPageHolder.setPageSize(pgSz);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		if(pageNum != null){
			try{
				int pgNm = Integer.parseInt(pageNum);
				//vidjeti kaj s ovim
				if(pgNm > 0){
					pgNm--;
				}else{
					pgNm = 0;
				}
				airportPageHolder.setPage(pgNm);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		model.addAttribute("airportList", airportService.getAirportByName(s));
		// System.out.println(airports.size());
		/*
		 * airports.forEach(a ->{ System.out.println("[");
		 * System.out.println("\tIATA: " + a.getIata() + ", ICAO: " +
		 * a.getIcao() + ", Airport Name: " + a.getName());
		 * System.out.println("\tLocation:\tCity: " + a.getCity() + ", State: "
		 * + a.getState() + ", Country: " + a.getCountry());
		 * System.out.println("\tTimeZone: " + a.getTimeZone() + ", Start DST: "
		 * + a.getStartDST() + ", End DST: " + a.getEndDST() );
		 * System.out.println("]"); });
		 */

		modelAndView.setViewName("airportList");
		return modelAndView;
	}

	@RequestMapping(value = "/{ap}", method = RequestMethod.GET)
	public ModelAndView getAirportListByName2(@PathVariable("ap") String s, ModelAndView model) {
		log.debug("getAirportListByName2()");
		model.setViewName("airportList");
		return model;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/List_of_Airports/", "/List_of_Airports" })
	public String returnToAirport(ModelMap map) {
		log.debug("returnToAirport()");
		return "redirect:/Airports";
	}

	/**
	 * Samo za testiranje
	 * 
	 * @param productList
	 */
	private void printPageDetails(PagedListHolder productList) {

		System.out.println("curent page - productList.getPage() :" + productList.getPage());

		System.out.println("Total Num of pages - productList.getPageCount :" + productList.getPageCount());

		System.out.println("is First page - productList.isFirstPage :" + productList.isFirstPage());

		System.out.println("is Last page - productList.isLastPage :" + productList.isLastPage());
	}
}
