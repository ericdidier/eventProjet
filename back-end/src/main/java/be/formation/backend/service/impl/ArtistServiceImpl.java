package be.formation.backend.service.impl;

import be.formation.backend.model.entity.Artist;
import be.formation.backend.repository.ArtistRepository;
import be.formation.backend.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ArtistServiceImpl.class);


    @Override
    public Artist registerArtist(String name, String desription, String imageUrl) {
        LOGGER.info("Creating a new Artist entry by using information: {}", name + "," + desription + "," + imageUrl);
        Artist artist = new Artist();
        artist.setName(name);
        artist.setDescription(desription);
        artist.setImageUrl(imageUrl);
        return artistRepository.save(artist);
    }

    @Override
    public Artist UpdateArtist(Long id, Artist artist) {
        LOGGER.info("update a Artist entry by using information: {}", id);
        Optional<Artist> oArtist = artistRepository.findById(id);
        if (oArtist.isPresent()) {
            oArtist.get().setName(artist.getName());
            oArtist.get().setDescription(artist.getDescription());
            oArtist.get().setImageUrl(artist.getImageUrl());
        }
        Artist arts = artistRepository.save(oArtist.get());
        LOGGER.info("update a 'Artist' entry by using information: {}", arts);
        return arts;
    }

    @Override
    public boolean deleteArtist(long id) {
        LOGGER.info("Delete a Artist entry by using information : {}", id);
        Optional<Artist> a = artistRepository.findById(id);
        if (a.isPresent()){
            artistRepository.delete(a.get());
            LOGGER.info("deleted a Artist entry: {}", id);
            return true;
        } else {
            LOGGER.info("Unable to delete. Artist with id {} not found", id);
            return false;
        }
    }
}