package be.formation.backend.service;

import be.formation.backend.model.entity.Venue;

public interface VenueService {

    Venue registerVenue(String name, String city);
    public Venue UpdateVenue(Long id, Venue venue);
    boolean deleteVenue(long id );
}
