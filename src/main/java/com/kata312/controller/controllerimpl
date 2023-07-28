package ru.uxair.flight.controller.impl;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.controller.DestinationController;
import ru.uxair.flight.entity.dto.DestinationDto;
import ru.uxair.flight.service.DestinationService;
import ru.uxair.flight.util.mapper.DestinationMapper;
import java.util.List;
import java.util.stream.Collectors;


@RestController


public class DestinationControllerImpl implements DestinationController {

    private final DestinationService service;
    private final DestinationMapper mapper;
    public DestinationControllerImpl(DestinationService service, DestinationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @Override
      public ResponseEntity <DestinationDto>getDestinationById( @PathVariable  String airportCode) {
        DestinationDto destinationByAirportCode = mapper.convertToDestinationDto(service.findDestinationByAirportCode(airportCode));


        if (destinationByAirportCode!=null) {

            System.out.println(destinationByAirportCode);

            System.out.println(destinationByAirportCode);
            return new ResponseEntity<>(destinationByAirportCode, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity < List<DestinationDto>> getDestinationByCity( @PathVariable String city) {

        List<DestinationDto> getByCity = service.findDestinationByCity(city).
                stream().
                map(mapper::convertToDestinationDto)
                .collect(Collectors.toList());
        if (!getByCity.isEmpty()) {
            return new ResponseEntity<>(getByCity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
     public ResponseEntity <List<DestinationDto>> getDestinationByCountry( @PathVariable String countryName) {
        List <DestinationDto> getByCountryName= service.findDestinationByCountryName(countryName).
                stream().
                map(mapper::convertToDestinationDto)
                .collect(Collectors.toList());
        if (!getByCountryName.isEmpty()) {
            return new ResponseEntity<>(getByCountryName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> createDestination(@RequestBody DestinationDto destinationDto) {
        service.saveDestination(mapper.convertToDestination(destinationDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HttpStatus> updateDestination(@RequestBody  DestinationDto destinationDto) {
        service.saveDestination(mapper.convertToDestination(destinationDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
