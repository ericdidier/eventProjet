package be.formation.backend.controller;

import be.formation.backend.mapper.VenueMapper;
import be.formation.backend.model.dto.VenueDTO;
import be.formation.backend.model.entity.Venue;
import be.formation.backend.service.VenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class VenueController {

    private final Logger LOG = LoggerFactory.getLogger(VenueController.class);
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping("/registreVenue")
    public VenueDTO register(@RequestBody VenueDTO venueDTO) {
        VenueDTO venueDTO1 = new VenueDTO();
        LOG.info("creating new user: {}", venueDTO);
        Venue created = venueService.registerVenue(venueDTO.name, venueDTO.city);
        return VenueMapper.EntityToDto(created);
    }


    @PutMapping("/modifyVenue/{id}")
    public VenueDTO update(@PathVariable("id") int id, @RequestBody VenueDTO venueDTOInput) {
        Venue venue1 = new Venue();
        VenueDTO venueDTO1 = new VenueDTO();

        LOG.info("updating venue: {}", venueDTOInput.name + " " + venueDTOInput.city);

        venue1.setName(venueDTOInput.getName());
        venue1.setCity(venueDTOInput.getCity());
        Venue currentVenue = venueService.UpdateVenue(Long.valueOf(id), venue1);
        if (currentVenue == null) {
            LOG.info("Venue with id {} not found", id);
            return venueDTOInput;
        } else {
            venueDTO1 = VenueMapper.EntityToDto(currentVenue);
        }
        return venueDTO1;
    }






}
