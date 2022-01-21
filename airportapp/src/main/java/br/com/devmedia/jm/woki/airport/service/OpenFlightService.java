package br.com.devmedia.jm.woki.airport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmedia.jm.woki.airport.persistence.model.Airport;
import br.com.devmedia.jm.woki.airport.persistence.repository.AirportRepo;

@Service
public class OpenFlightService implements FlightService {
	@Autowired
	private AirportRepo airportRepository;
	
	/* (non-Javadoc)
	 * @see br.com.devmedia.jm.woki.airport.service.FlightService#airportsByCity(java.lang.String)
	 */
	@Override
	public List<Airport> airportsByCity(String city) {
		return airportRepository.findByCityIgnoreCase(city);
	}
	
	/* (non-Javadoc)
	 * @see br.com.devmedia.jm.woki.airport.service.FlightService#airportsByCountry(java.lang.String)
	 */
	@Override
	public List<Airport> airportsByCountry(String country) {
		return airportRepository.findByCountryIgnoreCase(country);
	}
	
	/* (non-Javadoc)
	 * @see br.com.devmedia.jm.woki.airport.service.FlightService#airportByIataCode(java.lang.String)
	 */
	@Override
	public Airport airportByIataCode(String iataCode) {
		return airportRepository.findByIataCodeIgnoreCase(iataCode);
	}
}
