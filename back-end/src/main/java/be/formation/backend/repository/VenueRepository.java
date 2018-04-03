package be.formation.backend.repository;

import be.formation.backend.model.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
