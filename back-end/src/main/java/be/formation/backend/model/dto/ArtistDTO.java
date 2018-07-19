package be.formation.backend.model.dto;

import be.formation.backend.model.entity.Artist;

public class ArtistDTO {
    public  Long  id ;
    public String name ;
    public String description;
    public String imageUrl ;

    public ArtistDTO(Artist artist){
        this.id = artist.getId();
        this.name = artist.getName();
        this.description = artist.getDescription();
        this.imageUrl = artist.getImageUrl();
    }

    public ArtistDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
