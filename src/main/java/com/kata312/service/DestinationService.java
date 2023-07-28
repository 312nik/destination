package ru.uxair.flight.service;

import ru.uxair.flight.entity.Destination;

import java.util.List;

public interface DestinationService {
    Destination findDestinationByAirportCode(String airportCode);
    List<Destination> findDestinationByCity(String city);
    List <Destination> findDestinationByCountryName(String countryName);
    void saveDestination(Destination destination);
    void updateDestination(Long id,Destination destination);

}
