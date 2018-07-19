package be.formation.backend.service;

import be.formation.backend.model.entity.Artist;

import java.util.List;

public interface ArtistService {
    /**
     * Registre a new Artist
     * @param name
     * @param desription
     * @param imageUrl
     * @return objet Artist
     */
    Artist registerArtist(String name, String desription, String imageUrl );
    /**
     *  update a artist
     * @param id
     * @param artist
     * @return objet Artist
     */
    public Artist UpdateArtist(Long id, Artist artist);

    /**
     * checking of artist if is delete or not whith  return boolean (true or false)
     * @param id
     * @return bojet boolean qui verifier si  artist est supprirme ou pas
     */
    boolean deleteArtist(long id );

}
