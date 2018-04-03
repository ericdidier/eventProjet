package be.formation.backend.repository;

import be.formation.backend.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
