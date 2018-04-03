package be.formation.backend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 *  classe qui permet de definir
 */
@Entity
public class Ticket extends   BaseEntity{

    @Column(unique = true)
    private UUID reference;

    @ManyToOne
    private Booking booking;

    public Ticket(){
        this.reference = UUID.randomUUID();
    }


    public UUID getReference() {
        return reference;
    }

    public void setReference(UUID reference) {
        this.reference = reference;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
