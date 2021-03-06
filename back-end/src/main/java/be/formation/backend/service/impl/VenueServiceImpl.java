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
        LOGGER.info("update a venue entry by using information: {}", id);
        Optional<Venue> venue1 = venueRepository.findById(id);
        if (venue1.isPresent()) {
            venue1.get().setCity(venue.getCity());
            venue1.get().setName(venue.getName());
        } else {
            LOGGER.info("the object does not exist, entry by using information: => ", id);
        }
        Venue venue2 = venueRepository.save(venue1.get());
        LOGGER.info("update a 'venue' entry by using information: {}", venue2);
        return venue2;
    }

    @Override
    public boolean deleteVenue(long id) {
        boolean found = false;
        LOGGER.info("Delete a venue entry by using information : {}", id);
        Venue venue = venueRepository.findById(id).get();
        if (venue != null && found) {
            venueRepository.delete(venue);
            found = true;
            LOGGER.info("deleted a venue entry: {}", id);
        } else {
            LOGGER.info("Unable to delete. venue with id {} not found", id);
        }
        return found;
    }
}
