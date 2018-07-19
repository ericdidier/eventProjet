package be.formation.backend.mapper;

import be.formation.backend.model.dto.VenueDTO;
import be.formation.backend.model.entity.Venue;

import java.util.Optional;

/**
 * Transformation entre le modèle des entités JPA et les objets DTO .
 *
 */
public class VenueMapper {


    /**
     * Transforme une entité JPA {@link Venue} en objet TDO {@link VenueDTO}.
     *
     * @param Objet venueDTO
     * @return
     */
    public static Venue dtoToEntity(VenueDTO venueDTO) {
        if (venueDTO == null) {
            throw new IllegalArgumentException(" objet venueDTO  ne peut pas être null ");
        }
        Venue venue = new Venue();
        venue.setCity(venue.getCity() != null ? venue.getCity() : null);
        venue.setName(venue.getName() != null ? venue.getName() : null);
        return venue;
    }


    /**
     * Transforme une entité JPA {@link Venue} en objet TDO {@link VenueDTO}.
     *
     * @param venue
     * @return objet TDO
     */
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
