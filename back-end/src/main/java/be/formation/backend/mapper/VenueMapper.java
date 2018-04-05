package be.formation.backend.mapper;

import be.formation.backend.model.dto.VenueDTO;
import be.formation.backend.model.entity.Venue;

import java.util.Optional;

public class VenueMapper {
    public static Venue dtoToEntity(VenueDTO venueDTO) {
        if (venueDTO == null) {
            throw new IllegalArgumentException(" objet venueDTO  ne peut pas être null ");
        }
        Venue venue = new Venue();
        venue.setCity(venue.getCity() != null ? venue.getCity() : null);
        venue.setName(venue.getName() != null ? venue.getName() : null);
        return venue;
    }


    public static VenueDTO EntityToDto(Venue venue) {
        if (venue == null) {
            throw new IllegalArgumentException(" venue  ne peut pas être null ");
        }
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setCity(venue.getCity() != null ? venue.getCity() : null);
        venueDTO.setName(venue.getName() != null ? venue.getName() : null);
        return venueDTO;
    }
}
