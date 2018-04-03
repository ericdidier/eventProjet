package be.formation.backend.repository;

import be.formation.backend.model.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
