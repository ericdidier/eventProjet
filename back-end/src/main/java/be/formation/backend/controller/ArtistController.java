package be.formation.backend.controller;

import be.formation.backend.mapper.ArtistMapper;
import be.formation.backend.model.dto.ArtistDTO;
import be.formation.backend.model.entity.Artist;
import be.formation.backend.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ArtistController {

    private final Logger LOG = LoggerFactory.getLogger(ArtistController.class);

    @Autowired
    private  ArtistService artistService;




    // =========================================== Create New Artist ========================================//

    @PostMapping("/registreArtist")
    public ArtistDTO registre(ArtistDTO artistDTO) {
        LOG.info("creating new artist: {}", artistDTO);
        Artist artist = artistService.registerArtist(artistDTO.name, artistDTO.description, artistDTO.imageUrl);
        return ArtistMapper.entityToDto(artist);
    }

    // =========================================== Update Existing Artist ===================================//

    @PutMapping("/modifyArtist/{id}")
    public ArtistDTO updateArtist(@PathVariable("id") int id, @RequestBody ArtistDTO artistDTO) {
        LOG.info("updating venue: {}", artistDTO.name + " " + artistDTO.description + " " + artistDTO.imageUrl);
        Artist artist = artistService.UpdateArtist(Long.valueOf(id), ArtistMapper.dtoToEntity(artistDTO));
        return ArtistMapper.entityToDto(artist);
    }

    @DeleteMapping("/deleteArtist/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable(value = "id") Long artistId) {
        boolean foundDelete =  artistService.deleteArtist(artistId);
        if (foundDelete == false ){
            LOG.info("Unable to delete. artist with id {} not found", artistId);
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
}

