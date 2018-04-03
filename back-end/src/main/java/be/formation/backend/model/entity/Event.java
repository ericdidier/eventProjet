package be.formation.backend.model.entity;

import be.formation.backend.converter.LocalDateTimeAttributeConverter;
import be.formation.backend.converter.TypeEventConverter;
import be.formation.backend.enums.TypeEventEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * classe qui permet de definir Event.
 */
@Entity
public class Event  extends  BaseEntity {

    private String  tilte ;

    private String description ;

    private  boolean ticketsAvailable;

    @Column(nullable = true)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDate dateTimeEvent;

    @Column(nullable = true, length = 15)
    @Convert(converter = TypeEventConverter.class)
    private TypeEventEnum typeEvent;

     @OneToMany(mappedBy = "event")
     private List<Booking> bookings;

     @ManyToOne(cascade = {CascadeType.REMOVE})
     private Venue venue ;

     @ManyToMany
     private List<Artist> artists;

     private double price ;

     private boolean enabled;

    public Event() {
    }


    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTicketsAvailable() {
        return ticketsAvailable;
    }

    public void setTicketsAvailable(boolean ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

    public LocalDate getDateTimeEvent() {
        return dateTimeEvent;
    }

    public void setDateTimeEvent(LocalDate dateTimeEvent) {
        this.dateTimeEvent = dateTimeEvent;
    }

    public TypeEventEnum getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(TypeEventEnum typeEvent) {
        this.typeEvent = typeEvent;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
