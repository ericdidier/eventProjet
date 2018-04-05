package be.formation.backend.model.dto;

import be.formation.backend.model.entity.Venue;

/**
 * Classe qui permet de définir un DTO concernant le lieu.
 */
public class VenueDTO {

    public  String name;
    public String city;

    public VenueDTO() {
    }

    public VenueDTO(Venue venue) {
        this.name = venue.getName();
        this.city = venue.getCity();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
