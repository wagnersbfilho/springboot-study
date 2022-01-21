package br.com.devmedia.jm.woki.airport.service;

import java.util.List;

import br.com.devmedia.jm.woki.airport.persistence.model.Airport;

public interface FlightService {
	List<Airport> airportsByCity(String city);
	List<Airport> airportsByCountry(String country);
	Airport airportByIataCode(String iataCode);
}