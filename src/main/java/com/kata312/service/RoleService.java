package com.kata312.service;

import com.kata312.model.Role;
import java.util.List;

public interface DestinationService {



  Destination  findDestinationById(String id);

  List <Destination> findDestinationByCity(String city);

  List <Destination> findDestinationByCountryName(String countryName);

   void saveDestination(Destination destination);

   void updateDestination(Destination destination);


}
