package be.formation.backend.mapper;

import be.formation.backend.model.dto.ArtistDTO;
import be.formation.backend.model.entity.Artist;

/**
 * Transformation entre le modèle des entités JPA et les objets DTO .
 * <br/>
 */
public class ArtistMapper {

    /**
     * Transforme une entité JPA {@link Artist} en objet TDO {@link ArtistDTO}.
     * @param artistDTO
     * @return objet DTO
     */
    public static Artist dtoToEntity(ArtistDTO artistDTO) {
        if (artistDTO == null) {
            throw new IllegalArgumentException(" objet artistDTO  ne peut pas être null ");
        }

        Artist artist = new Artist();
        artist.setId(artistDTO.getId());
        artist.setName(artistDTO.getName() != null ? artistDTO.getName() : null);
        artist.setDescription(artist.getDescription() != null ? artistDTO.getDescription() : null);
        artist.setImageUrl(artist.getImageUrl() != null ? artistDTO.getImageUrl() : null);
        return artist;
    }

    /**
     * Transforme un objet TDO {@link ArtistDTO} en une entité JPA {@link Artist}.
     * @param artist
     * @return objet artist
     */
    public static ArtistDTO entityToDto(Artist artist){
        if (artist == null) {
            throw new IllegalArgumentException(" objet artist  ne peut pas être null ");
        }

        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setId(artist.getId());
        artistDTO.setName(artist.getName() != null ? artist.getName() : null );
        artistDTO.setDescription(artist.getDescription() != null ? artist.getDescription() : null);
        artistDTO.setImageUrl(artist.getImageUrl() != null ? artist.getImageUrl() :null);
        return artistDTO;
    }


}
