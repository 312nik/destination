package ru.uxair.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.flight.entity.Destination;
import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository <Destination,String> {


    List<Destination> findByCity(String city);
    List <Destination> findByCountryName(String countryName);
}

