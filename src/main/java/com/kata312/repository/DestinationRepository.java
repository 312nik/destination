package com.kata312.repository;

import com.kata312.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DestinationRepository extends JpaRepository<Destination, String> {

    List<Destination> findByOrderByCity(String city);
    List<Destination> findByOrderByCountryName(String countryName);

}

