package hr.mario.orion.flights.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import hr.mario.orion.flights.model.FlightSearch;
import hr.mario.orion.flights.service.AirportServiceImpl;
import hr.mario.orion.flights.service.MessagesPropertiesFileServiceImpl;

@Component
public class FlightSearchValidator implements Validator {
	Logger log = Logger.getLogger(FlightSearchValidator.class);

	//@Autowired
	//private MessagesPropertiesFileServiceImpl msgService;

	@Override
	public boolean supports(Class<?> clazz) {
		return FlightSearch.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		log.debug("validate(target, errors)");
		FlightSearch search = null;
		if (target instanceof FlightSearch) {
			search = (FlightSearch) target;
		}

		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "origin",
		// "error.origin", msgService.getProperties().get("error.empty"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "origin", "error.notEmpty.flightSearch.origin");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destination", "error.notEmpty.flightSearch.destination");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departureDate", "error.notEmpty.flightSearch.departureDate");

		if (search != null) {
			log.debug("searech nije null");
			//za datume polaska
			if(search.getDepartureDate() != null){
//				if(dateCompare(new Date(), search.getDepartureDate())){
					if(dateCompare2(new Date(), search.getDepartureDate()) < 0){
					errors.rejectValue("departureDate", "error.toSmallDate.flightSearch.departureDate");
				}
			}
			//za datume povratka
			if (search.getReturnDate() != null && search.getDepartureDate() != null) {
				if (dateCompare(search.getDepartureDate(), search.getReturnDate())) {
					errors.rejectValue("returnDate", "error.toSmallDate.flightSearch.returnDate");
				} else if (dateDiff(search.getDepartureDate(), search.getReturnDate())) {
					errors.rejectValue("returnDate", "error.toBigDate.flightSearch.returnDate");
				}

			}
			//za dojenèad
			if (search.getInfantsNumber() != null) {
				if (search.getAdultsNumber() != null && (search.getAdultsNumber() < search.getInfantsNumber())) {
					errors.rejectValue("infantsNumber", "error.maxNumber.flightSearch.infantsNumber");
				}else if(search.getAdultsNumber() == null){
					errors.rejectValue("infantsNumber", "error.notEmpty.flightSearch.infantsNumber");
				}
			}
			//za max broj rezultata
			if(search.getNumberOfResults() != null && search.getNumberOfResults() > 250){
				errors.rejectValue("numberOfResults", "error.maxNumber.flightSearch.numberOfResults");
			}
		}//kraj search ifa

	}

	private boolean dateDiff(Date dateDep, Date dateRet) {
		log.debug("dateDiff(dateDep, dateRet)");
		Calendar dep = Calendar.getInstance();
		dep.setTime(dateDep);

		Calendar ret = Calendar.getInstance();
		ret.setTime(dateRet);
		/*
		 * int yearDiff = ret.get(Calendar.YEAR) - dep.get(Calendar.YEAR); int
		 * monthDiff = ret.get(Calendar.MONTH) - dep.get(Calendar.MONTH); int
		 * dayDiff = ret.get(Calendar.DAY_OF_MONTH) -
		 * dep.get(Calendar.DAY_OF_MONTH);
		 */

		long date1 = dep.getTimeInMillis();
		long date2 = ret.getTimeInMillis();
//		long diff = TimeUnit.MILLISECONDS.toDays(Math.abs(date2 - date1));
		long diff = TimeUnit.MILLISECONDS.toDays(date2 - date1);
		log.debug("Date diff: " + diff);
		if (diff > 2)
			return true;
		else
			return false;

	}

	private boolean dateCompare(Date dateDep, Date dateRet) {
		log.debug("dateCompare(dateDep, dateRet)");
		return dateRet.getTime() - dateDep.getTime() < 0;
	}
	
	/**
	 * Raèuna razliku izmeðu datuma. Oduzima se date2 od date1.
	 * @param date1 Prvi datum.
	 * @param date2 Drugi datum.
	 * @return Razlika u danima.
	 */
	private int dateCompare2(Date date1, Date date2) {
		log.debug("dateCompare2(dateDep, dateRet)");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);
		long date1Time = c1.getTimeInMillis();
		long date2Time = c2.getTimeInMillis();
		long diff = TimeUnit.MILLISECONDS.toDays(date2Time - date1Time);
		log.debug("return (long value): " + diff);
		return (int)diff;
	}
	

}
