package br.com.devmedia.jm.woki.airport.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devmedia.jm.woki.airport.persistence.model.Airport;


public interface AirportRepo extends JpaRepository<Airport, Long> {
	List<Airport> findByCityIgnoreCase(String city);
	List<Airport> findByCountryIgnoreCase(String country);
	Airport findByIataCodeIgnoreCase(String iataCode);
}
