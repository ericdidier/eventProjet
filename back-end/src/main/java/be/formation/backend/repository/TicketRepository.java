package be.formation.backend.repository;

import be.formation.backend.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
