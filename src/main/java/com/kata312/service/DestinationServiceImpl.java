package com.kata312.service;

import com.kata312.model.Role;
import com.kata312.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }


    @Override
    public Destination findDestinationById(String id) {
        return destinationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("=" + id));
    }

    @Override
    public List<Destination> findDestinationByCity(String city) {
        return destinationRepository.findByOrderByCity(city);
    }

    @Override
    public List<Destination> findDestinationByCountryName(String countryName) {
        return destinationRepository.findByOrderByCountryName(countryName);
    }

    @Override
    @Transactional
    public void saveDestination(Destination destination) {
        destinationRepository.save(destination);
    }

    @Override
    @Transactional
    public void updateDestination(Destination destination) {
        destinationRepository.save(destination);
    }
}
