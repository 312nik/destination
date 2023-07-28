package ru.uxair.flight.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.uxair.flight.entity.Destination;

import java.util.List;

public interface DestinationRepository extends JpaRepository <Destination,String> {

    Destination findByAirportCodeContainingIgnoreCase(String airportCode);
    List <Destination> findByCityContainingIgnoreCase(String city, Sort sort);
    List <Destination> findByCountryNameContainingIgnoreCase(String countryName,Sort sort);
}

