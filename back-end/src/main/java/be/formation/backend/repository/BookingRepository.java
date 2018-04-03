package be.formation.backend.repository;

import be.formation.backend.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository  extends JpaRepository<Booking, Long> {

}
