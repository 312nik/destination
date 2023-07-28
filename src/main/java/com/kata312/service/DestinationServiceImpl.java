package ru.uxair.flight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Destination;
import ru.uxair.flight.repository.DestinationRepository;
import ru.uxair.flight.service.DestinationService;
import ru.uxair.flight.util.exceptions.ResourceNotFoundException;


import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;
    @Autowired
    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Destination findDestinationByAirportCode(String airportCode) {

        Destination destination= destinationRepository.findByAirportCodeContainingIgnoreCase(airportCode);

        if (destination != null) {
            return destination;
        } else {
            throw new ResourceNotFoundException(airportCode);
        }

    }
    @Override
    public List<Destination> findDestinationByCity(String city) {
        List <Destination> getByCity=destinationRepository.findByCityContainingIgnoreCase(city,
                Sort.by("airportName"));

        if ( !getByCity.isEmpty()) {
            return  getByCity;
        }else {
           return null;
        }
    }
    @Override
    public List<Destination> findDestinationByCountryName(String countryName) {

        List<Destination> getByCountryName=destinationRepository.findByCountryNameContainingIgnoreCase(countryName,
                Sort.by("city").and(Sort.by("airportName")));

        if ( !getByCountryName.isEmpty()) {
            return getByCountryName;
        }else {
            return null;
        }
    }
    @Override
    public void saveDestination(Destination destination) {
        destinationRepository.save(destination);
    }
    @Override
    public void updateDestination(Long id ,Destination destination) {

        if (destinationRepository.existsById(String.valueOf(id))) {
            destination.setId(id);
            destinationRepository.save(destination);
        }else {
            throw new ResourceNotFoundException("=" + id);
        }
    }

}


