package be.formation.backend.service.impl;

import be.formation.backend.model.entity.Venue;
import be.formation.backend.repository.VenueRepository;
import be.formation.backend.service.VenueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
@Transactional
public class VenueServiceImpl implements VenueService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VenueServiceImpl.class);
    private final VenueRepository venueRepository;


    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }


    @Override
    public Venue registerVenue(String name, String city) {
        LOGGER.info("Creating a new Venue entry by using information: {}", name + "" + city);
        Venue venue = new Venue();
        venue.setName(name);
        venue.setCity(city);
        Venue venue1 = venueRepository.save(venue);
        LOGGER.info("Created a new venue entry: {}", venue1);
        return venue1;
    }

    @Override
    public Venue UpdateVenue(Long id, Venue venue) {
        Venue venue2 = new Venue();
        LOGGER.info("update a venue entry by using information: {}", id);
        Optional<Venue> venue1 = venueRepository.findById(id);
        if (venue != null) {
            venue2 = venue1.get();
            venue2.setId(id);
            venue2.setCity(venue.getCity());
            venue2.setName(venue.getName());
            venue2 = venueRepository.save(venue2);

            LOGGER.info("update a venue entry by using information: {}", venue1);
        } else {
            LOGGER.info("the object does not exist, entry by using information: => ", id);
            return venue2;
        }

        return venue2;
    }
}
