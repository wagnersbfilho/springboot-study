package br.com.devmedia.jm.woki.airport.web.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmedia.jm.woki.airport.persistence.model.Airport;
import br.com.devmedia.jm.woki.airport.service.FlightService;

@RestController
@RequestMapping(value="/country")
public class CountrySearch {
	private static final Logger logger = LoggerFactory.getLogger(CountrySearch.class);
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value="/{countryName}", method=RequestMethod.GET)
	public List<Airport> search(@PathVariable String countryName) {
		List<Airport> retval = flightService.airportsByCountry(countryName);
		if(retval != null) {
			logger.info("Aeroportos do pais {}: {}", countryName, retval.size());
		} else {
			logger.info("Aeroportos do pais {}: 0", countryName);
		}
		return retval;
	}
}
